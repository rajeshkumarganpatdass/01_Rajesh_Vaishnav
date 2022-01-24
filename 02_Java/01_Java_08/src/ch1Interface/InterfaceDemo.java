package ch1Interface;

interface Phone
{
	void call();
	default void message()
	{
		System.out.println("Message Sent");
	}
	static void WhatsApp()
	{
		System.out.println("Whatsapp");
	}
}

//we cannot have two public classes in same file
class AndroidPhone implements Phone
{
	@Override
	public void call() {
		System.out.println("Calling");
	}
}

public class InterfaceDemo {
	
	public static void main(String args[])
	{
		Phone phoneObj = new AndroidPhone();
		phoneObj.call();
		phoneObj.message();
		Phone.WhatsApp();
	}
}