package ch6Stream;

import java.util.Arrays;
import java.util.List;

public class Stream4FindFirst {

	public static void main(String args[])
	{
		List<Integer> lstNumbers = Arrays.asList(4,10,12,15,22,25,20);
		//List<Integer> lstNumbers = Arrays.asList(9,19,28);
		//multiple all by 2 and find the first number  
		//which is divisible by 5
		int result = 0;
		
		//traditional approach
		for(int i: lstNumbers)
		{
			i = i * 2;
			if( i%5 == 0)
			{
				result = i;
				break;
			}
		}
		System.out.println("Result: "+result);
		
		//using stream, map, filter 
		result = lstNumbers.stream()
					.map(i -> i*2)
					.filter(i -> i%5 == 0)
					.findFirst()
					.orElse(0);
		
		System.out.println("Result using findFirst is: "+result);
		
		
	}
}
