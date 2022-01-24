package ch7Thread;

public class CreatingThreadUsingLambda {

	public static void main(String[] args) throws Exception {
		//creating runnable object
		Runnable run1 = new Runnable()
			{
				public void run()
				{
					CreatingThreadUsingExtendThread.show("Hi Class");
				}
			};
		//more simpler		
		Runnable run2 = () ->
					CreatingThreadUsingExtendThread.show("Hello Class");
		
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);

		t1.start();

		// in order to provide gap, delay
		Thread.sleep(500);
		t2.start();
		System.out.println("Main");

	}

	public static void show(String str) {
		for (int i = 0; i < 5; i++) {
			System.out.println(str);
			try {Thread.sleep(1000);} 
			catch (Exception e) {}
		}
	}

}
