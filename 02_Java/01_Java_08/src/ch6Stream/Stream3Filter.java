package ch6Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Stream3Filter {
	
	public static void main(String args[])
	{
		List<Integer> lstNumbers = Arrays.asList(4,10,12,15,22,25,20);
		//add all the number which are divisible by 5
		int result = 0;
		
		//traditional approach
		for(int i: lstNumbers)
		{
			if( i%5 == 0)
				result = result + i;
		}
		System.out.println("Result: "+result);
		
		//using stream, filter, reduce
		result = lstNumbers.stream()
					.filter(i -> i%5 == 0)
					.reduce(0, Integer::sum);
		
		System.out.println("Result using stream is: "+result);
		
		//implementing predicate method for filter
		Predicate<Integer> objPredicate = new Predicate<Integer>()
				{
					public boolean test(Integer i)
					{
						return ( i % 5 == 0);
					}
				};
		
		result = lstNumbers.stream()
				.filter(objPredicate)
				.reduce(0, Integer::sum);
		System.out.println("Result using objPredicate is: "+result);
	}
}
