package ch1;

interface Phone
{
	void call();
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
	}
}
