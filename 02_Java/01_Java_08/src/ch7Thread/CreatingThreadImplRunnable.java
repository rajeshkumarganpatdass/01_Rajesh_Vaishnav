package ch7Thread;

class Class1 implements Runnable {
	public void run() {
		CreatingThreadUsingExtendThread.show("Hi Class");
	}
}

class Class2 implements Runnable {
	public void run() {
		CreatingThreadUsingExtendThread.show("Hello Class");
	}
}

public class CreatingThreadImplRunnable {
	public static void main(String[] args) throws Exception {
		// without using thread concept
		Class1 obj1 = new Class1();
		Class2 obj2 = new Class2();

		// we dont have start method inside Runnable
		//obj1.start();
		
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		
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
