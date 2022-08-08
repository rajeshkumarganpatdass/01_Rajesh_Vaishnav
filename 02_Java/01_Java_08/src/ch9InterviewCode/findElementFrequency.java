package ch9InterviewCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class findElementFrequency {
	
	public static void main(String args[])
	{
		ArrayList<Integer> lstNumbers = new ArrayList<>();
		
		lstNumbers.add(9); lstNumbers.add(1); lstNumbers.add(2);
		lstNumbers.add(2); lstNumbers.add(2); lstNumbers.add(1);
		
		Map<Integer, Integer> hmNumbers = new HashMap<>();
		int count = 1;
		
		for(int i : lstNumbers )
		{
			//System.out.println("I value: "+i);
			if(hmNumbers.containsKey(i))
			{
				count = hmNumbers.get(i) + 1;
			}
			hmNumbers.put(i, count);
		}
		
		hmNumbers.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		Map<Integer, Long> frequency = lstNumbers.stream().
                collect(Collectors.groupingBy
                		(Integer::intValue, Collectors.counting()));
		
		frequency.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		ArrayList<String> lstFruits = new ArrayList<>();
		
		lstFruits.add("Apple"); lstFruits.add("Banana"); lstFruits.add("Mango");
		lstFruits.add("Mango"); lstFruits.add("Apple"); lstFruits.add("Apple");
		
		Map<String, Long> fruitsFrequency = lstFruits.stream().
                collect(
                		Collectors.groupingBy(
                		Function.identity(), Collectors.counting()
                		)
                );
		fruitsFrequency.forEach((k, v) -> System.out.println((k + ":" + v)));
	}

}
