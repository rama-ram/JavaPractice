package com.practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ListLambda {

	static void listL() {
		List<String> lst1 = (List<String>) Arrays.asList("test", "test2", "test3");
		for (String s : lst1)
			System.out.print(s + " ");
		System.out.println();

		// // lambda approach
		// lst1.stream().forEach(s -> {
		// System.out.print(s + " ");
		// });
		// System.out.println();
		// // using filters
		// lst1.stream().filter(u -> u.contains("test2")).forEach(s -> {
		// System.out.print(s + " ");
		// });
		// // using predicate
		// System.out.println();
		// filter(lst1, (s) -> s.toString().contains("test2"));
		// System.out.println();
		// // combining predicates
		// System.out.println();

		Predicate<String> lenfilter = (n) -> n.contains("test2");
		Predicate<String> filter = (n) -> n.toString().length() >= 3;
		filter(lst1, lenfilter.and(filter));
		System.out.println();
	}

	public static void filter(List list, Predicate condition) {
		list.stream().forEach(s -> System.out.print(condition.test(s) + " "));
	}

	public static void main(String[] args) {
		listL();
	}

}
