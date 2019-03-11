import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStringReplacement {
	
	
	public static void main(String [] args){
		
		
		try {
			FileReader fileName = new FileReader( new File ("D:/myNewCloudProject/resources/OrchStorageRemoteSnapshotNormalVolume.json"));
			String temp,totalStr="";
			
			 try (BufferedReader br = new BufferedReader(fileName)) {

			        while ((temp = br.readLine()) != null) {
			            totalStr += temp;
			        }
			        totalStr = totalStr.replaceAll("%shape", "oc3");
			        System.out.println(totalStr);
			       
			        
			    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
//			
//			System.out.println("file before replacement....." );
//			String file = fileName.toString();
//			System.out.println(file );
//			file.replaceAll("$shape", "oc3");
//			
//			System.out.println("file after replacement....." );
//			System.out.println(file );
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
