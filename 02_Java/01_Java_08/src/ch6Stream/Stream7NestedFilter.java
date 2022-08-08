package ch6Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class CGIEmployee
{
	int emp_id;
	String emp_name;
	int emp_age;
	Salary emp_salary;
	
	public CGIEmployee(int emp_id, String emp_name, int emp_age, Salary emp_salary) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_age = emp_age;
		this.emp_salary = emp_salary;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", "
				+ "emp_name=" + emp_name + ", emp_age=" + 
				emp_age + ", emp_salary="
				+ emp_salary.toString() + "]";
	}
	
}

class Salary
{
	int base_salary;
	int fixed_salary;
	int variable_salary;
	
	public Salary(int base_salary, int fixed_salary, int variable_salary) {
		super();
		this.base_salary = base_salary;
		this.fixed_salary = fixed_salary;
		this.variable_salary = variable_salary;
	}

	@Override
	public String toString() {
		return "Salary [base_salary=" + base_salary + ", "
				+ "fixed_salary=" + fixed_salary + ", "
				+ "variable_salary=" + variable_salary + "]";
	}
	
	
	
}
public class Stream7NestedFilter {
	
	public static void main(String[] args) {
		
		List<CGIEmployee> lstEmployee = new ArrayList<CGIEmployee>();
		
		Salary objs1 = new Salary(10000,1000,2000);
		Salary objs2 = new Salary(20000,2000,4000);
		Salary objs3 = new Salary(30000,3000,6000);
		Salary objs4 = new Salary(40000,4000,8000);
		
		lstEmployee.add(new CGIEmployee(1, "Rajesh", 32, objs1));
		lstEmployee.add(new CGIEmployee(2, "Vaishnav", 20, objs2));
		lstEmployee.add(new CGIEmployee(3, "Abdul", 31, objs3));
		lstEmployee.add(new CGIEmployee(4, "Alex", 34, objs4));
		
		List<CGIEmployee> lstFinal = new ArrayList<CGIEmployee>();
		//to filter elements greater than 20K
		for(CGIEmployee emp: lstEmployee)
		{
			if(emp.emp_salary.base_salary > 20000)
			{
				lstFinal.add(emp);
			}
		}
		
		//to print values
		System.out.println("Method 1");
		lstFinal.forEach(emp -> 
			{
				System.out.println(emp.toString());
			});
		
		//using stream and filter
		lstFinal = lstEmployee.stream()
				.filter(emp -> emp.emp_salary.base_salary > 20000)
				.collect(Collectors.toList());
		
		System.out.println("Method 2");
		lstFinal.forEach(emp -> 
		{
			System.out.println(emp.toString());
		});
		
		//to create predicate object for filter method
		//implementing predicate method for filter
		Predicate<CGIEmployee> objPredicate = new Predicate<CGIEmployee>()
			{
				public boolean test(CGIEmployee emp)
				{
					return ( emp.emp_salary.base_salary> 20000);
				}
			};
				
		lstFinal = lstEmployee.stream()
				.filter(objPredicate)
				.collect(Collectors.toList());
		
		System.out.println("Method 3 ");
		lstFinal.forEach(emp -> 
		{
			System.out.println(emp.toString());
		});
	
	}

}
