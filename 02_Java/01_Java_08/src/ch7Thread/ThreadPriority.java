package ch7Thread;

public class ThreadPriority {

	public static void main(String[] args) throws Exception {
		//creating runnable object
		Runnable run1 = () ->
		CreatingThreadUsingExtendThread.show("Hi Class");
		//more simpler		
		Runnable run2 = () ->
		CreatingThreadUsingExtendThread.show("Hello Class");
		
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);

		System.out.println("t1 default name: "+t1.getName());
		t1.start();

		//setting Thread Name
		t1.setName("Thread 1");
		System.out.println("t1 set name: "+t1.getName());
		
		//default priority
		System.out.println("t1 default priorty: "+t1.getPriority());
		
		//setting priority
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("t1 default priorty: "+t1.getPriority());
		// in order to provide gap, delay
		Thread.sleep(500);
		t2.start();
		
		System.out.println("Bye");

	}

	public static void show(String str) {
		for (int i = 0; i < 5; i++) {
			System.out.println(str);
			try {Thread.sleep(1000);} 
			catch (Exception e) {}
		}
	}





}
