package ch4ConsumerInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConsImpl implements Consumer<Integer>
{
	public void accept(Integer i)
	{
		System.out.println("II: "+i);
	}
}
public class DemoConsumerInterface 
{
	public static void main(String args[])
	{
		List<Integer> lstNumbers = Arrays.asList(5,2,9);
		
		//forEach in Java 8 - Internal Loop - using lambda
		lstNumbers.forEach(i -> System.out.println("I: "+i));
		
		//creating a object for Consumer Class
		Consumer<Integer> c = new ConsImpl();
		lstNumbers.forEach(c);
		
		//another way using anonymous object
		Consumer<Integer> c1 = new Consumer<Integer>()
				{
					public void accept(Integer i)
					{
						System.out.println("III: "+i);
					}
				};
		lstNumbers.forEach(c1);
	}
}
