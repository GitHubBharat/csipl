package com.csipl.rounting;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//This is a DataSource.
public class MyRoutingDataSource extends AbstractRoutingDataSource {

@Override
protected Object determineCurrentLookupKey() {

	if(RequestContextHolder.getRequestAttributes()!=null) {
   HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
         .getRequest();

   // See more: DataSourceInterceptor
   String keyDS = (String) request.getAttribute("keyDS");

   System.out.println("KeyDS=" + keyDS);

   if (keyDS == null) {
      keyDS = "COMPANY_DS";
   }

   return keyDS;
	}
	return "COMPANY_DS";
}

public void initDataSources(DataSource dataSource1, DataSource dataSource2) {
   Map<Object, Object> dsmap = new HashMap<Object, Object>();
   dsmap.put("COMPANY_DS", dataSource1);
   dsmap.put("EMPLOYEES_DS", dataSource2);

   this.setTargetDataSources(dsmap);
}

}
