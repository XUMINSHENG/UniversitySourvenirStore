package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.domain.TransactionMgr;
import sg.edu.nus.iss.usstore.exception.DataFileException;

public class TransactionMgrTest
{
	TransactionMgr tm;

	@Test
	public void testTransactionMgrStore() throws IOException, DataFileException
	{
		tm = new TransactionMgr();
		assertFalse(tm.getTransactionList().size()==0);	
	}
	
	@Test
	public void testSetTransactionList() throws IOException, DataFileException
	{
		tm = new TransactionMgr();
		ArrayList<Transaction> testList = new ArrayList();
		Transaction t1 = new Transaction();
		Transaction t2 = new Transaction();
		Transaction t3 = new Transaction();
		testList.add(t1);
		testList.add(t2);
		testList.add(t3);
		tm.setTransactionList(testList);
		ArrayList<Transaction> testList2 = new ArrayList();
		testList2 = tm.getTransactionList();
		for(int i = 0 ; i < testList.size(); i ++)
		{
			assertTrue(testList.get(i)==testList2.get(i));
		}
	}
	
	@Test
	public void testGetTransactionList() throws IOException, DataFileException
	{
		tm = new TransactionMgr();
		ArrayList<Transaction> testList = new ArrayList();
		Transaction t1 = new Transaction();
		Transaction t2 = new Transaction();
		Transaction t3 = new Transaction();
		testList.add(t1);
		testList.add(t2);
		testList.add(t3);
		tm.setTransactionList(testList);
		ArrayList<Transaction> testList2 = new ArrayList();
		testList2 = tm.getTransactionList();
		for(int i = 0 ; i < testList.size(); i ++)
		{
			assertTrue(testList.get(i)==testList2.get(i));
		}
	}

	@Test
	public void testSave()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testAddTransaction()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetTransactionListByDate()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxId()
	{
		fail("Not yet implemented");
	}

}
