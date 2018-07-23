package com.training.spring.core.injectiontypes.autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 

	@Autowired
	@Qualifier("quick")
	private SortAlgorithm sortAlgorithm;

	@Autowired
	@Qualifier("sa")
	private SortAlgorithm sa;

	public SortAlgorithm getSortAlgorithm() {
		return sortAlgorithm;
	}

	public SortAlgorithm getSa() {
		return sa;
	}

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		sortAlgorithm.sort(numbers);
		System.out.println("Searching number : " + numberToSearchFor);
		// Search the array
		return 3;
	}


	@PostConstruct
	public void postConstruct() {
		logger.info("PostConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		logger.info("PreDestroy");
	}

}
