package ch6Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {

	public static void main(String args[])
	{
	
		List<String> citylist = Arrays.
				asList("delhi", "mumbai", "hyderabad", "ahmedabad", "indore", "patna");		
		
		List<String> cityInCapslist = citylist.stream()
										.map(String::toUpperCase)
										.collect(Collectors.toList()); 
		
	}
}
