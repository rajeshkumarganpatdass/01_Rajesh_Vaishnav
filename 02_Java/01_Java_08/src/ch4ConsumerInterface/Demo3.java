package ch4ConsumerInterface;

//Java Program to demonstrate
//Consumer's andThen() method

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Demo3 {
	public static void main(String args[])
	{

		// Consumer to multiply 2 to every integer of a list
		Consumer<List<Integer> > modify = list ->
		{
			for (int i = 0; i < list.size(); i++)
			{
				list.set(i, 2 * list.get(i));
				System.out.println("Inside modify object: " + list.get(i));
			}
		};

		// Consumer to display a list of integers
		Consumer<List<Integer> >
			dispList = list -> list.stream().forEach(a -> System.out.println(a + " "));

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(3);

		// using addThen()
		modify.andThen(dispList).accept(list);
		//only addThen() method is incomplete, 
		//it should be followed by another method
				
		
		// Consumer to multiply 2 to every integer of a list
		Consumer<List<Integer> > consumer1 = list2 ->
		{
			for (int i = 0; i < list2.size(); i++)
			{
				list2.set(i, 2 * list2.get(i));
				System.out.println("Inside consumer1 object: " + list2.get(i));
			}
		};

		// Creating Consumer to display a list of integers		
		//passing a consumer object and returns a consumer
		Consumer<List<Integer> >
		consumer2AddThen = consumer1.andThen(dispList);
		

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		list2.add(6);
		list2.add(7);

		// using accept()
		consumer2AddThen.accept(list2);
		
		
	}
}
