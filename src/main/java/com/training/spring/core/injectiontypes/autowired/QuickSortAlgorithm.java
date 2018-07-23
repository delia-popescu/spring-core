package com.training.spring.core.injectiontypes.autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm {
	public int[] sort(int[] numbers) {
		System.out.println("Sorting numbers using QuickSortAlgorithm");
		// Logic for Quick Sort
		return numbers;
	}
	
	public String toString() {
		return "QuickSortAlgorithm";
	}
}
