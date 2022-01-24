package ch1;

class Calculator
{
	public void add(int i, int j)
	{
		int result = i+j;
		System.out.println("Add: "+result);
	}
	public void subtract(int i, int j)
	{
		int result = i-j;
		System.out.println("Subtract: "+result);
	}
}

class AdvanceCalculator extends Calculator
{
	public void multiply(int i, int j)
	{
		int result = i*j;
		System.out.println("Multiplication: "+result);
	}
}
public class InheritanceDemo {

	public static void main(String[] args) {
		
		AdvanceCalculator advCalcObj = new AdvanceCalculator();
		advCalcObj.add(5, 9);
		advCalcObj.subtract(9, 5);
		advCalcObj.multiply(5, 9);
	}

}
