package ch7Thread;

class Hii extends Thread 
{	
	public void run()
	{
		CreatingThreadUsingExtendThread.show("Hi Class");
	}
}
class Helloo extends Thread
{
	public void run()
	{
		CreatingThreadUsingExtendThread.show("Hello Class");
	}
}
public class CreatingThreadUsingExtendThread {
	public static void main(String[] args) throws Exception {
		//without using thread concept
		Hii obj1 = new Hii();
		Helloo obj2 = new Helloo();
		
		//use start() method, to make it as Thread
		obj1.start();
		
		//in order to provide gap, delay
		Thread.sleep(500);
		obj2.start();
		
		System.out.println("Main");
		
	}
	
	public static void show(String str)
	{
		for(int i=0; i<5; i++)
		{
			System.out.println(str);
			try { Thread.sleep(1000);} 
			catch (Exception e) {};
		}
	}
}
