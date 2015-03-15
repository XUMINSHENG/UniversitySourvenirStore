package sg.edu.nus.iss.usstore.dao;

import java.util.List;

public abstract class BaseDao {
	
	private static final String C_DataFolderPath = "";
	
	
	public abstract List<Object> loadDataFromFile();
	
	public abstract void saveDataToFile(List<Object> dataList);

	public static String getDatafolderpath() {
		return C_DataFolderPath;
	}
	
}
