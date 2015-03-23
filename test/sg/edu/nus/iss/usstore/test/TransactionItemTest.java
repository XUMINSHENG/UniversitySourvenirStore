//TransactionItem.java
package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.ProductMgr;
import sg.edu.nus.iss.usstore.domain.Store;
import sg.edu.nus.iss.usstore.domain.TransactionItem;
import sg.edu.nus.iss.usstore.exception.DataFileException;

public class TransactionItemTest extends TransactionItem
{
	/**
	 * Unit Test of TransactionItem
	 * 
	 * @author Liu Xinzhuo
	 * @author A0136010A
	 * @version 1.0
	 * @throws DataFileException 
	 * @throws IOException 
	 */
	
	@Test
	public void testTransactionItemProductDoubleInt() throws IOException, DataFileException
	{
		ProductMgr pm  = new ProductMgr(new Store());
		Product product1 = pm.getProductByBarCode("1234");
		Product product2 = pm.getProductByBarCode("6789");
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertEquals(product1,ti.getProduct());
		assertTrue(10.5==ti.getPrice());
		assertTrue(4==ti.getQty());
	}

	@Test
	public void testGetProduct() throws IOException, DataFileException
	{
		ProductMgr pm  = new ProductMgr(new Store());
		Product product1 = pm.getProductByBarCode("1234");
		Product product2 = pm.getProductByBarCode("6789");
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertEquals(product1,ti.getProduct());
	}

	@Test
	public void testSetProduct() throws IOException, DataFileException
	{
		ProductMgr pm  = new ProductMgr(new Store());
		Product product1 = pm.getProductByBarCode("1234");
		Product product2 = pm.getProductByBarCode("6789");
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		ti.setProduct(product2);
		assertEquals(product2,ti.getProduct());
	}

	@Test
	public void testGetPrice() throws IOException, DataFileException
	{
		ProductMgr pm  = new ProductMgr(new Store());
		Product product1 = pm.getProductByBarCode("1234");
		Product product2 = pm.getProductByBarCode("6789");
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertTrue(10.5==ti.getPrice());
	}

	@Test
	public void testSetPrice() throws IOException, DataFileException
	{
		ProductMgr pm  = new ProductMgr(new Store());
		Product product1 = pm.getProductByBarCode("1234");
		Product product2 = pm.getProductByBarCode("6789");
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		ti.setPrice(888.99);
		assertTrue(888.99==ti.getPrice());
	}

	@Test
	public void testGetQty() throws IOException, DataFileException
	{
		ProductMgr pm  = new ProductMgr(new Store());
		Product product1 = pm.getProductByBarCode("1234");
		Product product2 = pm.getProductByBarCode("6789");
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertTrue(4==ti.getQty());
	}

	@Test
	public void testSetQty() throws IOException, DataFileException
	{
		ProductMgr pm  = new ProductMgr(new Store());
		Product product1 = pm.getProductByBarCode("1234");
		Product product2 = pm.getProductByBarCode("6789");
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		ti.setQty(99);
		assertTrue(99==ti.getQty());
	}

	@Test
	public void testCalculateAmount() throws IOException, DataFileException
	{
		ProductMgr pm  = new ProductMgr(new Store());
		Product product1 = pm.getProductByBarCode("1234");
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertTrue(10.5*4==ti.calculateAmount());
	}

}///~
