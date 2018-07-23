package com.training.spring.core;

import com.training.spring.core.injectiontypes.autowired.BinarySearchImpl;
import com.training.spring.core.injectiontypes.autowired.BubbleSortAlgorithm;
import com.training.spring.core.injectiontypes.autowired.SortAlgorithm;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.training.spring.core.injectiontypes")
public class SpringCoreBasicApplication {

	@Bean(name="sa")
	SortAlgorithm sortAlgorithm(){
		BubbleSortAlgorithm bsa = new BubbleSortAlgorithm();
		return bsa;
	}

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(
				SpringCoreBasicApplication.class)) {

			BinarySearchImpl binarySearch =
					applicationContext.getBean(BinarySearchImpl.class);

			BinarySearchImpl binarySearch1 = 
					applicationContext.getBean(BinarySearchImpl.class);

			System.out.println(binarySearch);
			System.out.println(binarySearch1);

			int result = binarySearch.binarySearch(new int[] { 12, 4, 6, 3 }, 3);
			System.out.println("Search result: " + result);


			System.out.println(binarySearch.getSa());
		}
	}
}