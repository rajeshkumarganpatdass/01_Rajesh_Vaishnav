package ch6Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Stream6Map {

	public static void main(String[] args) {
		List<Integer> lstMarks = Arrays.asList(55,65,70,85);
		
		System.out.println("Actual Marks");
		lstMarks.stream()
				.forEach(System.out::println);
		
		List<Integer> lstupdatedMarks;
		
		lstupdatedMarks = lstMarks.stream()
				.map(i -> i+5)
				.collect(Collectors.toList());
		
		System.out.println("Updated Marks");
		
		lstupdatedMarks.stream()
				.forEach(System.out::println);
		
		//using map interface implementation
		Function<Integer, Integer> funObj = 
				new Function<Integer, Integer>()
		{
			public Integer apply(Integer i )
			{
				return i = i + 2;
			}
		};
		
		lstupdatedMarks = lstMarks.stream()
				.map(funObj)
				.collect(Collectors.toList());
		
		System.out.println("Revised Marks");
		lstupdatedMarks.stream()
				.forEach(System.out::println);

	}

}
