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
		System.exit(0);
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
		
	public Transaction checkOut(){
		return store.checkout();
	}
	
	public Transaction setBillCustomer(Transaction transaction, String memberId){
		try {
			transaction = store.setBillCustomer(transaction, memberId);
		} catch (DataNotFoundException e) {
			e.printStackTrace();
		}
		return transaction;
	}
	
	public Transaction addBillItem(Transaction transaction,String productId,int quantity){
		try {
			transaction = store.addBillItem(transaction, productId, quantity);
		} catch (DataNotFoundException e) {
			// UI action
			
			e.printStackTrace();
		}
		return transaction;
	}
	
	public Transaction removeBillItem(Transaction transaction, String productId){
		transaction = store.removeBillItem(transaction, productId);
		return transaction;
	}
	
	public Transaction setPayment(Transaction transaction, double cash, int redeemLoyaltyPoint){
		return this.store.setPayment(transaction, cash, redeemLoyaltyPoint);
	}
	
	public Transaction confirmPayment(Transaction transaction){
		return store.confirmPayment(transaction);
	}
	

	
	public void addProduct(String name, String categoryCode, String briefDescription, 
			int quantityAvailable, double price, String barCode, int threshold, int orderQuantity){
		store.addProduct(name, categoryCode, briefDescription, quantityAvailable, price, barCode, threshold, orderQuantity);	
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
	public void modifyProduct(String name, String categoryCode, String briefDescription, 
			int quantityAvailable, double price, String barCode, int threshold, int orderQuantity,int index){
		store.modifyProduct(name, categoryCode, briefDescription, quantityAvailable, price, barCode, threshold, orderQuantity,index);
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
	 * @param barCode
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
		
		/*
		Transaction tr = manager.checkOut();
		tr = manager.setBillCustomer(tr, "F42563743156");
		
		tr = manager.addBillItem(tr, "MUG/1", 10);
		tr = manager.addBillItem(tr, "STA/1", 20);
		tr = manager.removeBillItem(tr, "MUG/1");
		tr = manager.setPayment(tr, 200, 100);
		tr = manager.confirmPayment(tr);
		*/
		
		System.out.println("helloworld");
		
	}

	public StoreWindow getStoreWindow() {
		return storeWindow;
	}
	

}
