package com.training.spring.core.dependencyinjection.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentDAO {

	ComponentJdbcConnection jdbcConnection;
	LombokComponentJdbcConnection lombokComponentJdbcConnection;

	public ComponentDAO(ComponentJdbcConnection jdbcConnection, LombokComponentJdbcConnection lombokComponentJdbcConnection) {
		this.jdbcConnection = jdbcConnection;
		this.lombokComponentJdbcConnection = lombokComponentJdbcConnection;
	}

	public ComponentJdbcConnection getJdbcConnection() {
		return jdbcConnection; 
	}

	@Autowired
	public void setComponentJdbcConnection(ComponentJdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}

	public LombokComponentJdbcConnection getLombokComponentJdbcConnection() {
		return lombokComponentJdbcConnection;
	}

	public void setLombokComponentJdbcConnection(LombokComponentJdbcConnection lombokComponentJdbcConnection) {
		this.lombokComponentJdbcConnection = lombokComponentJdbcConnection;
	}
}
