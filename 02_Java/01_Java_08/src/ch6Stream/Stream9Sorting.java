package ch6Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream9Sorting {

	public static void main(String[] args) {
		Employee emp1 = new Employee(101, "Rajesh", 5000);
		Employee emp2 = new Employee(102, "Vaishnav", 2000);
		Employee emp3 = new Employee(103, "Yash", 6000);
		Employee emp4 = new Employee(104, "Kavita", 7000);
		Employee emp5 = new Employee(105, "Meena", 1000);
		
		List<Employee> lstEmpl = Arrays.asList(emp1, emp2, emp3, emp4, emp5);
		
		//lstEmpl.stream().forEach(System.out::println);
		
	/*	List<Employee> lstSorted =  lstEmpl.stream().
			sorted((o1, o2) -> (int)o1.getEmp_Salary() - o2.getEmp_Salary())
			.collect(Collectors.toList());*/
		
		List<Employee> lstSorted =  lstEmpl.stream().
				sorted(Comparator.comparing(Employee::getEmp_Salary))
				.collect(Collectors.toList());
		
		System.out.println("After Sorting: ");
		lstSorted.stream().forEach(System.out::println);
		
		//descending order using comparator
		List<Employee> lstDescending =  lstEmpl.stream().
				sorted((o1, o2) -> (int) o2.getEmp_Salary() - o1.getEmp_Salary())
				.collect(Collectors.toList());
		System.out.println("After Reversing: ");
		lstDescending.stream().forEach(System.out::println);
	}

}
