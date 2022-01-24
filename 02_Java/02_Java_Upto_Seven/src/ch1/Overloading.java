package ch1;



class Adder
{  
	int add(int a, int b)
	{
		return a+b;
	}  
	int add(int a, int b, int c)
	{
		int result = a+b-c;
		return result;
	}  
}  

public class Overloading {
	public static void main(String[] args) 
	{
		Adder obj = new Adder();
		System.out.println(obj.add(4, 5));
		System.out.println(obj.add(4, 5, 6));

	}

}
