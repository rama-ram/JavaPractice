package com.practice.misc;

import java.util.HashMap;
import java.util.Map;

public class HashMapNullTest {
	private static HashMap<String, String> cache = new HashMap<String, String>();

	public static void main(String[] args) {
		cache.put("test1", "value1");
		cache.put("test2", "value2");
		cache.put("test3", "value3");

		System.out.println("Printing the values stored in cache: ");
		for (Map.Entry<String, String> map : cache.entrySet()) {
			System.out.println("key : " + map.getKey() + " value : " + map.getValue());
		}
		System.out.println("Printing the values stored in cache based on key:		 ");

		System.out.println("Value for the key test 1 is " + cache.get("test1"));
		System.out.println("Value for the key test 4 is " + cache.get("test4"));
		if (cache.get("test4") == null)
			System.out.println("The Key is not found in the cache");

	}

}
