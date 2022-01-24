package ch7Thread;

class Count
{
	int count;
	
	public synchronized void increment()
	{
		count++;
	}
}
public class ThreadSyncDemo3 {
	
	public static void main(String[] args) throws Exception {
	//starting threads parallely using sync
	Count c = new Count();
	
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

	//starting both threads parallely
	t1.start();
	t2.start();
	
	//waiting both threads to die
	t1.join();
	t2.join();

	System.out.println("Count: "+c.count);
	}

}
