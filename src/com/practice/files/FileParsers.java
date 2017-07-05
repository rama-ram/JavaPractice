package com.practice.files;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class FileParsers {
	static public void main(String[] arg) {
		try {
			String xmlFile = "D:/xmlTest.xml";
			File file = new File(xmlFile);
			if (file.exists()) {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(xmlFile);
				// Create transformer
				Transformer tFormer = TransformerFactory.newInstance().newTransformer();
				// Output Types (text/xml/html)
				tFormer.setOutputProperty(OutputKeys.METHOD, "text");
				// Write the document to a file
				Source source = new DOMSource(doc);
				// Create File to view your xml data as
				// vk.txt/vk.doc/vk.xls/vk.shtml/vk.html)
				Result result = new StreamResult(new File("D:/outputXml.txt"));
				tFormer.transform(source, result);
				System.out.println("File creation successfully!");
			} else {
				System.out.println("File not found!");
			}
		} catch (Exception e) {
			System.err.println(e);
			System.exit(0);
		}
	}
}