package ch1;

class Animal
{
	static
	{
		System.out.println("3. Inside Animal Static");
	}
	//Instance initializer
	{
		System.out.println("5. Animal Instance");
	}
	Animal()
	{
		System.out.println("6. Animal class constructor");
	}
}

class Cow extends Animal
{
	static
	{
		System.out.println("4. Inside Cow Static");
	}
	//Instance initializer
	{
		System.out.println("7. Cow Instance");
	}
	Cow()
	{
		System.out.println("8. Cow class constructor");
	}
}

public class StaticVsInstanceVsConst {

	static
	{
		System.out.println("1. Inside StaticVsInstanceVsConst static ");
	}
	public static void main(String[] args) {
		
		System.out.println("2. Main Method");
		Cow Obj = new Cow();
		System.out.println("9. After Creating Cow object");

	}

}
