package ch1;

class A
{
	int numA = 5;
	public A()
	{
		System.out.println("Inside A Constructor");
	}
	public A(int a)
	{
		System.out.println("Inside Arg A Constructor");
	}
	public void show()
	{
		System.out.println("Inside A Show: "+numA);
	}
	
}

class B extends A
{
	int numB = 10;
	public B()
	{
		//complier adds super();
		System.out.println("Inside B Constructor");
	}
	public B(int b)
	{
		//here also complier adds default constructor
		//super();
		//if we want t0 add arg constructor, then
		//add as super(i);
		System.out.println("Inside Arg B Constructor");
	}
	public void show()
	{
		System.out.println("Inside B Show: "+numA +" : "+numB);
	}
	
}
public class RuntimePolymorphismDemo {
	
	public static void main(String args[])
	{
		//B objB = new B();
		B objB2 = new B(5);
		
		//run time polymorphisim
		A obj = new B();
		obj.numA = 15;
		obj.show();
	}

}
