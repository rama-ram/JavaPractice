package com.practice.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerTest2 extends SerTest1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;

	@Override
	public String toString() {
		return id + " " + name + super.id + " " + super.name;
	}
}

public class SerTest1 {

	int id = 10;
	String name = "Test";

	public static void main(String[] args) throws FileNotFoundException, IOException {

		SerTest2 obj1 = new SerTest2();
		obj1.id = 100;
		obj1.name = "BeforeSerialize ";

		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("D://testSer1.txt")));
		oo.writeObject(obj1);

		ObjectInputStream oi = new ObjectInputStream(new FileInputStream(new File("D://testSer1.txt")));
		SerTest2 obj2;
		try {
			obj2 = (SerTest2) oi.readObject();
			System.out.println(obj2.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}