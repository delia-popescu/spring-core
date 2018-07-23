package com.training.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.training.spring.core.properties.SomeExternalService;

import java.util.Arrays;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class SpringCorePropertiesApplication {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringCorePropertiesApplication.class)) {
			SomeExternalService service = applicationContext.getBean(SomeExternalService.class);
			System.out.println(service.returnServiceURL());
			System.out.println(service.getInexistentProperty());
			System.out.println(Arrays.asList(service.getValuesList()));
		}
	}
}