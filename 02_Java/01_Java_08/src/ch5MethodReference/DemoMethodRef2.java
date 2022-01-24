package ch5MethodReference;

interface Parser
{
	String parse(String str);
}
class ParserImpl implements Parser
{
	public String parse(String str)
	{
		return StringParser.convert(str);
	}
}
class StringParser //static method reference
{
	public static String convert(String str)
	{
		return (str.length() <= 3) ? str.toUpperCase() : str.toLowerCase();
	}
}
class StringParser2 //instance method reference
{
	public String convert(String str)
	{
		return (str.length() <= 3) ? str.toLowerCase() : str.toUpperCase();
	}
}

class MyPrinter
{
	public void print(String str, Parser p)
	{
		str = p.parse(str);
		System.out.println("String: "+str);
	}
}
public class DemoMethodRef2 
{
	public static void main(String args[])
	{
		String str1 = "Rajesh Vaishnav";
		
		MyPrinter mp = new MyPrinter();
		
		//traditional way Type 1
		//creating object for Parser interface
		Parser p = new ParserImpl();
		mp.print(str1, p);
		
		//traditional way Type 2
		//creating anonymous object for Parser interface
		mp.print(str1, new Parser()
				{
					public String parse(String str)
					{
						return StringParser.convert(str);
					}
				});
		
		//Using lambda in Java 8
		mp.print(str1, (String str) ->  StringParser.convert(str));
		
		//Using Method Reference in Java 8
		//Passing static method
		mp.print(str1, StringParser::convert);
		
		//for non static method, create object
		//invoke method using object reference
		StringParser2 obj = new StringParser2();
		mp.print(str1, obj::convert);
	}

}
