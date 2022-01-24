package ch2Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	
	public static void main(String[] args) {

		//map is a interface
		Map<String, String> mp = new HashMap<>();
		
		mp.put("Name", "Rajesh");
		mp.put("Sports", "Cricket");
		mp.put("Sports", "Athletis");
		mp.put("Gender", "Male");
		mp.put(null	, "32");
		mp.put("Daughter", null);
		
		//keySet is a Set
		//no duplicates
		Set<String> keys = mp.keySet();
		
		// in HashMap
		// order is not maintained
		// duplicate is not allowed
		//one null key is allowed
		//multiple null values are allowed
		//not synchronized
		for(String key: keys)
			System.out.println("Key: "+key+
					" Value: "+mp.get(key));
	}

}
