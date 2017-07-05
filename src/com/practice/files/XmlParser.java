package com.practice.files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.xerces.util.XMLStringBuffer;

public class XmlParser {

	// bit wise addition

	static int add(int x, int y) {
		// Iterate till there is no carry
		while (y != 0) {
			// carry now contains common set bits of x and y
			int carry = x & y;

			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y;

			// Carry is shifted by one so that adding it to x gives the required
			// sum
			y = carry << 1;
		}
		return x;
	}

	static void writeToXML(String xmlFile) {

		File file = new File(xmlFile);

		XMLStringBuffer xbuf = new XMLStringBuffer();
		xbuf.append("values");

		xbuf.addEmptyElement("root");
		Properties p = new Properties();
		p.setProperty("attr1", "value");
		p.setProperty("attr2", "value");
		p.setProperty("attr3", "value");
		xbuf.push("CHILD1", p);
		xbuf.pop();
		xbuf.push("CHILD2", p);
		xbuf.pop();
		xbuf.pop();
		try {
			FileWriter fout = new FileWriter(file);
			fout.write(xbuf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String file = "D:/test.xml";
		System.out.println("the sum is ..." + add(5, 6));
		// parsefile(file);

	}
}
