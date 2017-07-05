package com.practice.files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReadWriteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File fin = new File("D:\\XmlInputTest.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder document = factory.newDocumentBuilder();
			Document doc = document.parse(fin);
			doc.getDocumentElement().normalize();
			System.out.println(doc.toString());
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("root");
			int size = nList.getLength();
			int i = 0;
			while (i < size) {
				System.out.println("The attribure list is .." + nList.item(i).getNodeName() + "..."
						+ nList.item(i).getNodeValue());
				i++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
