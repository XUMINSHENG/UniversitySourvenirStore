package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataNotFoundException;
import sg.edu.nus.iss.usstore.exception.LoginException;

/**
 * 
 * @author Xu Minsheng
 *
 */
public class Store {

	private StoreKeeperMgr storekeeperMgr;	
	//	private MemberMgr memberMgr;
	private TransactionMgr transactionMgr;
	private ProductMgr productMgr;
	//	private CategoryMgr categoryMgr;
	//	private VendorMgr vendorMgr;
	//	private DiscountMgr discountMgr;
	
	public Store() throws IOException, DataFileException {
		storekeeperMgr = new StoreKeeperMgr();
//		memberMgr = new MemberMgr();
		transactionMgr = new TransactionMgr(this);
		productMgr = new ProductMgr();
//		categoryMgr = new CategoryMgr();
//		vendorMgr = new VendorMgr();
//		discountMgr = new DiscountMgr();
	}
	
	/**
	 * 
	 */
	public boolean login(String username, String password){
		// invoke StorekeeperMgr.checkAuthority()
		return storekeeperMgr.checkAuthority(username, password);
	}
	
	/**
	 * 
	 */
	public Transaction checkout(){
		return new Transaction();
	}
	
	/**
	 * 
	 */
	public Transaction setBillCustomer(Transaction transaction, String memberId){
		
		//Customer customer;
		//Discount discount;
				
		if (memberId==null){
			//customer = new Public();
		}else{
			//customer = memberMgr.getMemberById();
			//if (customer == null) 
			//{
			//	throw new DataNotFoundException("Customer",memberId);
			//}
			// invoke transaction.setCustomer();
		}
		
		
		// discount = customer.getDiscount(discountMgr.getDiscountList());
		// invoke transaction.setDiscount();
		
		return transaction;
	}
	
	/**
	 * 
	 * @param transaction
	 * @param productId
	 * @param quantity
	 * @return
	 * @throws DataNotFoundException
	 */
	public Transaction addBillItem(Transaction transaction, String productId, int quantity) throws DataNotFoundException{
		
		Product product = productMgr.getProductById(productId);
		
		if (product==null){
			throw new DataNotFoundException("Product",productId);
		}
		
		transaction.addItem(product, quantity);
	
		return transaction;
	}
	
	/**
	 * 
	 * @param transaction
	 * @param productId
	 * @return
	 */
	public Transaction removeBillItem(Transaction transaction, String productId){
		
		Product product = productMgr.getProductById(productId);
		
		transaction.removeItem(product);
	
		return transaction;
	}
	
	/**
	 * 
	 * @param transaction
	 * @param cash
	 * @param redeemLoyaltyPoint
	 * @return
	 */
	public Transaction setPayment(Transaction transaction, double cash, int redeemLoyaltyPoint){
		transaction.setRedeemedLoyaltyPoint(redeemLoyaltyPoint);
		transaction.setCashAmount(cash);
		return transaction;
	}
	
	/**
	 * 
	 */
	public Transaction confirmPayment(Transaction transaction){
		
		// verification product
		
		// invoke TransactionMgr.addTransaction()
		transactionMgr.addTransaction(transaction);
		
		// update product's quantity
		ArrayList<TransactionItem> itemList = transaction.getItemList();
		for(TransactionItem item : itemList){
			productMgr.changeProductQty(item.getProduct(), item.getProduct().getQuantityAvaible() - item.getQty());
		}
		
		// update Member's loyalty point
		if (transaction.getCostomerID() != "public"){
			
		}
		
		// check inventory
		
		return transaction;
	}
	
	public PurchaseOrder getPurchaseOrder(){
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();;
		
		ArrayList<Product> productList = null;
		productList = productMgr.checkInventory();

		
		// HashMap<Product,Vendor> purchaseList = new HashMap<Product,Vendor>();
		
		// foreach product in productList, 
		// purchaseList.add(product, product.getCategory().getPreferenceVendor())
		
		// purchaseOrder.
		
		return purchaseOrder;
	}
	
	/**
	 * 
	 * @param name
	 * @param memberId
	 */	
	public void registerMember(String name, String memberId){
		// invoke TransactionMgr.addTransaction()
	}
	
	/**
	 * 
	 * @param name
	 * @param categoryCode
	 * @param briefDescription
	 * @param quantityAvailable
	 * @param price
	 * @param barCode
	 * @param threshold
	 * @param orderQuantity
	 */
	public void addProduct(String name, String categoryCode, String briefDescription, 
			int quantityAvailable, double price, String barCode, int threshold, int orderQuantity){
		
		// invoke categoryMgr.getCategoryByCode() to get category
		// if () throw new DataNotFoundException("Category",categoryCode);
		
		Product product = new Product(categoryCode + "\3", categoryCode, name, 
				briefDescription, quantityAvailable, price, barCode, threshold, orderQuantity);
		
		productMgr.addProduct(product);
	}
	
	/**
	 * 
	 * @param product
	 */
	public void addProduct(Product product){
		productMgr.addProduct(product);
	}
	
	/**
	 * 
	 * @param product
	 * @param indenx
	 */
	public void modifyProduct(Product product, int indenx){
		productMgr.modifyProduct(product, indenx);
	}
	
	/**
	 * 
	 * @param index
	 */
	public void deleteProduct(int index){
		productMgr.deleteProduct(index);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Product> getProductList(){
		return productMgr.getProductList();
	}
	
	/**
	 * 
	 * @return
	 */
	public Product getProductById(String productId){
		return productMgr.getProductById(productId);
	}
	
	/**
	 * 
	 * @return
	 */
	public Product getProductByBarCode(String productId){
		return productMgr.getProductById(productId);
	}
	
	
	/**
	 * 
	 * @param code
	 * @param name
	 * @param vendorNameList
	 */
	public void newCategory(String code, String name, List<String> vendorNameList){
		
		// invoke vendorMgr.getVendorByName()
		
		// invoke categoryMgr.newCategory
		
		
	}
	
	/**
	 * 
	 * @param date
	 * @return TransactionList
	 * @throws ParseException 
	 */
	public ArrayList<Transaction> getTransactionByDate(Date date) throws ParseException{
		
		//
		return transactionMgr.getTransactionListByDate(date);
	}

	public ProductMgr getPm() {
		return productMgr;
	}
	
	
	

}
