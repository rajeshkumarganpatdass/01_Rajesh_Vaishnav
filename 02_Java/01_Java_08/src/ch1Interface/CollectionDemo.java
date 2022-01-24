package ch1Interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionDemo {

	public static void main(String[] args) {

		List<Integer> values = new ArrayList<Integer>();
		values.add(542);
		values.add(661);
		values.add(128);
		values.add(925);

		// to sort based on last digit
		Comparator<Integer> c = new Comparator<Integer>() {
			public int compare(Integer i, Integer j) {
				// if greater, return positive value
				// if equal, return 0
				// if less, return negative value
				if (i % 10 > j % 10)
					return 1;
				else if (i % 10 < j % 10)
					return -1;
				else
					return 0;
			}
		};
		//values.sort(c);
		Collections.sort(values, c);

		//using lambda
		Comparator<Integer> c2 = (i, j) -> 
				i%10 > j%10 ? 1 : i%10 < j%10 ? -1 : 0;
		Collections.sort(values, c2);

		System.out.println("Lambda Order");
		for (Integer i : values)
			System.out.println("For Loop: " + i);

	}

}
