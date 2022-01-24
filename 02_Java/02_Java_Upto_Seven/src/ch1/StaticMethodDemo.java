package ch1;

class Student
{
	int id;
	String name;
	static String college_name = "Anna University";
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public static void changeCollege(String newCollegeName)
	{
		college_name = newCollegeName;
	}

	public void print(Student s1)
	{
		System.out.println("id: "+s1.id);
		System.out.println("Name: "+s1.name);
		System.out.println("College: "+Student.college_name);
	}
}
public class StaticMethodDemo {

	public static void main(String args[])
	{
		Student rajesh = new Student(1, "rajesh");
		
		System.out.println("Printing Student details");
		rajesh.print(rajesh);
		
		System.out.println("Changing College Name");
		Student.changeCollege("Swami Vivekananda");
		
		System.out.println("Printing Student details updated");
		rajesh.print(rajesh);
		
		//object can access static method but not recommended
		rajesh.changeCollege("Guru Nanak");
		rajesh.print(rajesh);
		
		//object can access static variable but not recommended
		rajesh.college_name = "Test";
		rajesh.print(rajesh);
	}
}
