package sg.edu.nus.iss.usstore.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class BaseDao {
	
	private static final String C_DataFolderPath = "./data/";
	
	/**
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> loadDataFromFile(String filename) throws IOException{
		
		ArrayList<String> stringList = new ArrayList<String>();
		
		File inFile = new File(C_DataFolderPath + filename);
		FileReader fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		while ((line = br.readLine()) !=null ){
			//System.out.println(line);
			stringList.add(line);
		}
		
		br.close();
		fr.close();
		
		return stringList;
	}
	
	/**
	 * 
	 * @param filename
	 * @param dataList
	 * @throws FileNotFoundException 
	 */
	public void saveDataToFile(String filename ,ArrayList<String> stringList) throws FileNotFoundException{
		File outFile = new File(C_DataFolderPath + filename);
		PrintWriter pw = new PrintWriter(outFile);
		
		for (String line : stringList){
			pw.println(line);
		}
		pw.flush();
		
		pw.close();
		
	}

	
}
