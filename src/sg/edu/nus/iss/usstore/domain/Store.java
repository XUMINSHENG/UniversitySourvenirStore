package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataNotFoundException;

/**
 * 
 * @author Xu Minsheng
 *
 */
public class Store {

	private StoreKeeperMgr storekeeperMgr;	
	private MemberMgr memberMgr;
	private TransactionMgr transactionMgr;
	private ProductMgr productMgr;
	private CategoryMgr categoryMgr;
	private DiscountMgr discountMgr;
	
	/**
	 * Instantiate Mgr and load data from files
	 * 
	 * @throws IOException
	 * @throws DataFileException
	 */
	public Store(){
		storekeeperMgr = new StoreKeeperMgr();
		categoryMgr = new CategoryMgr();
		memberMgr = new MemberMgr();
		discountMgr = new DiscountMgr();
		productMgr = new ProductMgr(this);
		transactionMgr = new TransactionMgr(this);
	}
	
	public void loadData() throws IOException, DataFileException{
		storekeeperMgr.loadData();
		categoryMgr.loadData();
		memberMgr.readFile();
		discountMgr.loadData();
		productMgr.loadData();
		transactionMgr.loadData();
	}
	
	/**
	 * save all data to files
	 * 
	 * @throws IOException
	 */
	public void saveData() throws IOException{
		memberMgr.writeFile();
		transactionMgr.save();
		productMgr.saveData();
		categoryMgr.saveData();
		discountMgr.saveData();
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password){
		return storekeeperMgr.checkAuthority(username, password);
	}
	
//  -------------------- transaction related methods	-------------------

	/**
	 * create a new transaction instance with public customer
	 * 
	 * @return new transaction
	 */
	public Transaction checkout(){
		Transaction transaction = new Transaction();
		transaction.setCustomer(new Public(""));
		Discount discount = discountMgr.getMaxDiscount(transaction.getCustomer());
		transaction.setDiscount(discount);
		return transaction;
	}
	
	/**
	 * set Customer info. and according to it, get Highest Discount 
	 * 
	 * @param transaction
	 * @param memberId
	 * @return
	 * @throws DataNotFoundException 
	 */
	public Transaction setBillCustomer(Transaction transaction, String memberId) throws DataNotFoundException{
		
		Customer customer;
		Discount discount;
		
		// get customer info
		if (memberId==null){
			customer = new Public();
		}else{
			customer = memberMgr.getMemberByID(memberId);
		}
		
		// get max discount
		discount = discountMgr.getMaxDiscount(customer);
		
		//set customer and discount to transaction
		transaction.setCustomer(customer);
		transaction.setDiscount(discount);
		
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
		
		
		// add to transaction list
		transaction.setId(transactionMgr.getMaxId() + 1);
		transaction.setDate(new Date());
		transactionMgr.addTransaction(transaction);
		
		// update product's quantity
		ArrayList<TransactionItem> itemList = transaction.getItemList();
		for(TransactionItem item : itemList){
			productMgr.changeProductQty(item.getProduct(), item.getProduct().getQuantityAvailable() - item.getQty());
		}
		
		// update Member's loyalty point
		Customer customer = transaction.getCustomer();
		if (customer instanceof Member){
			Member member = (Member) customer;
			int originalPoint = member.getLoyaltyPoint();
			int currentPoint = originalPoint
					- transaction.getRedeemedLoyaltyPoint() + transaction.calcGainedPoint();
			member.setLoyaltyPoint(currentPoint);
		}
		
		// check inventory
		// productMgr.checkInventory();
		
		return transaction;
	}
	

	/**
	 * 
	 * @param date
	 * @return TransactionList
	 */
	public ArrayList<Transaction> getTransactionListByDate(Date date){
		return transactionMgr.getTransactionListByDate(date);
	}
	
	

//  -------------------- member related methods	-------------------
	/**
	 * 
	 * @param name
	 * @param memberId
	 */	
	public void registerMember(String name, String memberId,int loyalty){
		memberMgr.registerMember(name, memberId,loyalty);
	}
	
	/**
	 * 
	 * @param memberId
	 * @return
	 */
	public Member getMemberById(String memberId){
		return memberMgr.getMemberByID(memberId);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Member> getMemberList(){
		return memberMgr.getMemberList();
	}
	
	public void removeMember(String memberID){
		 memberMgr.removeMember(memberID);
	}
	
	public void modifyMember(String name,String memID,int loyaltyPoint,int index){
		memberMgr.modifyMember(name, memID, loyaltyPoint, index);
	}
	
	public Member getMemberByID(String memID){
		return memberMgr.getMemberByID(memID);
	}
	
//  -------------------- product related methods	-------------------
	
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
	public String getNewProductIdByCategory(String code){
		return productMgr.getNewProductIdByCategory(code);
	}
	
	public void addProduct(String id,String name, String categoryCode, String briefDescription, 
			int quantityAvailable, double price, String barCode, int threshold, int orderQuantity){
		
		productMgr.addProduct(id,name, categoryMgr.getCategoryByCode(categoryCode),
				briefDescription, quantityAvailable, price, barCode, threshold, orderQuantity);
	}
	
	/**
	 * 
	 * @param product
	 * @param indenx
	 */
	public void modifyProduct(String id,String name, String categoryCode, String briefDescription, 
			int quantityAvailable, double price, String barCode, int threshold, int orderQuantity){
		productMgr.modifyProduct(id,name, categoryMgr.getCategoryByCode(categoryCode), briefDescription
				, quantityAvailable, price, barCode, threshold, orderQuantity);
		
	}
	/**
	 * 
	 * @param index
	 */
	public void deleteProduct(String id){
		productMgr.deleteProduct(id);
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
	 * @param barCode
	 * @return
	 */
	public Product getProductByBarCode(String barCode){
		return productMgr.getProductByBarCode(barCode);
	}
	
	public ArrayList<Product> checkInventory(){
		return productMgr.checkInventory();
	}
	
	public HashMap<Product,Vendor> getPurchaseOrder(){
		
		//PurchaseOrder purchaseOrder = new PurchaseOrder();
		HashMap<Product,Vendor> purchaseList = new HashMap<Product,Vendor>();
		ArrayList<Product> productList = null;
		productList = productMgr.checkInventory();
		//Vendor v = null;
		for(Product p:productList){
			purchaseList.put(p,p.getCategory().getPreferenceVendor());
		}
		
		return purchaseList;
	}
	
//  -------------------- category related methods	-------------------
	/**
	 * 
	 * @param code
	 * @param name
	 * @param vendorNameList
	 */
	public void addCategory(String code, String name, ArrayList<Vendor> vendorList){
		categoryMgr.addCategory(code, name, vendorList);
	}
	
	/**
	 * 
	 * @param code
	 * @param name
	 * @param vendorNameList
	 */
	public void updCategory(String code, String name){
		categoryMgr.updCategory(code, name);
	}
	
	/**
	 * 
	 * @param code
	 */
	public void delCategoryByCode(String code){
		categoryMgr.delCategoryByCode(code);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Category> getCategoryList(){
		return categoryMgr.getCategoryList();
	}
	
	/**
	 * 
	 * @return
	 */
	public Category getCategoryByCode(String code){
		if(getCategoryList().size()==0){
			return null;
		}
		return categoryMgr.getCategoryByCode(code);
	}
	

	/**
	 * 
	 * @param categoryCode
	 * @param vendorName
	 * @param vendorDesc
	 */
	public void addVendorForCategory(String categoryCode, String vendorName, String vendorDesc){
		categoryMgr.addVendorForCategory(categoryCode, vendorName, vendorDesc);
	}
	
	/**
	 * 
	 * @param categoryCode
	 * @param vendorName
	 */
	public void delVendorForCategory(String categoryCode, String vendorName){
		categoryMgr.delVendorForCategory(categoryCode, vendorName);
	}
	
	/**
	 * 
	 * @param categoryCode
	 * @param oldName
	 * @param newName
	 * @param newDesc
	 */
	public void updVendorForCategory(String categoryCode, String oldName, String newName, String newDesc){
		categoryMgr.updVendorForCategory(categoryCode, oldName, newName, newDesc);
	}
	
	/**
	 * 
	 * @param categoryCode
	 * @param upVendorName
	 * @param downVendorName
	 */
	public void switchVendorPrefForCategory(String categoryCode, String upVendorName, String downVendorName){
		categoryMgr.switchVendorPrefForCategory(categoryCode, upVendorName, downVendorName);
	}
	


	/** discount related 
	 * 
	 * 
	 * 
	 * 
	 */
	public void addDiscount(String discountCode, String discountDescription,
			Date startDate, int period, double percent, String Applicable ){
		
		discountMgr.registerDiscount(discountCode, discountDescription, startDate, period, percent, Applicable);
	}
	
	/**
	*
	 * 
	 */
	
	public void addDiscount(Discount discount){
		discountMgr.getdiscountList();
	}
	
	
	
	public void modifyDiscount(String discountCode, String discountDescription,
			Date startDate, int period, double percent, String Applicable){
		discountMgr.modifyDiscount( discountCode,  discountDescription,
				 startDate, period,  percent,  Applicable);
		
	}
	/**
	 * 
	 * @param index
	 */
	public void deleteDiscount(int index){
		discountMgr.deleteDiscount(index);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Discount> getDiscountList(){
		return discountMgr.getDiscountlist();
	}

}