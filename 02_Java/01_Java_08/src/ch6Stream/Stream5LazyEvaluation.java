package ch6Stream;

import java.util.Arrays;
import java.util.List;

public class Stream5LazyEvaluation {

	public static void main(String args[]) {
		List<Integer> lstNumbers = Arrays.asList(4, 10, 12, 15, 22, 25, 20);
		// multiple all by 2 and find the first number
		// which is divisible by 5
		int result = 0;

		// traditional approach
		//in our case , it iterates two times
		for (int i : lstNumbers) {
			i = i * 2;
			System.out.println("For Loop:");
			if (i % 5 == 0) {
				result = i;
				break;
			}
		}
		System.out.println("Result: " + result);

		//map, filter uses lazy evaluation
		//they execute only when required
		//findFirst is a terminal operation
		//and it runs first
		//using stream, map, filter
		result = lstNumbers.stream().
				map(Stream5LazyEvaluation::doubleIt).
				filter(Stream5LazyEvaluation::isDivisible).
				findFirst().
				orElse(0);
		System.out.println("Result using method ref is: " + result);
	}

	public static Integer doubleIt(int i)
	{
		System.out.println("Inside doubleIt Method");
		return i = i*2;
	}
	
	public static boolean isDivisible(int i)
	{
		System.out.println("Inside isDivisible Method");
		return (i%5 == 0);
	}
}
