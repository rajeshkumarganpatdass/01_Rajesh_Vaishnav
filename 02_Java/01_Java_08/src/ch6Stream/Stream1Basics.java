package ch6Stream;

import java.util.ArrayList;
import java.util.List;

public class Stream1Basics {
	public static void main(String args[])
	{
		List<Integer> lstNumbers = new ArrayList<Integer>();
		
		for(int i=0; i <= 15; i++)
			lstNumbers.add(i*2);
		
		//normal for loop - 1st way -External loop
		for(int i=0; i < lstNumbers.size(); i++)
			System.out.println(lstNumbers.get(i));
		
		//enhanced for loop - 2nd way - External loop
		for(int i : lstNumbers)
			System.out.println(i);
		
		//forEach in Java 8 - Internal Loop - lambda
		lstNumbers.forEach(i -> System.out.println(i));
		
		//forEach Using method reference
		lstNumbers.forEach(System.out::println);
		
		//forEach using stream with lambda
		lstNumbers.stream().forEach(i -> System.out.println(i));
		
		//forEach using stream with method reference
		lstNumbers.stream().forEach(System.out::println);
	}

}
