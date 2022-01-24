package ch3lambda;
interface A1
{
	int add(int a, int b);		
}
class XYZ1 implements A1
{
	public int add(int a, int b)
	{
		int c= a+b;
		System.out.println("The sum of two number is "+c);
		return c;
	}		
}

public class DemoLambda {
	public static void main(String args[])
	{
		
		A1 objInterfaceA = new XYZ1();
		objInterfaceA.add(10, 5);
		
		A1 obj1InterfaceA = (a,b) -> 
				{
					int c1= a+b;
					System.out.println("The sum of two number is "+c1);
					return c1;
				};
		obj1InterfaceA.add(10,6);		
				
		//(parameter) -> { Method definition };
		//the above line indicates
		//a method of interface is defined with paramters in brackets
		
	}

}
