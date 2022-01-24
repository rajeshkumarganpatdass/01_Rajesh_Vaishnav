package ch2Collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MapHashTable {

	public static void main(String[] args) {


		//map is a interface
		Map<String, String> mp = new Hashtable<>();
		
		mp.put("Name", "Rajesh");
		mp.put("Sports", "Cricket");
		mp.put("Sports", "Athletis");
		mp.put("Gender", "Male");
		//mp.put(null	, "32");
		//mp.put("Daughter", null);
		
		//keySet is a Set
		//no duplicates
		Set<String> keys = mp.keySet();
		
		// in HashMap
		// order is not maintained
		// duplicate is not allowed
		// null key is not allowed
		// null values are not allowed
		//synchronized
		for(String key: keys)
			System.out.println("Key: "+key+
					" Value: "+mp.get(key));
	

	}

}
