package com.training.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.training.spring.core.componentscan.ComponentDAO;


@Configuration
@ComponentScan("com.training.spring.core.componentscan")
public class SpringCoreComponentScanApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringCoreComponentScanApplication.class);

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringCoreComponentScanApplication.class)) {
			ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);

			LOGGER.info("DAO:  - {}", componentDAO);
			LOGGER.info("JDBC COMPONENT:  - {}", componentDAO.getJdbcConnection());
		}
	}
}