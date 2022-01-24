package ch2Clone;

class Test implements Cloneable
{
	int i = 5;
	int j = 10;
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	@Override
	public String toString() {
		return "Test [i=" + i + ", j=" + j + "]";
	}
	
	
}
public class DeepVsShallowCopy {

	public static void main(String[] args) throws CloneNotSupportedException{
		
		//creating object for Test
		Test obj = new Test();
		obj.i = 20;
		obj.j = 30;

		//shallow copy demo
		//assigning the obj to another object
		Test objNew = obj;
		objNew.i = 25;
		System.out.println(" obj: "+obj);
		System.out.println(" New obj: "+objNew);
		//from output it is clear that both are reference same object in heap
		
		
		//deep copy
		Test objDeep = new Test();
		objDeep.i = obj.i;
		objDeep.j = obj.j;
		System.out.println("\n obj: "+obj);
		System.out.println(" Deep obj: "+objDeep);
		
		//3rd way - clone
		//combination of both shallow and deep copy
		Test objClone = (Test) obj.clone();
		objClone.i = 40;
		objClone.j = 50;
		System.out.println("\n obj: "+obj);
		System.out.println(" Clone obj: "+objClone);
	}

}
