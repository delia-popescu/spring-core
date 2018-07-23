package com.training.spring.core;

import com.training.spring.core.injectiontypes.resource.FileService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@Configuration
@ComponentScan("com.training.spring.core.injectiontypes.resource")
public class SpringCoreResourceApplication {

	@Bean
	public File namedFile() {
		File namedFile = new File("nameFile.txt");
		return namedFile;
	}
	
	@Bean
	public File defaultFile() {
		File defaultFile = new File("defaultFile.txt");
		return defaultFile;
	}

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringCoreResourceApplication.class)) {
			FileService fileService = applicationContext.getBean(FileService.class);

			System.out.println(fileService.getFile());
			System.out.println(fileService.getDefaultFile());
		}
	}
}