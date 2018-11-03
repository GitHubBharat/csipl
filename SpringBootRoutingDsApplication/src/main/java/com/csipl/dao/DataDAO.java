package com.csipl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DataDAO extends JdbcDaoSupport {

	@Autowired
	public DataDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<String> queryCompany() {
		String sql = "Select name from company";

		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
		return list;
	}

	public List<String> queryEmployees() {
		String sql = "Select name from employees";

		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
		return list;
	}

	public List<SchemaInfo> querySchemaInfo() {
		SchemaInfo si = new SchemaInfo();
		String sql = " select * from SCHEMA_INFO";
		/*
		 * Map<String, Object> list = null; list =
		 * this.getJdbcTemplate().queryForMap(sql, si.getClassName(),String.class);
		 * return list;
		 */

		return this.getJdbcTemplate().query("select * from SCHEMA_INFO", new RowMapper<SchemaInfo>() {
			@Override
			public SchemaInfo mapRow(ResultSet rs, int rownumber) throws SQLException {
				SchemaInfo e = new SchemaInfo();
				e.setClassName(rs.getString(1));
				e.setUrl(rs.getString(2));
				e.setUser(rs.getString(3));
				e.setPwd(rs.getString(4));

				return e;
			}
		});

		// List<SchemaInfo> list = this.getJdbcTemplate().queryForList(sql,
		// SchemaInfo.class);

	}

}
