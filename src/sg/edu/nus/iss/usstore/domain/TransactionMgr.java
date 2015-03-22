//TransactionMgr.java
package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import sg.edu.nus.iss.usstore.dao.TransactionDao;
import sg.edu.nus.iss.usstore.exception.DataFileException;

public class TransactionMgr
{
	/**
	 * TransactionMgr Class
	 * 
	 * @author Liu Xinzhuo
	 * @author A0136010A
	 * @version 1.0
	 */
	private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	private TransactionDao td;
	
	public void finalize() throws IOException
	{
		td.saveDataToFile(transactionList);
	}
	
	public void save() throws IOException
	{
		td.saveDataToFile(transactionList);
	}
	
	public TransactionMgr(Store store) throws IOException, DataFileException
	{
		td = new TransactionDao(store);
		transactionList = td.loadDataFromFile();
	}
	public void setTransaction(ArrayList<Transaction> transactionList)
	{
		this.transactionList = transactionList;
	}
	public void addTransaction(Transaction transaction)
	{
		transactionList.add(transaction);
	}
	public ArrayList<Transaction> getTransactionListByDate(Date date)
	{
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		for(int i = 0;i<transactionList.size();i++)
		{
			Transaction t = (Transaction) transactionList.get(i);
			if (date.equals(t.getDate()))
				result.add(t);
		}
		return result;
	}
//	public static void main(String[] args) throws IOException, DataFileException, ParseException, InterruptedException
//	{
//		
//		
//		TransactionMgr tm = new TransactionMgr();
//		ArrayList al = tm.transactionList;
//		Transaction t1 = (Transaction) al.get(0);
//		Transaction t2 = (Transaction) al.get(1);
//		Transaction t3 = (Transaction) al.get(2);
//		System.out.println(t1.getId());
//		System.out.println(t1.getCostomerID());
//		System.out.println(t1.getDate());
//		System.out.println(t2.getId());
//		System.out.println(t2.getCostomerID());
//		System.out.println(t2.getDate());
//		System.out.println(t3.getId());
//		System.out.println(t3.getCostomerID());
//		System.out.println(t3.getDate());
//		
//		ArrayList a2 = t1.getItemList();
//		TransactionItem ti1 = (TransactionItem) a2.get(0);
//		TransactionItem ti2 = (TransactionItem) a2.get(1);
//		System.out.println(ti1.getPrice());
//		System.out.println(ti1.getQty());
//		System.out.println(ti1.getProduct());
//		System.out.println(ti2.getPrice());
//		System.out.println(ti2.getQty());
//		System.out.println(ti2.getProduct());
//		ArrayList al3 = tm.getTransactionListByDate("2013-09-28");
//		System.out.println(al3.size());
//		Transaction tt1  = (Transaction) al3.get(0);
//		System.out.println(tt1.getItemList().size());
		
//		TransactionMgr tm = new TransactionMgr();
//		
//		tm.finalize();
//	}
}///~
