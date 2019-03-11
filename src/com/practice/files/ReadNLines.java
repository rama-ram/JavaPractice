package com.practice.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadNLines {

	static void isPrime(int n) {
		boolean prime = true;
		for (int j = 2; j < n; j++) {
			if (n % j == 0) {
				prime = false;
				break;
			}
		}
		System.out.println("isPrime ? " + prime);

	}

	static void findLastNLines(int n, String fileName) {
		try {
			// RandomAccessFile file = new RandomAccessFile(fileName, "rw");
			Scanner file = new Scanner(new File(fileName));
			Queue<String> list = new LinkedList<>();
			while (file.hasNextLine()) {
				if (list.size() == n)
					list.remove();
				list.add(file.nextLine());
			}
			file.close();
			System.out.println("the last few lines are :" + list.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
		// readlines(5, "D:/fileTester/testFiletoplevel.txt");
		findLastNLines(5, "D:/fileTester/testFiletoplevel.txt");
		isPrime(18);
	}

}
