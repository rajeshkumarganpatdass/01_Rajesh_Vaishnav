package ch2Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortByLastDigit implements Comparator<Integer>
{
	@Override
	public int compare(Integer i, Integer j) {
		// if greater, return positive value
		//if equal, return 0
		//if less, return negative value
		if(i%10 > j%10)
			return 1;
		else if(i%10  < j%10)
			return -1;
		else 
			return 0;
	}
	
}
public class ComparatorTraditional {
	
	public static void main(String[] args) {
		
		List<Integer> values = new ArrayList<Integer>();

		values.add(542);
		values.add(661);
		values.add(128);
		values.add(925);

		//create object for class
		//which implements comparator
		
		SortByLastDigit c = new SortByLastDigit();
				
		Collections.sort(values, c);
		//	Collections.sort(values, new SortByLastDigit());
		
		System.out.println("Ascending Order");
		for (Integer i : values)
			System.out.println("For Loop: " + i);
	}

}
