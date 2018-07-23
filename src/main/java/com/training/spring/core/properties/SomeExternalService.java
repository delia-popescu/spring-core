package com.training.spring.core.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeExternalService {
	
	@Value("${external.service.url}")
	private String url;

	@Value("${inexistent.property:default value}")
	private String inexistentProperty;

	@Value("${list.values}")
	private String[] valuesList;
	
	public String returnServiceURL(){
		return url;
	}

	public String getInexistentProperty() {
		return inexistentProperty;
	}

	public String[] getValuesList() {
		return valuesList;
	}
}
