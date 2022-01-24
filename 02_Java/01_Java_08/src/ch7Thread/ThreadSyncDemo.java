package ch7Thread;

class Counter
{
	int count;
	
	public void increment()
	{
		count++;
	}
}
public class ThreadSyncDemo {
	
	public static void main(String[] args) throws Exception {
		
		Counter c = new Counter();
		
		Runnable run1 = () ->
			{
				for (int i = 0; i < 1000; i++) 
				{
					c.increment();
				}
			};
		//more simpler		
		Runnable run2 = () ->
		{
			for (int i = 0; i < 1000; i++) 
			{
				c.increment();
			}
		};
		
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);

		t1.start();
		//t1.join();
		
		t2.start();
		//t2.join();
		
		//join makes thread work independently
		System.out.println("Count: "+c.count);

	}

}
