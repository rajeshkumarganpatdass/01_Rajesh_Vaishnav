package ch6Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class Stream2Reduce {

	public static void main(String args[])
	{
		List<Integer> lstNumbers = Arrays.asList(3,6,8,10);
		
		//traditional way
		int result = 0;
		for(int i: lstNumbers)
		{
			result = result + i*2;
		}
		
		//using stream with map and reduce (aggregation) demo
		result = lstNumbers.stream().map(i -> i*2).reduce(0, (c,e) -> (c+e));
		
		System.out.println("Result: "+result);
		
		//breaking the single line of code for understanding
		
		Stream<Integer> sObj = lstNumbers.stream();
		
		Function<Integer, Integer> funObj = new Function<Integer, Integer>()
				{
					public Integer apply(Integer i )
					{
						return i = i*2;
					}
				};
				
		//Need Function object
		Stream<Integer> s2Obj = sObj.map(funObj);
		
		BinaryOperator<Integer> biFunObj = new BinaryOperator<Integer>()
				{
					public Integer apply(Integer i, Integer j)
					{
						return i + j;
					}
				};
		
		//Need BinaryOperator Object
		result = s2Obj.reduce(0, biFunObj);
		
		System.out.println("Result is: "+result);
		
		//using stream with map, reduce and pre defined sum method
		result = lstNumbers.stream()
						.map(i -> i*2)
						.reduce(0, (c,e) -> Integer.sum(c, e));
		System.out.println("Result Integer.sum is: "+result);
		
		//using stream with map, reduce and pre defined sum method
		//method reference
		result = lstNumbers.stream()
						.map(i -> i*2)
						.reduce(0, Integer::sum);
		System.out.println("Result Integer::sum is: "+result);
		
	}
}
