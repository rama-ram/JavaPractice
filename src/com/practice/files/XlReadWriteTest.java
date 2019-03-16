package com.practice.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class XlReadWriteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String xl = new String("D:\\xlinput.xls");
		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		map = readFromXLToHashMap(xl);
		String xl1 = new String("D:\\xlinput_new.xls");
		// write from map to an xl

	}

	static HashMap<Integer, ArrayList<String>> readFromXLToHashMap(String xl) {
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		try {
			FileInputStream file = new FileInputStream(new File(xl));

			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(0);
			int row = sheet.getRows();
			int col = sheet.getColumns();

			for (int i = 0; i < row; i++) {
				ArrayList<String> arr = new ArrayList<String>();
				for (int k = 0; k < col; k++) {
					arr.add(sheet.getCell(k, i).getContents());
				}
				map.put(i, arr);
			}

			System.out.println("Printing the hashmap");

			for (Map.Entry<Integer, ArrayList<String>> e : map.entrySet()) {
				System.out.println("Key is .." + e.getKey() + "..value is " + e.getValue());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	// static File readFromXLToHashMap(HashMap<Integer, ArrayList<String>> map)
	// {
	// XSSFWorkbook workbook = new XSSFWorkbook();
	// XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
	// Object[][] datatypes = {
	// {"Datatype", "Type", "Size(in bytes)"},
	// {"int", "Primitive", 2},
	// {"float", "Primitive", 4},
	// {"double", "Primitive", 8},
	// {"char", "Primitive", 1},
	// {"String", "Non-Primitive", "No fixed size"}
	// };
	//
	// int rowNum = 0;
	// System.out.println("Creating excel");
	//
	// for (Object[] datatype : datatypes) {
	// Row row = sheet.createRow(rowNum++);
	// int colNum = 0;
	// for (Object field : datatype) {
	// Cell cell = row.createCell(colNum++);
	// if (field instanceof String) {
	// cell.setCellValue((String) field);
	// } else if (field instanceof Integer) {
	// cell.setCellValue((Integer) field);
	// }
	// }
	// }
	//
	// try {
	// FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
	// workbook.write(outputStream);
	// workbook.close();
	// } catch (FileNotFoundException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// System.out.println("Done");
	// }
	// }

}
