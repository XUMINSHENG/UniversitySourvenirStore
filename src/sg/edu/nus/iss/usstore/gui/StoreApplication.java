package sg.edu.nus.iss.usstore.gui;


import java.io.FileNotFoundException;
import java.util.List;

import sg.edu.nus.iss.usstore.dao.ProductDao;
import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.Store;
import sg.edu.nus.iss.usstore.exception.DataInputException;
import sg.edu.nus.iss.usstore.exception.LoginException;

public class StoreApplication {

	private Store store;
	//private LoginScreen loginScreen;
	//private MainMenu mainMenu;
	//private CheckOutScreen checkOutScreen;
	//private MemberListScreen memberListScreen;
	//private ProductListScreen productListScreen;
	//private CategoryListScreen categoryListScreen;
	
	public StoreApplication(){
		// instantiate attributes
		store = new Store();
		
		
		
	}
	
	public void startup(){
		// load date
		// show login screen
	}
	
	public void shutdown(){
		// save data
		
	}
	
	public void login(String username, String password){
		// authority check
		try {
			store.login(username, password);
		} catch (LoginException e) {
			
			e.printStackTrace();
			return;
		}
		
		
		// hide login screen 
		System.out.println("hide login screen");
		
		// show main menu
		System.out.println("show main menu");
	}
	
	public void showMainMenu(){
		// show main menu
	}
	
	public void checkOut(){
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		StoreApplication manager = new StoreApplication();
		manager.startup();	
		
		
		
		ProductDao pd = new ProductDao();
		try {
			List<Product> dataList = pd.loadDataFromFile();
			
			pd.saveDataToFile(dataList);
			
		} catch (DataInputException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
