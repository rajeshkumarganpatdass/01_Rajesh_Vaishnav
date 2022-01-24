package ch7Thread;

public class ThreadJoinDemo {


	public static void main(String[] args) throws Exception {
		//creating runnable object
		Runnable run1 = () ->
		CreatingThreadUsingExtendThread.show("Hi Class");
		//more simpler		
		Runnable run2 = () ->
		CreatingThreadUsingExtendThread.show("Hello Class");
		
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);

		t1.start();

		// in order to provide gap, delay
		Thread.sleep(500);
		t2.start();
		
		t1.join();
		t2.join();
		
		//to check is thread alive
		System.out.println("t1 status: "+t1.isAlive());
		System.out.println("t2 status: "+t2.isAlive());
		//bye need to be printed after
		//execution of both threads
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
