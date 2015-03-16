package sg.edu.nus.iss.usstore.dao;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ProductDao extends BaseDao{

	private final String filename = "Products.dat";
	
	@Override
	public List<Object> loadDataFromFile() {
		
		Scanner in = null;
		
		try{
			
			File inFile = new File(super.getDatafolderpath() + this.filename);
			in = new Scanner(inFile);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		while (in.hasNextLine() ){
			String line = in.nextLine();
			System.out.println(line);
		}
		
		in.close();
		
		return null;
	}

	@Override
	public void saveDataToFile(List<Object> dataList) {
		
		
	}
	
	
	
	
	
	
}
