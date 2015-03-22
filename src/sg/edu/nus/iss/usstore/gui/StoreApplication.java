package sg.edu.nus.iss.usstore.gui;


import java.io.IOException;
import java.util.ArrayList;

import sg.edu.nus.iss.usstore.domain.Category;
import sg.edu.nus.iss.usstore.domain.Member;
import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.Store;
import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataNotFoundException;

/**
 * Main method here
 * @author Xu Minsheng
 *
 */
public class StoreApplication {

	private Store store;
	private LoginScreen loginScreen;
	private StoreWindow storeWindow;
	
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
	
	/**
	 * 
	 */
	public void startup(){
		
		// show login screen
		loginScreen = new LoginScreen(this);
		loginScreen.setVisible(true);
	}
	
	/**
	 * 
	 */
	public void shutdown(){
		try {
			store.saveData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return 
	 */
	public boolean login(String username, String password){
		// authority check
		if (store.login(username, password) == true)
		{
			// close login screen 
			loginScreen.dispose();
			// show main menu
			storeWindow = new StoreWindow(this);
			storeWindow.setVisible(true);
			return true;
		}
		else
			return false;
	}
		
	public void checkOut(){
		this.store.checkout();
	}
	
	public void addBillItem(){
		
		Transaction transaction = null;
		String productId = null;
		int quantity = 0;
		
		try {
			this.store.addBillItem(transaction, productId, quantity);
		} catch (DataNotFoundException e) {
			// UI action
			
			e.printStackTrace();
		}
		
		// UI action
	}
	
	public void removeBillItem(){
		Transaction transaction = null;
		String productId = null;
		this.store.removeBillItem(transaction, productId);
		
		// UI action
	}
	
	public void setPayment(){
		Transaction transaction = null;
		double cash=0;
		int redeemLoyaltyPoint=0;
		this.store.setPayment(transaction, cash, redeemLoyaltyPoint);
		
		// UI action
	}
	
	public void confirmPayment(){
		Transaction transaction = null;
		this.store.confirmPayment(transaction);
		
		// UI action
	}
	
	public void addProduct(String name, String categoryCode, String briefDescription, 
			int quantityAvailable, double price, String barCode, int threshold, int orderQuantity){
		// 
		store.addProduct(name, categoryCode, briefDescription, quantityAvailable, price, barCode, threshold, orderQuantity);
		
		//
		
	}
	
	/**
	 * 
	 * @param product
	 */
	public void addProduct(Product product){
		store.addProduct(product);
	}
	
	/**
	 * 
	 * @param product
	 * @param indenx
	 */
	public void modifyProduct(Product product, int indenx){
		store.modifyProduct(product, indenx);
	}
	
	/**
	 * 
	 * @param index
	 */
	public void deleteProduct(int index){
		store.deleteProduct(index);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Product> getProductList(){
		return store.getProductList();
	}
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	public Product getProductById(String productId){
		return store.getProductById(productId);
	}
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	public Product getProductByBarCode(String barCode){
		return store.getProductByBarCode(barCode);
	}
	
	
	/**
	 * 
	 * @param memberId
	 * @return
	 */
	public Member getMemberById(String memberId){
		return store.getMemberById(memberId);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Member> getMemberList(){
		return store.getMemberList();
	}
	
	public ArrayList<Category> getCategoryList(){
		return store.getCategoryList();
	}
	
	
	
	public static void main(String[] args) {
		StoreApplication manager = new StoreApplication();
		manager.startup();	
		
		
//		manager.store.getProductList();
//		manager.addProduct("NUS Logo Cup", "CUP", "NUS Logo Cup 300ml", 400, 5.8, "", 50, 200);
//		
		System.out.println("helloworld");
		
		//manager.getCategoryList();
		//manager.shutdown();
	}

	public Store getStore() {
		return store;
	}

	public StoreWindow getStoreWindow() {
		return storeWindow;
	}
	

}
