package com.practice.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SerialisationDemo {
	// private Map<Integer, String> map1 = new HashMap();
	Tester map1 = new Tester();

	private void add(String name) {
		map1.name = name;
		// map1.put(EmpIdGenerator.generateEmpId(), name);
	}

	private void persistMap() throws IOException {
		FileOutputStream file = new FileOutputStream(new File("D://testMap"));
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(map1);
		out.close();
		file.close();

	}

	private void printMap() {
		System.out.println(" map is " + map1.toString());
		// for (Map.Entry m : map1.entrySet()) {
		// System.out.println("key : " + m.getKey() + " value : " +
		// m.getValue());
		// }
	}

	private void getMap() throws IOException, ClassNotFoundException {
		System.out.println("retrieving map******");
		FileInputStream file = new FileInputStream(new File("D://testMap"));
		ObjectInputStream out = new ObjectInputStream(file);
		HashMap<Integer, String> map2 = (HashMap) out.readObject();
		for (Map.Entry m : map2.entrySet()) {
			System.out.println("key : " + m.getKey() + " value : " + m.getValue());
		}
		out.close();

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerialisationDemo dem = new SerialisationDemo();
		dem.add("test1");
		dem.add("test2");
		dem.add("test3");
		dem.printMap();
		dem.persistMap();
		// dem.getMap();
	}

}

class Tester {
	public String name;
	public int id;

	@Override
	public String toString() {
		return "Tester [name=" + name + ", id=" + id + "]";
	}

}

class EmpIdGenerator {
	static private int empIdGenerator = 0;

	static public int generateEmpId() {
		return ++empIdGenerator;
	}
}
