import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.plaf.FileChooserUI;

public class FileCreationTests {

	public static void fileOutputStreamReader(String filename) throws IOException
		{
		String arraytobewritten = "this is a test";
		System.out.println("provided file name is" + filename +"... and the contents to write to the file are" + arraytobewritten);
		FileOutputStream fout = new FileOutputStream(new File (filename));
		fout.write(arraytobewritten.getBytes());
		fout.close();
		System.out.println("starting to read the contents of the file " + filename);
		FileInputStream fin = new FileInputStream(filename);
		while (fin.available() != 0){
		System.out.print((char)fin.read());	
		}
		fin.close();
		
		}
public static void findWords(String fileName)
{

	try {
		FileInputStream fin = new FileInputStream(fileName);
		String filedebuglog="D:/debug.log";
		String fileinfolog="D:/info.log";
		FileWriter fout1 = new FileWriter(new File(filedebuglog));
		FileWriter fout2 = new FileWriter(new File(fileinfolog));
		BufferedWriter buffout1 = new BufferedWriter(fout1);
		BufferedWriter buffout2 = new BufferedWriter(fout2);
		Scanner scan = new Scanner(fin);
		ArrayList<String> arr = new ArrayList<String> ();
		while(scan.hasNext()){
			arr.add(scan.nextLine());
			}String info="",debug="";
		for (String line: arr)
		{
			if(line.contains("INFO")){
		
			info=info+""
					+ "\n"+line;
			}
			else if(line.contains("DEBUG")){
				
				debug=debug+"\n"+line;
				}
		}
		System.out.println("no of ERRORs in the file is: " + info);
		System.out.println("no of WARN in the file is: " + debug);
		
//		buffout1.write(info);
//		buffout2.write(debug);
//		buffout2.close();
//		buffout1.close();
		fout1.write(info);
		fout1.close();
		scan.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public static void bufferedOutputStreamReader(String filename) throws IOException
	{
		ArrayList<String> arr = new ArrayList<String>();ArrayList<Integer> arr1 = new ArrayList<Integer>(); 
		System.out.println("starting to read the contents of the file " + filename);
		FileInputStream fin = new FileInputStream(filename);
		Scanner b = new Scanner(fin);
						while(b.hasNextLine())
					arr.add(b.nextLine());
				for (String s: arr)
					System.out.print(s+"\t");
		System.out.println("sorted array s ...");
		Collections.sort(arr);
		for (String s: arr)
			System.out.print(s+"\t");
		FileWriter fout = new FileWriter(new File ("D:/outfileExcel.xls"));
			for (String s: arr)
				{fout.write(s);
				fout.write("\n");}
			fout.close();
		fin.close();
		}
	
	public static void readingfromDatabaseToExcel() throws SQLException, ClassNotFoundException{
		//get connection
		//initialsie driver
		
		Class.forName("com.jdbc.Driver");
		Connection conn = java.sql.DriverManager.getConnection("", "", "");
		java.sql.Statement stmnt = conn.createStatement();
		ResultSet result = stmnt.executeQuery("");
		result.next();
	}
	public static void bufferedOutputStreamIntReader(String filename) throws IOException
	{
		ArrayList<Integer> arr = new ArrayList<Integer>(); 
		System.out.println("starting to read the contents of the file " + filename);
		FileInputStream fin = new FileInputStream(filename);
		BufferedInputStream buffin = new BufferedInputStream(fin);
		while (buffin.available() !=0){
			arr.add(((buffin.read())));
			}
		for (Integer s: arr)
			System.out.print(s);
		Collections.sort(arr);
		for (Integer s: arr)
			System.out.print(s);
//	System.out.println("BufferedOutputStreamReader: provided file name is" + filename +"... and the contents to write to the file are" + arraytobewritten);
//	FileOutputStream fout = new FileOutputStream(new File (filename));
//	BufferedOutputStream bout = new BufferedOutputStream(fout);
//	bout.write(arraytobewritten);
//	fout.write(arraytobewritten.getBytes());
//	fout.close();
		fin.close();
		}
	
static void fileread(String filename, String filename2) throws IOException{
	FileInputStream fin = new FileInputStream("D:/textfrom.txt");
	FileOutputStream fout = new FileOutputStream("D:/textto.txt" );
	BufferedReader buffin = new BufferedReader(new InputStreamReader(fin));
	BufferedWriter buffout = new BufferedWriter(new FileWriter(new File ("D:/textto.txt")));
	String line = buffin.readLine();	
	System.out.println(new String(java.nio.file.Files.readAllBytes(Paths.get("D:/textfrom.txt"))));
	
	while (line != null && !line.contains("test"))
		{
		line = buffin.readLine();
		}
	
		while (line !=null)
		{
			buffout.write(line);
			
			buffout.write("\n");
			line = buffin.readLine();
		}		
		buffin.close();
		buffout.close();
		fout.close();
		}
	


	public static void main (String [] args){
//		int[] arr = new int[args.length];int i=0;
//		try {
////			fileOutputStreamReader("D:\\testfile.txt");
//			bufferedOutputStreamReader("D:\\testfile.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		   Scanner in =  new Scanner (System.in);
//	        int size = in.nextInt();in.nextLine();
//	        int[] arr1 = new int[size];
//	        System.out.println("size is " + size);
//	        while (size!=0){
//	        //while(in.hasNextInt()){
//	          //  arr[i]=in.nextInt();i++;}
//	            
//	            for (int k=0; k< size-1;k++)
//	            arr[k]=in.nextInt();
//	    for (int j : arr)
//	        System.out.print(j+"/t");
//		String word = "test";
////		int z =Integer.valueOf(word.charAt(0));
//		int z = 'z';
//		System.out.println(z);
//		int[] h = {3 ,1 ,3 ,1 ,4 ,1 ,3 ,2 ,5 ,5 ,5 ,5 ,5 ,5, 5, 5, 5 ,5 ,5 ,5 ,5 ,5 ,5, 5 ,5};
//		  findarea(h, "");
//				
//		try {
//			fileread("","");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    }
//	public static void findarea(int arr[],String word){
//        int size = word.length(); int max= 0; char[] chararr = word.toLowerCase().toCharArray();
//        for (char c:chararr){
//            if (max < arr[Integer.valueOf(c)-97]) max = arr[Integer.valueOf(c)-97];
//            
//        }
//        System.out.print(max * size * 1);
		findWords("D:/log.log");
		}
}
	
	
	
	

