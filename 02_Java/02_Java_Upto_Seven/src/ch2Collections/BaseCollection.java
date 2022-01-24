package ch2Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BaseCollection {

	public static void main(String args[])
	{
		Collection values = new ArrayList();
		
		values.add(10);values.add(15);
		values.add(12);values.add("Hello");
		
		//ways to print values
		System.out.println("Values: "+values);
		
		//printing using iterator
		Iterator it = values.iterator();
		while(it.hasNext())
			System.out.println("Iterator: "+it.next());
		
		for(Object o: values)
			System.out.println("For Loop: "+o);
	}

}
