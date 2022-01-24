package ch2Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericListDemo {

	public static void main(String[] args) {
		
		List<Integer> values = new ArrayList<Integer>();

		values.add(10);
		values.add(15);
		values.add(12);

		// adding value by index
		values.add(2, 20);

		// ways to print values
		System.out.println("Values: " + values);

		// printing using iterator
		Iterator<Integer> it = values.iterator();
		while (it.hasNext())
			System.out.println("Iterator: " + it.next());
		
		//in list order is maintained
		for (Integer i : values)
			System.out.println("For Loop: " + i);
	}

}
