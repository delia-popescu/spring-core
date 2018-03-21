package com.training.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.spring.core.xml.XmlPersonDAO;

public class SpringCoreXMLContextApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringCoreScopeApplication.class);

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {

			LOGGER.info("Beans Loaded -> {}", (Object) applicationContext.getBeanDefinitionNames());

			XmlPersonDAO personDao = applicationContext.getBean(XmlPersonDAO.class);

			LOGGER.info("Person DAO :  - {}", personDao);
			LOGGER.info("JDBC connection :  - {}", personDao.getXmlJdbcConnection());
		}
	}
}