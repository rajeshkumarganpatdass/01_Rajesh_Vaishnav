package ch5MethodReference;

import java.util.Arrays;
import java.util.List;

public class DemoMethodRef3 {
	
	public static void main(String args[])
	{
		List<Integer> lstNumbers = Arrays.asList(5,2,9);
		
		DemoMethodRef3 obj = new DemoMethodRef3();
		
		//forEach with instance method reference
		lstNumbers.forEach(obj::doubleNumbers);
		
		
		//forEach with static method reference
		lstNumbers.forEach(DemoMethodRef3::printNumbers);
			
	}
	
	public static void printNumbers(int number)
	{
		System.out.println(number);
	}
	
	public void doubleNumbers(int number)
	{
		number = number * 2;
		System.out.println(number);
	}

}
