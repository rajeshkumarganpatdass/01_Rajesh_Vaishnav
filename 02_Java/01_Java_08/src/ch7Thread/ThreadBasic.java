package ch7Thread;

class Hi
{
	public void show()
	{
		for(int i=0; i<5; i++)
		{
			System.out.println("Hi Class");
			try { Thread.sleep(1000);} 
			catch (Exception e) {};
		}
	}
}
class Hello
{
	public void show()
	{
		for(int i=0; i<5; i++)
		{
			System.out.println("Hello Class");
			try { Thread.sleep(1000);} 
			catch (Exception e) {};
		}
	}
}
public class ThreadBasic {
	public static void main(String[] args) {
		//without using thread concept
		Hi obj1 = new Hi();
		Hello obj2 = new Hello();
		
		obj1.show();
		obj2.show();
		
		System.out.println("Main");
		
	}

}
