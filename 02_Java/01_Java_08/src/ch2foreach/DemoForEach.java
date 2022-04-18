package ch2foreach;

import java.util.Arrays;
import java.util.List;

public class DemoForEach {

	public static void main(String args[])
	{
		List<Integer> lstNumbers = Arrays.asList(5,2,9);
		
		//normal for loop - 1st way -External loop
		for(int i=0; i < lstNumbers.size(); i++)
		{
			System.out.println(lstNumbers.get(i));
		}
		
		//enhanced for loop - 2nd way - External loop
		for(int i : lstNumbers)
		{
			System.out.println(i);
		}
		
		//forEach in Java 8 - Internal Loop
		lstNumbers.forEach(i -> System.out.println(i));
		
			
	}
}
