package ch2Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetBasicHashSet {

	public static void main(String[] args) {

		Set<Integer> values = new HashSet<>();

		System.out.println(values.add(87));
		System.out.println(values.add(97));
		System.out.println(values.add(34));
		System.out.println(values.add(97));
		
		// in HashSet
		// order is not maintained
		// duplicate is not allowed
		// unsorted
		for (Integer i : values)
			System.out.println("For Loop: " + i);
		
		Set<Integer> treeSet = new TreeSet<>();

		System.out.println(treeSet.add(10));
		System.out.println(treeSet.add(15));
		System.out.println(treeSet.add(12));
		System.out.println(treeSet.add(15));

		// in TreeSet
		// order is not maintained
		// duplicate is not allowed
		// sorted order
		for (Integer i : treeSet)
			System.out.println("TreeSet: " + i);
		
		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		System.out.println(linkedHashSet.add(10));
		System.out.println(linkedHashSet.add(17));
		System.out.println(linkedHashSet.add(12));
		System.out.println(linkedHashSet.add(15));
		
		// in LinkedHashSet
		// insertion order is  maintained
		// duplicate is not allowed
		// unsorted
		for (Integer i : linkedHashSet)
			System.out.println("LinkedHashSet: " + i);

	}

}
