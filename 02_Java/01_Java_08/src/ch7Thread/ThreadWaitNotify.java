package ch7Thread;

class Q
{
	int num;
	boolean setLock = false;
	
	public synchronized void put(int number) 
	{
		
		while(setLock)
		{
			try {wait();}
			catch(Exception e) {}
		}
		System.out.println("put : " + number);
		this.num = number;
		setLock = true;
		notify();
	}
	
	public synchronized void get() 
	{		
		while(!setLock)
		{
			try {wait();}
			catch(Exception e) {}
		}
		System.out.println("Get : "+num);	
		setLock = false;
		notify();
	}
}

class Producer implements Runnable
{
	Q q;
	public Producer(Q q) {		
		this.q = q;
	}

	public void run()
	{
		int i=0;
		while(true)
		{
			System.out.println("Inside Producer");			
			q.put(i++);
			try {Thread.sleep(4000);}
			catch(Exception e){}		
		}
	}
}

class Consumer implements Runnable
{
	Q q;
	public Consumer(Q q) {		
		this.q = q;
	}

	public void run()
	{		
		while(true)
		{
			System.out.println("Inside Consumer");
			q.get();
			try {Thread.sleep(5000);}
			catch(Exception e){}
		}
	}
}
public class ThreadWaitNotify {
	
	public static void main(String args[]) 
	{
		Q q = new Q();
		Thread t1 = new Thread(new Producer(q), "Producer");
		Thread t2 = new Thread(new Consumer(q), "Consumer");
		t1.start();
		t2.start();
	}

}
