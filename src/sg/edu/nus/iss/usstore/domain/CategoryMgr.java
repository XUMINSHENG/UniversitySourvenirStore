package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.util.ArrayList;

import sg.edu.nus.iss.usstore.dao.CategoryDao;
import sg.edu.nus.iss.usstore.dao.VendorDao;
import sg.edu.nus.iss.usstore.exception.DataFileException;

/**
 * 
 * @author Xu Minsheng
 *
 */
public class CategoryMgr {
	private ArrayList<Category> categoryList;
	// this VendorList only exist for maintain data consistency
	// for example, if CLO and MUG share one vendor Nancy's , 
	// then in CLO and MUG, their vendors should reference to same instance of vendor  
	private ArrayList<Vendor> vendorList;
	
	private CategoryDao categoryDao;
	private VendorDao vendorDao;
	
	public CategoryMgr() throws IOException, DataFileException{
		categoryDao = new CategoryDao();
		vendorDao = new VendorDao();
		loadData();
	}
	
	/**
	 * load data from file
	 * 
	 * @throws IOException
	 * @throws DataFileException
	 */
	public void loadData() throws IOException, DataFileException{
		// load category basic info.
		categoryList = categoryDao.loadDataFromFile();
		vendorList = vendorDao.loadDataFromFile(categoryList);
	}
	
	/**
	 * save data to file
	 * 
	 * @throws IOException
	 */
	public void saveData() throws IOException{
		categoryDao.saveDataToFile(categoryList);
		vendorDao.saveDataToFile(categoryList);
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public Category getCategoryByCode(String code){
		for(Category category : this.categoryList){
			if(category.getCode() == code){
				return category;
			}
		}
		return null;
	}
	
	public ArrayList<Category> getCategoryList(){
		return this.categoryList;
	}
	
	public ArrayList<Vendor> getVendorList(){
		return this.vendorList;
	}
}
