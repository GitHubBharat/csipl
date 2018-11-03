package com.csipl.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.csipl.dao.DataDAO;
import com.csipl.dao.SchemaInfo;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationEvent> {
	@Autowired
	private DataDAO dataDAO;

	
	private SchemaInfo si=new SchemaInfo();
	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		System.out.println("ApplicationStartup.onApplicationEvent()");
		List<SchemaInfo> list = null;
		list = dataDAO.querySchemaInfo();
		for (SchemaInfo object : list) {
			System.out.println("onApplicationEvent()" + object.getClassName() + " ,"
					+ object.getUrl() + " ," + object.getUser() + " ," + object.getPwd());
			si.setClassName(object.getClassName());
			si.setPwd(object.getPwd());
			si.setUrl(object.getUrl());
			si.setUser( object.getUser());
		}
	}
	
	
	@Bean(name = "dataSource3")
	public DataSource getDataSource2() throws SQLException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(si.getClassName());
		dataSource.setUrl(si.getUrl());
		dataSource.setUsername(si.getUser());
		dataSource.setPassword(si.getPwd());

		System.out.println("## DataSource2: " + dataSource);

		return dataSource;
	}

}
