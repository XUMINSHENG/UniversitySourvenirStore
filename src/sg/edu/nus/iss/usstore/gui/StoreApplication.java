package sg.edu.nus.iss.usstore.gui;


import java.io.IOException;

import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.Store;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataInputException;
import sg.edu.nus.iss.usstore.exception.LoginException;

/**
 * 
 * @author Xu Minsheng
 *
 */
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
		
		try {
			// instantiate store & load date
			store = new Store();
		} catch ( IOException | DataFileException e) {
			
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public void startup(){
		
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
	
	
	public void showProductScreen(){
		
	}
	
	public void addProduct(String name, String categoryCode, String briefDescription, 
			int quantityAvailable, double price, String barCode, int threshold, int orderQuantity){
		// 
		store.addProduct(name, categoryCode, briefDescription, quantityAvailable, price, barCode, threshold, orderQuantity);
		
		//
		
	}
	
	public static void main(String[] args) {
		StoreApplication manager = new StoreApplication();
		manager.startup();	
		
		manager.store.getProductList();
		manager.addProduct("NUS Logo Cup", "CUP", "NUS Logo Cup 300ml", 400, 5.8, "", 50, 200);
		
		System.out.println("helloworld");
	
	}
	
	
	

}
