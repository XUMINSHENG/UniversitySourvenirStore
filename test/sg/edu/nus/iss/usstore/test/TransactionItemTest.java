package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.domain.TransactionItem;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataInputException;

public class TransactionItemTest extends Transaction
{

	@Test
	public void testTransactionItemStringInt() throws IOException, DataFileException, DataInputException
	{
		TransactionItem ti = new TransactionItem("1234",5);
	}

	@Test
	public void testTransactionItemProductDoubleInt()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetProduct()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetProduct()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrice()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetPrice()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetQty()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testSetQty()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateAmount()
	{
		fail("Not yet implemented");
	}

}
