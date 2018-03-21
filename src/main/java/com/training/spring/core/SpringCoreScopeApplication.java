package com.training.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.training.spring.core.scope.PersonDAO;

@Configuration
@ComponentScan
public class SpringCoreScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringCoreScopeApplication.class);

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringCoreScopeApplication.class)) {

			PersonDAO personDao = applicationContext.getBean(PersonDAO.class);

			PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);

			LOGGER.info("{}", personDao);
			LOGGER.info("{}", personDao.getJdbcConnection());
			LOGGER.info("{}", personDao.getJdbcConnection());

			LOGGER.info("{}", personDao2);
			LOGGER.info("{}", personDao.getJdbcConnection());
		}
	}
}