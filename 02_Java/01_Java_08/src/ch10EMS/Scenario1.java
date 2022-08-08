package ch10EMS;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//How many male and female employees are there in the organization?
public class Scenario1 {

	
	/*
	For queries such as above where you need to group the input elements, 
	use the Collectors.groupingBy() method. 
	In this query, we use Collectors.groupingBy() method 
	which takes two arguments. 
	We pass Employee::getGender as first argument 
	which groups the input elements based on gender 
	and Collectors.counting() as second argument 
	which counts the number of entries in each group.
	*/
	public void howManyMaleAndFemaleEmployees()
	{
		List<Employee> employeeListLocal = CommonUtil.employeeList;
		Map<String, Long> noOfMaleAndFemaleEmployees=
				employeeListLocal.stream()
							.collect(Collectors.groupingBy(Employee::getGender, 
												Collectors.counting()));
				         
		System.out.println(noOfMaleAndFemaleEmployees);	
	}
}
