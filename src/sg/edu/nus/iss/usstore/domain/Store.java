package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.iss.usstore.exception.DataInputException;
import sg.edu.nus.iss.usstore.exception.LoginException;

public class Store {

	//	private StorekeeperMgr storekeeperMgr;	
	//	private MemberMgr memberMgr;
	//  private TransactionMgr transactionMgr;
	private ProductMgr productMgr;
	//	private CategoryMgr categoryMgr;
	//	private VendorMgr vendorMgr;
	//	private DiscountMgr discountMgr;
	
	public Store() throws DataInputException, IOException {
//		storekeeperMgr = new StorekeeperMgr();
//		memberMgr = new MemberMgr();
//		storekeeperMgr = new TransactionMgr();
		productMgr = new ProductMgr();
//		categoryMgr = new CategoryMgr();
//		vendorMgr = new VendorMgr();
//		discountMgr = new DiscountMgr();
	}
	
	/**
	 * 
	 */
	public void login(String username, String password) throws LoginException{
		// invoke StorekeeperMgr.checkAuthorith()
		//if (false) throw new LoginException("invaild user/password");		
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
				
		if (memberId!=null){
			//customer = memberMgr.getMemberById();
		}
		
		
		//if (customer == null) customer = new Public();
		// invoke transaction.setCustomer();
		
		
		// discount = customer.getDiscount(discountMgr.getDiscountList());
		// invoke transaction.setDiscount();
		
		return transaction;
	}
	
	/**
	 * 
	 */
	public Transaction addBillItem(Transaction transaction, String productId, int quantity){
		
		// invoke transaction.addItem(transaction, productId, quantity)
	
		return transaction;
	}
	
	/**
	 * 
	 */
	public Transaction removeBillItem(Transaction transaction, String productId){
		
		// invoke transaction.removeItem(transaction, productId)
	
		return transaction;
	}
	
	/**
	 * 
	 */
	public Transaction setPayment(Transaction transaction, double cash, int redeemLoyaltyPoint){
		
		//invoke transaction.setCashAmount(cash);
		//invoke transaction.setRedeemedLoyaltyPoint(redeemLoyaltyPoint);
		
		return transaction;
	}
	
	/**
	 * 
	 */
	public Transaction confirmPayment(Transaction transaction){
		
		// verification product
		
		// invoke TransactionMgr.addTransaction()
		// transactionMgr.addTransaction(transaction);
		
		// update product's quantity 
		
		// update Member's loyalty point
		
		// update 
		
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
	
	public void newProduct(String name, String categoryCode, String briefDescription, 
			int quantityAvailable, double price, String barCode, int threshold, int orderQuantity){
		
		// invoke categoryMgr.getCategoryByCode() to get category
		
		// invoke productyMgr.newProduct()
		
	}
	
	public void newCategory(String code, String name, List<String> vendorNameList){
		
		// invoke vendorMgr.getVendorByName()
		
		// invoke categoryMgr.newCategory
		
		
		
	}
	
	
	

}
