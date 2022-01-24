package ch5MethodReference;

import java.util.Arrays;
import java.util.List;

public class DemoMethodReference {
	public static void main(String args[])
	{
		List<Integer> lstNumbers = Arrays.asList(5,2,9);
		
		//forEach in Java 8 - Internal Loop
		lstNumbers.forEach(i -> System.out.println(i));
		
		//printing using method reference
		lstNumbers.forEach(System.out::println);
			
	}

}
