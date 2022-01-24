package ch2Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListBasicSort {

	public static void main(String[] args) {
		
		List<Integer> values = new ArrayList<Integer>();

		values.add(10);
		values.add(20);
		values.add(12);
		values.add(16);

		Collections.sort(values);
		
		System.out.println("Ascending Order");
		for (Integer i : values)
			System.out.println("For Loop: " + i);
		
		Collections.reverse(values);
		
		System.out.println("Descending Order");
		for (Integer i : values)
			System.out.println("For Loop: " + i);

	}

}
