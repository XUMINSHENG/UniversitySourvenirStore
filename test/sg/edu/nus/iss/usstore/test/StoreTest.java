package sg.edu.nus.iss.usstore.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Category;
import sg.edu.nus.iss.usstore.domain.Customer;
import sg.edu.nus.iss.usstore.domain.Discount;
import sg.edu.nus.iss.usstore.domain.Member;
import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.Public;
import sg.edu.nus.iss.usstore.domain.Store;
import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.domain.Vendor;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataNotFoundException;
import static org.junit.Assert.*;

/**
 *
 * @author Xu Minsheng
 */
public class StoreTest {
    
    public StoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of loadData method, of class Store.
     */
    @Test
    public void testLoadData(){
        System.out.println("loadData");
        Store instance = new Store();
        try {
			instance.loadData();
		} catch (IOException e) {
			fail("data file is missing");
		} catch (DataFileException e) {
			fail("data file contains error data");
		}
        
    }

    /**
     * Test of saveData method, of class Store.
     */
    @Test
    public void testSaveData() throws Exception {
    	/*
        System.out.println("saveData");
        Store instance = new Store();
        instance.saveData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        */
    }

    /**
     * Test of login method, of class Store.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
       
        Store instance = new Store();
        
        // load storekeeper data from file
        try {
			instance.loadData();
		} catch (IOException | DataFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
        assertFalse(instance.login("",""));
		assertFalse(instance.login(" ","  "));
		assertFalse(instance.login(null,null));
		assertFalse(instance.login("admin",null));
		assertFalse(instance.login(null,"admin"));
		assertFalse(instance.login("admin",""));
		assertFalse(instance.login("","admin"));
		assertFalse(instance.login("admin","   "));
		assertFalse(instance.login("   ","admin"));
		assertFalse(instance.login("admin","noentry"));
		assertFalse(instance.login("noentry","admin"));
		assertTrue(instance.login("admin","admin"));
        
    }

    /**
     * Test of checkout method, of class Store.
     */
    @Test
    public void testCheckout() {
        System.out.println("checkout");
        Store instance = new Store();

        Transaction result = instance.checkout();
        
        //result is a new transaction without empty item list
        assertEquals(result.getItemList().size(), 0);
      
        //transaction which customer is public customer
        assertEquals(result.getCustomer().getClass(), Public.class);
        
        //since did not load data from file, discount should be null
        assertEquals(result.getDiscount(), null);
    }

    /**
     * Test of setBillCustomer method, of class Store.
     * @throws DataFileException 
     * @throws IOException 
     */
    @Test
    public void testSetBillCustomer() throws IOException, DataFileException{
        System.out.println("setBillCustomer");
        Transaction transaction = null;
        String memberId = "X437F356";
        Store instance = new Store();
        
        // get new transaction
        transaction = instance.checkout();
        
        Transaction result = null;
		result = instance.setBillCustomer(transaction, memberId);
		// result not null
        assertNotEquals(result, null);
        // customer is public
        assertEquals(result.getCustomer().getClass(), Public.class);
		
        
        // load data from file
       	instance.loadData();
		
		result = instance.setBillCustomer(transaction, memberId);
		
        // result not null
        assertNotEquals(result, null);
        // customer is a member
        assertEquals(result.getCustomer().getClass(), Member.class);
     
    }
//
//    /**
//     * Test of addBillItem method, of class Store.
//     */
//    @Test
//    public void testAddBillItem() throws Exception {
//        System.out.println("addBillItem");
//        Transaction transaction = null;
//        String productId = "";
//        int quantity = 0;
//        Store instance = new Store();
//        Transaction expResult = null;
//        Transaction result = instance.addBillItem(transaction, productId, quantity);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeBillItem method, of class Store.
//     */
//    @Test
//    public void testRemoveBillItem() {
//        System.out.println("removeBillItem");
//        Transaction transaction = null;
//        String productId = "";
//        Store instance = new Store();
//        Transaction expResult = null;
//        Transaction result = instance.removeBillItem(transaction, productId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setPayment method, of class Store.
//     */
//    @Test
//    public void testSetPayment() {
//        System.out.println("setPayment");
//        Transaction transaction = null;
//        double cash = 0.0;
//        int redeemLoyaltyPoint = 0;
//        Store instance = new Store();
//        Transaction expResult = null;
//        Transaction result = instance.setPayment(transaction, cash, redeemLoyaltyPoint);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of confirmPayment method, of class Store.
//     */
//    @Test
//    public void testConfirmPayment() {
//        System.out.println("confirmPayment");
//        Transaction transaction = null;
//        Store instance = new Store();
//        Transaction expResult = null;
//        Transaction result = instance.confirmPayment(transaction);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTransactionListByDate method, of class Store.
//     */
//    @Test
//    public void testGetTransactionListByDate() {
//        System.out.println("getTransactionListByDate");
//        Date date = null;
//        Store instance = new Store();
//        ArrayList<Transaction> expResult = null;
//        ArrayList<Transaction> result = instance.getTransactionListByDate(date);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of registerMember method, of class Store.
//     */
//    @Test
//    public void testRegisterMember() {
//        System.out.println("registerMember");
//        String name = "";
//        String memberId = "";
//        int loyalty = 0;
//        Store instance = new Store();
//        instance.registerMember(name, memberId, loyalty);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMemberById method, of class Store.
//     */
//    @Test
//    public void testGetMemberById() {
//        System.out.println("getMemberById");
//        String memberId = "";
//        Store instance = new Store();
//        Member expResult = null;
//        Member result = instance.getMemberById(memberId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMemberList method, of class Store.
//     */
//    @Test
//    public void testGetMemberList() {
//        System.out.println("getMemberList");
//        Store instance = new Store();
//        ArrayList<Member> expResult = null;
//        ArrayList<Member> result = instance.getMemberList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeMember method, of class Store.
//     */
//    @Test
//    public void testRemoveMember() {
//        System.out.println("removeMember");
//        String memberID = "";
//        Store instance = new Store();
//        instance.removeMember(memberID);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modifyMember method, of class Store.
//     */
//    @Test
//    public void testModifyMember() {
//        System.out.println("modifyMember");
//        String name = "";
//        String memID = "";
//        int loyaltyPoint = 0;
//        int index = 0;
//        Store instance = new Store();
//        instance.modifyMember(name, memID, loyaltyPoint, index);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMemberByID method, of class Store.
//     */
//    @Test
//    public void testGetMemberByID() {
//        System.out.println("getMemberByID");
//        String memID = "";
//        Store instance = new Store();
//        Member expResult = null;
//        Member result = instance.getMemberByID(memID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNewProductIdByCategory method, of class Store.
//     */
//    @Test
//    public void testGetNewProductIdByCategory() {
//        System.out.println("getNewProductIdByCategory");
//        String code = "";
//        Store instance = new Store();
//        String expResult = "";
//        String result = instance.getNewProductIdByCategory(code);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addProduct method, of class Store.
//     */
//    @Test
//    public void testAddProduct() {
//        System.out.println("addProduct");
//        String id = "";
//        String name = "";
//        String categoryCode = "";
//        String briefDescription = "";
//        int quantityAvailable = 0;
//        double price = 0.0;
//        String barCode = "";
//        int threshold = 0;
//        int orderQuantity = 0;
//        Store instance = new Store();
//        instance.addProduct(id, name, categoryCode, briefDescription, quantityAvailable, price, barCode, threshold, orderQuantity);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modifyProduct method, of class Store.
//     */
//    @Test
//    public void testModifyProduct() {
//        System.out.println("modifyProduct");
//        String id = "";
//        String name = "";
//        String categoryCode = "";
//        String briefDescription = "";
//        int quantityAvailable = 0;
//        double price = 0.0;
//        String barCode = "";
//        int threshold = 0;
//        int orderQuantity = 0;
//        Store instance = new Store();
//        instance.modifyProduct(id, name, categoryCode, briefDescription, quantityAvailable, price, barCode, threshold, orderQuantity);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteProduct method, of class Store.
//     */
//    @Test
//    public void testDeleteProduct() {
//        System.out.println("deleteProduct");
//        String id = "";
//        Store instance = new Store();
//        instance.deleteProduct(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getProductList method, of class Store.
//     */
//    @Test
//    public void testGetProductList() {
//        System.out.println("getProductList");
//        Store instance = new Store();
//        ArrayList<Product> expResult = null;
//        ArrayList<Product> result = instance.getProductList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getProductById method, of class Store.
//     */
//    @Test
//    public void testGetProductById() {
//        System.out.println("getProductById");
//        String productId = "";
//        Store instance = new Store();
//        Product expResult = null;
//        Product result = instance.getProductById(productId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getProductByBarCode method, of class Store.
//     */
//    @Test
//    public void testGetProductByBarCode() {
//        System.out.println("getProductByBarCode");
//        String barCode = "";
//        Store instance = new Store();
//        Product expResult = null;
//        Product result = instance.getProductByBarCode(barCode);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of checkInventory method, of class Store.
//     */
//    @Test
//    public void testCheckInventory() {
//        System.out.println("checkInventory");
//        Store instance = new Store();
//        ArrayList<Product> expResult = null;
//        ArrayList<Product> result = instance.checkInventory();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPurchaseOrder method, of class Store.
//     */
//    @Test
//    public void testGetPurchaseOrder() {
//        System.out.println("getPurchaseOrder");
//        Store instance = new Store();
//        HashMap<Product, Vendor> expResult = null;
//        HashMap<Product, Vendor> result = instance.getPurchaseOrder();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addCategory method, of class Store.
//     */
//    @Test
//    public void testAddCategory() {
//        System.out.println("addCategory");
//        String code = "";
//        String name = "";
//        ArrayList<Vendor> vendorList = null;
//        Store instance = new Store();
//        instance.addCategory(code, name, vendorList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updCategory method, of class Store.
//     */
//    @Test
//    public void testUpdCategory() {
//        System.out.println("updCategory");
//        String code = "";
//        String name = "";
//        Store instance = new Store();
//        instance.updCategory(code, name);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delCategoryByCode method, of class Store.
//     */
//    @Test
//    public void testDelCategoryByCode() {
//        System.out.println("delCategoryByCode");
//        String code = "";
//        Store instance = new Store();
//        instance.delCategoryByCode(code);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCategoryList method, of class Store.
//     */
//    @Test
//    public void testGetCategoryList() {
//        System.out.println("getCategoryList");
//        Store instance = new Store();
//        ArrayList<Category> expResult = null;
//        ArrayList<Category> result = instance.getCategoryList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCategoryByCode method, of class Store.
//     */
//    @Test
//    public void testGetCategoryByCode() {
//        System.out.println("getCategoryByCode");
//        String code = "";
//        Store instance = new Store();
//        Category expResult = null;
//        Category result = instance.getCategoryByCode(code);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addVendorForCategory method, of class Store.
//     */
//    @Test
//    public void testAddVendorForCategory() {
//        System.out.println("addVendorForCategory");
//        String categoryCode = "";
//        String vendorName = "";
//        String vendorDesc = "";
//        Store instance = new Store();
//        instance.addVendorForCategory(categoryCode, vendorName, vendorDesc);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delVendorForCategory method, of class Store.
//     */
//    @Test
//    public void testDelVendorForCategory() {
//        System.out.println("delVendorForCategory");
//        String categoryCode = "";
//        String vendorName = "";
//        Store instance = new Store();
//        instance.delVendorForCategory(categoryCode, vendorName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updVendorForCategory method, of class Store.
//     */
//    @Test
//    public void testUpdVendorForCategory() {
//        System.out.println("updVendorForCategory");
//        String categoryCode = "";
//        String oldName = "";
//        String newName = "";
//        String newDesc = "";
//        Store instance = new Store();
//        instance.updVendorForCategory(categoryCode, oldName, newName, newDesc);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of switchVendorPrefForCategory method, of class Store.
//     */
//    @Test
//    public void testSwitchVendorPrefForCategory() {
//        System.out.println("switchVendorPrefForCategory");
//        String categoryCode = "";
//        String upVendorName = "";
//        String downVendorName = "";
//        Store instance = new Store();
//        instance.switchVendorPrefForCategory(categoryCode, upVendorName, downVendorName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addDiscount method, of class Store.
//     */
//    @Test
//    public void testAddDiscount_6args() {
//        System.out.println("addDiscount");
//        String discountCode = "";
//        String discountDescription = "";
//        Date startDate = null;
//        int period = 0;
//        double percent = 0.0;
//        String Applicable = "";
//        Store instance = new Store();
//        instance.addDiscount(discountCode, discountDescription, startDate, period, percent, Applicable);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modifyDiscount method, of class Store.
//     */
//    @Test
//    public void testModifyDiscount() {
//        System.out.println("modifyDiscount");
//        String discountCode = "";
//        String discountDescription = "";
//        Date startDate = null;
//        int period = 0;
//        double percent = 0.0;
//        String Applicable = "";
//        Store instance = new Store();
//        instance.modifyDiscount(discountCode, discountDescription, startDate, period, percent, Applicable);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteDiscount method, of class Store.
//     */
//    @Test
//    public void testDeleteDiscount() {
//        System.out.println("deleteDiscount");
//        int index = 0;
//        Store instance = new Store();
//        instance.deleteDiscount(index);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getDiscountList method, of class Store.
//     */
//    @Test
//    public void testGetDiscountList() {
//        System.out.println("getDiscountList");
//        Store instance = new Store();
//        ArrayList<Discount> expResult = null;
//        ArrayList<Discount> result = instance.getDiscountList();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

   
    
}
