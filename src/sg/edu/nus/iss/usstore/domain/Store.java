package sg.edu.nus.iss.usstore.domain;

import java.util.List;

import sg.edu.nus.iss.usstore.exception.LoginException;

public class Store {

//	private StorekeeperMgr storekeeperMgr;	
//	private MemberMgr memberMgr;
//	private TransactionMgr transactionMgr;
//	private ProductMgr productMgr;
//	private CategoryMgr categoryMgr;
//	private VendorMgr vendorMgr;
//	private DiscountMgr discountMgr;
	
	public Store() {
//		storekeeperMgr = new StorekeeperMgr();
//		storekeeperMgr = new MemberMgr();
//		storekeeperMgr = new TransactionMgr();
//		storekeeperMgr = new ProductMgr();
//		storekeeperMgr = new CategoryMgr();
//		storekeeperMgr = new VendorMgr();
//		storekeeperMgr = new DiscountMgr();
	}
	
	/**
	 * 
	 */
	public void login(String username, String password) throws LoginException{
		// invoke StorekeeperMgr.checkAuthorith()
		if (false) throw new LoginException("invaild user/password");		
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
		
		
		// invoke 
		
		
		return transaction;
	}
	
	
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
