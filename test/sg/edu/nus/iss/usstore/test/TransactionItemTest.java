//TransactionItem.java
package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Category;
import sg.edu.nus.iss.usstore.domain.Product;
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
	
	Product product1 = new Product(new Category(),"1","2",3,4.5,"6",7,8);
	Product product2 = new Product(new Category(),"11","12",13,14.15,"16",17,18);
	
	@Test
	public void testTransactionItem()
	{
		TransactionItem transactionItem = new TransactionItem();
		assertFalse(transactionItem.toString()==null);
	}
	
	@Test
	public void testTransactionItemProductDoubleInt() throws IOException, DataFileException
	{
		TransactionItem transactionItem = new TransactionItem(product1,1.2,3);
		assertFalse(transactionItem.toString()==null);
		assertEquals(product1,transactionItem.getProduct());
		assertTrue(transactionItem.getPrice()==1.2);
		assertTrue(transactionItem.getQty()==3);
	}
	
	@Test
	public void testGetProduct() throws IOException, DataFileException
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertEquals(product1,ti.getProduct());
	}

	@Test
	public void testSetProduct() throws IOException, DataFileException
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		ti.setProduct(product2);
		assertEquals(product2,ti.getProduct());
	}

	@Test
	public void testGetPrice() throws IOException, DataFileException
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertTrue(10.5==ti.getPrice());
	}

	@Test
	public void testSetPrice() throws IOException, DataFileException
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		ti.setPrice(888.99);
		assertTrue(888.99==ti.getPrice());
	}

	@Test
	public void testGetQty() throws IOException, DataFileException
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertTrue(4==ti.getQty());
	}

	@Test
	public void testSetQty() throws IOException, DataFileException
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		ti.setQty(99);
		assertTrue(99==ti.getQty());
	}

	@Test
	public void testCalculateAmount() throws IOException, DataFileException
	{

		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertTrue(10.5*4==ti.calculateAmount());
	}
}///~
