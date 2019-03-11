package com.practice.parsers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Simple {
}

public class TestMethod {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> c = Class.forName("com.practice.reflections.TestMainClass");
		TestMainClass tc = (TestMainClass) c.newInstance();
		System.out.println("THE FIELDS ARE ");
		Field[] flds = c.getFields();
		for (Field fld : flds)
			System.out.println(fld);
		Method[] mthds = c.getDeclaredMethods();
		for (Method mthd : mthds)
			System.out.println(mthd);
		Method m1 = c.getDeclaredMethod("testMathod", String.class);
		m1.setAccessible(true);
		m1.invoke(tc, "textTTRIAL");
	}

}
