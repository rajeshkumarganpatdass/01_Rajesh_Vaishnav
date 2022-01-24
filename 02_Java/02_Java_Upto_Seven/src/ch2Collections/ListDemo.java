package ch2Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

	public static void main(String args[]) {
		List values = new ArrayList();

		values.add(10);
		values.add(15);
		values.add(12);
		values.add("Hello");

		// adding value by index
		values.add(2, 20);

		// ways to print values
		System.out.println("Values: " + values);

		// printing using iterator
		Iterator it = values.iterator();
		while (it.hasNext())
			System.out.println("Iterator: " + it.next());

		for (Object o : values)
			System.out.println("For Loop: " + o);
	}
}
