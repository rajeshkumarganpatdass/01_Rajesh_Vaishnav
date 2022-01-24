package ch2Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>
{
	int id, marks;
	String name;
	
	public Student(int id, String name, int marks) {
		super();
		this.id = id;
		this.marks = marks;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + 
				", marks=" + marks + ", "
						+ "name=" + name + "]";
	}

	@Override
	public int compareTo(Student o) {
		if (this.marks > o.marks)
			return 1;
		else if (this.marks < o.marks)
			return -1;
		else
			return 0;
		
	}
}

public class ComparablePlain {

	public static void main(String args[]) {
		List<Student> values = new ArrayList<Student>();
		values.add(new Student(1, "Rajesh", 65));
		values.add(new Student(4, "Yash", 95));
		values.add(new Student(3, "Abdul", 85));
		values.add(new Student(2, "Vaishnav", 75));

		for (Student stud : values)
			System.out.println("For Loop: " + stud);

		Collections.sort(values);

		for (Student stud : values)
			System.out.println("Sorting by marks: " + stud);

		// if we cannot change the Student class implementation
		// then we can add our own logic using comparator
		// to sort based on length of the name
		Comparator<Student> c = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				if (s1.name.length() > s2.name.length())
					return 1;
				else if (s1.name.length() < s2.name.length())
					return -1;
				else
					return 0;
			}
		};
		Collections.sort(values, c);

		for (Student stud : values)
			System.out.println("Sorting by name length: " + stud);
	}
}
