package ch3lambda;

import java.util.Arrays;
import java.util.List;

public class Sample {

	
	public static void main(String args[])
	{
		
		List<Employee> empList = Arrays.asList(
				new Employee(1, "Rajesh", 10000),
				new Employee(2, "Gopal", 20000),
				new Employee(3, "Krishna", 30000),
				new Employee(4, "Abdul", 40000),
				new Employee(5, "Azad", 50000));
		
		empList.stream()
				.filter(emp -> emp.getEmp_Salary() > 20000)
				.forEach(emp -> System.out.println(emp));
		
		
		
	}
}
