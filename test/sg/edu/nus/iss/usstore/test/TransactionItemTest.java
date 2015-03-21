package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.ProductMgr;
import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.domain.TransactionItem;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataInputException;

public class TransactionItemTest extends TransactionItem
{
	Product product1 = new Product("1","2","3","4",5,6.7,"8",9,10);
	Product product2 = new Product("11","12","13","14",15,16.17,"18",19,20);
	@Test
	public void testTransactionItemProductDoubleInt()
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertEquals(product1,ti.getProduct());
		assertTrue(10.5==ti.getPrice());
		assertTrue(4==ti.getQty());
	}

	@Test
	public void testGetProduct()
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
	public void testGetQty()
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertTrue(4==ti.getQty());
	}

	@Test
	public void testSetQty()
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		ti.setQty(99);
		assertTrue(99==ti.getQty());
	}

	@Test
	public void testCalculateAmount()
	{
		TransactionItem ti = new TransactionItem(product1,10.5,4);
		assertTrue(10.5*4==ti.calculateAmount());
	}

}
