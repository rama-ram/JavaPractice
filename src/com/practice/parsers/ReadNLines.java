package com.practice.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadNLines {

	public static void readlines(int n, String filename) {
		String line32 = "";
		try {
			line32 = Files.readAllLines(Paths.get(filename)).get(n - 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Stream<String> lines = Files.lines(Paths.get(filename))) {
			List<String> collect = lines.skip(n).collect(Collectors.toList());
			Iterator<String> ite = collect.iterator();
			while (ite.hasNext())
				System.out.println(ite.next().toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("the file lines from " + n + " are ..");
		System.out.println(line32);
		//
	}

	public static void main(String[] args) {
		readlines(5, "D:/TestFile");
	}

}
