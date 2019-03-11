package com.practice.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class MyComparator implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 == o2)
			return 0;
		Map.Entry<Integer, String> k1 = (Entry) o1;
		Map.Entry<Integer, String> k2 = (Entry) o2;

		if (k1.getValue() == k2.getValue())
			return 0;
		return (k1.getValue().compareToIgnoreCase(k2.getValue()));

	}

}

public class HashMapSortBasedOnValue {
	static MyComparator mycmp = new MyComparator();

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(3, "test1");
		map.put(null, "test2");

		map.put(2, "test3");
		map.put(1, "test4");

		for (Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println("the key is :" + m.getKey() + " : The value is: " + m.getValue());

		}
		sortMapByValue(map);
	}

	private static void sortMapByValue(Map<Integer, String> map) {
		List<Entry<Integer, String>> list = new ArrayList(map.entrySet());
		Collections.sort(list, mycmp);

		Map<Integer, String> map2 = new LinkedHashMap();
		System.out.println("the hashmap in sorted form is :");
		for (Map.Entry<Integer, String> m : list) {
			map2.put(m.getKey(), m.getValue());
		}
		for (Map.Entry<Integer, String> m : map2.entrySet()) {
			System.out.println("the key is :" + m.getKey() + " : The value is: " + m.getValue());

		}

	}

}
