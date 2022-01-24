package ch3lambda;

interface A
{
	void show();
		
}

class XYZ implements A
{
	public void show()
	{
		System.out.println("Implementing Interface in traditional Way");
	}
		
}

public class WithoutLambda {
	
	public static void main(String args[])
	{
		//Type 1 - traditional approach
		//creating object for interface using child class
		//and invoking the method using traditional way
		A objInterfaceA = new XYZ();
		objInterfaceA.show();
		
		//Type 2 - creating anonymous object
		//creating anonymous object for interface
		A obj2InterfaceA = new A()
				{
					public void show()
					{
						System.out.println("Implementing using anonymous Object");
					}
				};
		obj2InterfaceA.show();
		
		//Type 3 - Using Lambda from Java 8
		//It can be used only in functional interface,
		//interface which has only one abstract method
		A obj3InterfaceA = () -> 
				{
					System.out.println("Implenting Using Lambda Expression");
				};
		obj3InterfaceA.show();		
				
		//(parameter) -> { Method definition };
		//the above line indicates
		//a method of interface is defined with paramEters in brackets
		
	}

}
