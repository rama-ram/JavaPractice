package com.practice.files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class JsonReadWriteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:\\JsonInputTest.json");
		JsonReader read = null;
		try {
			read = new JsonReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonParser parser = new JsonParser();
		JsonObject jobject = parser.parse(read).getAsJsonObject();
		try {
			FileWriter writeFile = new FileWriter(new File("D:\\JsonOutputTest.json"));
			Gson gson = new GsonBuilder().serializeNulls().create();
			String entity = gson.toJson(jobject);
			writeFile.write(entity);
			writeFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
