package com.training.spring.core;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.training.spring.core.resource.FileService;


@Configuration
@ComponentScan("com.training.spring.core.resource")
public class SpringCoreResourceApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringCoreResourceApplication.class);
	
	@Bean(name="namedFile")
	public File namedFile() {
		File namedFile = new File("nameFile.txt");
		return namedFile;
	}
	
	@Bean(name="defaultFile")
	public File defaultFile() {
		File defaultFile = new File("defaultFile.txt");
		return defaultFile;
	}

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringCoreResourceApplication.class)) {
			FileService fileService = applicationContext.getBean(FileService.class);

			LOGGER.info("File : {}", fileService.getFile());
			LOGGER.info("Default file : {}", fileService.getDefaultFile());
		}
	}
}