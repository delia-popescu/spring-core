package com.training.spring.core.injectiontypes.autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		System.out.println("Sorting using BubbleSortAlgorithm");
		// Logic for Bubble Sort
		return numbers;
	}
	
	public String toString() {
		return "BubbleSortAlgorithm";
	}
}
