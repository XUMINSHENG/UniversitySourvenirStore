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
	public void testSave() throws IOException, DataFileException
	{

		tm = new TransactionMgr(new Store());
		ArrayList<Transaction> testList = new ArrayList();
		Transaction t1 = new Transaction();
		Transaction t2 = new Transaction();
		Transaction t3 = new Transaction();
		testList.add(t1);
		testList.add(t2);
		testList.add(t3);
		tm.setTransactionList(testList);
		tm.save();
		tm.loadData();
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
//		ArrayList<Transaction> testList = new ArrayList();
//		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//		Date date = df.parse("2013-09-28");
//		testList = tm.getTransactionListByDate(date);
//		System.out.println(date.toString());
//		System.out.println(testList.size());
//		Transaction t1 = testList.get(0);
//		MemberMgr mm = new MemberMgr();
//		Customer customer = mm.getMemberByID("F42563743156");
//		Transaction t2 = new Transaction(1,customer,date);
//		ProductMgr pm = new ProductMgr(new Store());
//		Product product1 = pm.getProductById("CLO/1");
//		Product product2 = pm.getProductById("MUG/1");
//		t2.addItem(product1,21.0, 2);
//		t2.addItem(product2,22.0, 3);
//		assertTrue(t1==t2);
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
