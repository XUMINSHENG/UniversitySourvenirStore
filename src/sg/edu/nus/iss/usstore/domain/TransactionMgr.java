package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import sg.edu.nus.iss.usstore.dao.TransactionsDao;
import sg.edu.nus.iss.usstore.exception.DataFileException;

public class TransactionMgr
{
	private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	private TransactionsDao td; 
	
	public void finalize() throws IOException
	{
		td.saveDataToFile(transactionList);
	}
	
	public TransactionMgr() throws IOException, DataFileException
	{
		td = new TransactionsDao();
		transactionList = td.loadDataFromFile();
	}
	public void setTransaction(ArrayList<Transaction> transactionList)
	{
		this.transactionList = transactionList;
	}
	public void newTransaction(Transaction transaction)
	{
		transactionList.add(transaction);
	}
	public ArrayList<Transaction> getTransactionListByDate(String dateString) throws ParseException
	{
		SimpleDateFormat df2 =new SimpleDateFormat("yyyy-MM-dd");
		Date date = df2.parse(dateString);
		//System.out.println(date);
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		for(int i = 0;i<transactionList.size();i++)
		{
			Transaction t = (Transaction) transactionList.get(i);
			System.out.println(t.getDate());
			System.out.println(date);
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
}
