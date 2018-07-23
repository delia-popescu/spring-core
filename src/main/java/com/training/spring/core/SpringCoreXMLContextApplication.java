package com.training.spring.core;

import com.training.spring.core.dependencyinjection.xml.XmlComponentDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringCoreXMLContextApplication {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {

			System.out.println(applicationContext.getBeanDefinitionNames());

			XmlComponentDAO componentDAO = applicationContext.getBean(XmlComponentDAO.class);

			System.out.println(componentDAO);
			System.out.println(componentDAO.getXmlJdbcConnection());
		}
	}
}