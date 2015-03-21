//TransactionTest.java
package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.ProductMgr;
import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.domain.TransactionItem;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataInputException;

public class TransactionTest extends Transaction
{
	/**
	 * Unit Test of Transaction
	 * 
	 * @author Liu Xinzhuo
	 * @author A0136010A
	 * @version 1.0
	 */

	Date date = new Date();
	Transaction t = new Transaction(1,"costumer",date);
	@Test
	public void testTransaction()
	{
		Transaction t1 = new Transaction();
		assertFalse(t1.toString()==null);
		t=null;
	}

	@Test
	public void testTransactionIntStringDate()
	{
		Date date = new Date();
		Transaction t2 = new Transaction(1,"customer",date);
		assertEquals(1,t2.getId());
		assertEquals("customer",t2.getCostomerID());
		assertEquals(date,t2.getDate());	
	}

	@Test
	public void testGetId()
	{
		assertEquals(1,t.getId());
	}

	@Test
	public void testSetId()
	{
		t.setId(2);
		assertEquals(2,t.getId());
	}

	@Test
	public void testGetDate()
	{
		assertEquals(date,t.getDate());
	}

	@Test
	public void testSetDate()
	{
		Date date2 = new Date();
		t.setDate(date2);
		assertEquals(date2,t.getDate());
	}
	
	@Test
	public void testSetItemList() throws IOException, DataFileException, DataInputException
	{
		Product product1 = new Product("1","2","3","4",5,6.7,"8",9,10);
		Product product2 = new Product("11","12","13","14",15,16.17,"18",19,20);
		TransactionItem ti1 = new TransactionItem(product1,2.3,4);
		TransactionItem ti2 = new TransactionItem(product2,5.6,7);
		ArrayList<TransactionItem> al1 = new ArrayList<TransactionItem>();
		al1.add(ti1);
		al1.add(ti2);
		t.setItemList(al1);
		ArrayList<TransactionItem> al2 =t.getItemList();
		assertEquals(al1,al2);
	}
	@Test
	public void testGetItemList()
	{
		Product product1 = new Product("1","2","3","4",5,6.7,"8",9,10);
		Product product2 = new Product("11","12","13","14",15,16.17,"18",19,20);
		TransactionItem ti1 = new TransactionItem(product1,2.3,4);
		TransactionItem ti2 = new TransactionItem(product2,5.6,7);
		ArrayList<TransactionItem> al1 = new ArrayList<TransactionItem>();
		al1.add(ti1);
		al1.add(ti2);
		t.setItemList(al1);
		ArrayList<TransactionItem> al2 =t.getItemList();
		assertEquals(al1,al2);
	}
	

	
	@Test
	public void testSetCashAmount()
	{
		t.setCashAmount(100.11);
		double CashAmount = t.getCashAmount();
		assertTrue(100.11==CashAmount);
	}
	
	@Test
	public void testGetCashAmount()
	{
		t.setCashAmount(100.11);
		double CashAmount = t.getCashAmount();
		assertTrue(100.11==CashAmount);
	}

	@Test
	public void testSetRedeemedLoyaltyPoint()
	{
		t.setRedeemedLoyaltyPoint(100);
		int redeemedLoyaltyPoint = t.getRedeemedLoyaltyPoint();
		assertEquals(100,redeemedLoyaltyPoint);
	}
	
	@Test
	public void testGetRedeemedLoyaltyPoint()
	{
		t.setRedeemedLoyaltyPoint(100);
		int redeemedLoyaltyPoint = t.getRedeemedLoyaltyPoint();
		assertEquals(100,redeemedLoyaltyPoint);
	}

	@Test
	public void testAddItemProductInt()
	{
		ProductMgr pm = null;
		try
		{
			pm = new ProductMgr();
		} catch (IOException | DataFileException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product p = pm.getProductById("CLO/1");
		t.addItem(p, 2);
		assertEquals(t.getItemList().get(0).getProduct(),p);
	}

	@Test
	public void testAddItemProductDoubleInt()
	{
		Product product3 = new Product("31","32","33","34",35,36.37,"38",39,40);
		t.addItem(product3,40.41,42);
		Product product4 = t.getItemList().get(0).getProduct();
		assertEquals(product3,product4);
	}

	@Test
	public void testRemoveItem()
	{
		Product product3 = new Product("31","32","33","34",35,36.37,"38",39,40);
		t.addItem(product3,40.41,42);
		t.removeItem(product3);
		assertEquals(0,t.getItemList().size());
	}

	@Test
	public void testCalcTotalPrice()
	{
		ProductMgr pm = null;
		try
		{
			pm = new ProductMgr();
		} catch (IOException | DataFileException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product p = pm.getProductById("CLO/1");
		Product p2 = pm.getProductById("MUG/1");
		Product p3 = pm.getProductById("STA/1");
		t.addItem(p, 2);
		t.addItem(p2, 3);
		t.addItem(p3, 4);
		assertTrue(p.getPrice()*2+p2.getPrice()*3+p3.getPrice()*4==t.calcTotalPrice());
	}

	@Test
	public void testCalcDiscountPrice()
	{
		ProductMgr pm = null;
		try
		{
			pm = new ProductMgr();
		} catch (IOException | DataFileException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product p = pm.getProductById("CLO/1");
		Product p2 = pm.getProductById("MUG/1");
		Product p3 = pm.getProductById("STA/1");
		t.addItem(p, 2);
		t.addItem(p2, 3);
		t.addItem(p3, 4);
		t.setDiscount(10);
		assertTrue((p.getPrice()*2+p2.getPrice()*3+p3.getPrice()*4)* (100 - 10)/100==t.calcDiscountPrice());
	}

	@Test
	public void testCalcChange()
	{
		ProductMgr pm = null;
		t.setCashAmount(500.20);
		try
		{
			pm = new ProductMgr();
		} catch (IOException | DataFileException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product p = pm.getProductById("CLO/1");
		Product p2 = pm.getProductById("MUG/1");
		Product p3 = pm.getProductById("STA/1");
		t.addItem(p, 2);
		t.addItem(p2, 3);
		t.addItem(p3, 4);
		t.setDiscount(10);
		assertTrue((500.20-(p.getPrice()*2+p2.getPrice()*3+p3.getPrice()*4)* (100 - 10)/100)==t.calcChange());
	}

	@Test
	public void testCalcGainedPoint()
	{
		ProductMgr pm = null;
		try
		{
			pm = new ProductMgr();
		} catch (IOException | DataFileException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product p = pm.getProductById("CLO/1");
		Product p2 = pm.getProductById("MUG/1");
		Product p3 = pm.getProductById("STA/1");
		t.addItem(p, 2);
		t.addItem(p2, 3);
		t.addItem(p3, 4);
		t.setDiscount(10);
		assertTrue((int)((p.getPrice()*2+p2.getPrice()*3+p3.getPrice()*4)* (100 - 10)/10000)==t.calcGainedPoint());
	}

	@Test
	public void testGetCostomerID()
	{
		t.setCostomerID("customer1");
		assertEquals("customer1",t.getCostomerID());
	}

	@Test
	public void testSetCostomerID()
	{
		t.setCostomerID("customer1");
		assertEquals("customer1",t.getCostomerID());
	}

}///~
