package com.practice.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class MyComparator1 implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		Map.Entry<Integer, String> e1 = (Map.Entry) o1;
		Map.Entry<Integer, String> e2 = (Map.Entry) o2;
		return e1.getKey().compareTo(e2.getKey());
	}

}

public class HashMapSortBasedOnKeys {
	private static MyComparator1 comp = new MyComparator1();

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(3, "test1");
		map.put(5, "test2");

		map.put(2, "test3");
		map.put(1, "test4");
		map.put(4, "testnull");
		System.out.println("Before sorting");
		for (Map.Entry<Integer, String> m : map.entrySet()) {
			System.out.println("the key is :" + m.getKey() + " : The value is: " + m.getValue());

		}

		sortedByKey(map);
	}

	public static void sortedByKey(Map map) {
		List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());
		Collections.sort(list, comp);
		LinkedHashMap<Integer, String> map2 = new LinkedHashMap<Integer, String>();
		for (Map.Entry<Integer, String> m : list) {
			map2.put(m.getKey(), m.getValue());
			System.out.println("added " + m.getKey() + "  : " + m.getValue());
		}
		System.out.println("after sorting");
		for (

		Map.Entry<Integer, String> m : map2.entrySet()) {
			System.out.println("the key is :" + m.getKey() + " : The value is: " + m.getValue());

		}

	}
}
