package com.training.spring.core;

import com.training.spring.core.scope.Person;
import com.training.spring.core.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class SpringCoreScopeApplication {

	@Bean
	@Scope("singleton")
	Person personSingleton(){
		return new Person();
	}

	@Bean
	@Scope("prototype")
	Person personPrototype(){
		return new Person();
	}


	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringCoreScopeApplication.class)) {

			PersonDAO personDao = applicationContext.getBean(PersonDAO.class);

			PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);

			System.out.println(personDao);
			System.out.println(personDao.getJdbcConnection());
			System.out.println(personDao.getJdbcConnection());

			System.out.println(personDao2);
			System.out.println(personDao.getJdbcConnection());

			Person p1 = (Person)applicationContext.getBean("personSingleton");
			Person p2 = (Person) applicationContext.getBean("personSingleton");

			p1.setName("Maria");
			System.out.println("p1 name: " + p1.getName());
			System.out.println("p2 name: " + p2.getName());

			Person p3 = (Person)applicationContext.getBean("personPrototype");
			Person p4 = (Person) applicationContext.getBean("personPrototype");

			p3.setName("Gigi");
			p4.setName("Titi");
			System.out.println("p3 name: " + p3.getName());
			System.out.println("p4 name: " + p4.getName());
		}
	}
}