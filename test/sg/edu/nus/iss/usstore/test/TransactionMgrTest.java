package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Customer;
import sg.edu.nus.iss.usstore.domain.Member;
import sg.edu.nus.iss.usstore.domain.MemberMgr;
import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.ProductMgr;
import sg.edu.nus.iss.usstore.domain.Public;
import sg.edu.nus.iss.usstore.domain.Store;
import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.domain.TransactionMgr;
import sg.edu.nus.iss.usstore.exception.DataFileException;

public class TransactionMgrTest
{
	TransactionMgr tm;
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
	public void testAddTransaction() throws IOException, DataFileException
	{
		tm = new TransactionMgr();
		ArrayList<Transaction> testList = new ArrayList();
		Transaction t1 = new Transaction();
		Transaction t2 = new Transaction();
		Transaction t3 = new Transaction();
		tm.addTransaction(t1);
		tm.addTransaction(t2);
		tm.addTransaction(t3);
		ArrayList<Transaction> testList2 = new ArrayList();
		testList2 = tm.getTransactionList();
		for(int i = 0 ; i < testList.size(); i ++)
		{
			assertTrue(testList.get(i)==testList2.get(i));
		}
	}

	@Test
	public void testGetTransactionListByDate() throws IOException, DataFileException, ParseException
	{
		tm = new TransactionMgr();
		tm.loadData();
		ArrayList<Transaction> testList = new ArrayList();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse("2013-09-28");
		Transaction t1 = new Transaction(1,new Public(),date);
		Transaction t2 = new Transaction(2,new Public(),date);
		Transaction t3 = new Transaction(3,new Public(),new Date());
		testList.add(t1);
		testList.add(t2);
		testList.add(t3);
		tm.setTransactionList(testList);
		testList = tm.getTransactionListByDate(date);
		assertTrue(testList.get(0).getDate()==t1.getDate());
		assertTrue(testList.get(1).getDate()==t2.getDate());
	}

	@Test
	public void testGetMaxId()
	{
		tm = new TransactionMgr(new Store());
		int result1 = tm.getMaxId();
		int result2 = 0;
		ArrayList<Transaction> testList= new ArrayList();
		testList = tm.getTransactionList();
		for (int i = 0; i < testList.size();i++)
		{
			if (testList.get(i).getId()>result2)
				result2 = testList.get(i).getId();
		}
		assertEquals(result1,result2);
	}

}
