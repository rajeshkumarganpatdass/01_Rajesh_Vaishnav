package ch6Stream;

class Employee
{
	int emp_id;
	String str_Emp_Name;
	int emp_Salary;
	
	public Employee(int emp_id, String str_Emp_Name, int emp_Salary) {
		super();
		this.emp_id = emp_id;
		this.str_Emp_Name = str_Emp_Name;
		this.emp_Salary = emp_Salary;
	}
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getStr_Emp_Name() {
		return str_Emp_Name;
	}
	public void setStr_Emp_Name(String str_Emp_Name) {
		this.str_Emp_Name = str_Emp_Name;
	}
	public int getEmp_Salary() {
		return emp_Salary;
	}
	public void setEmp_Salary(int emp_Salary) {
		this.emp_Salary = emp_Salary;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", "
				+ "str_Emp_Name=" + str_Emp_Name + 
				", emp_Salary=" + emp_Salary + "]";
	}
	
	
	
}
