//TransactionMgr.java
package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import sg.edu.nus.iss.usstore.dao.TransactionDao;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.util.Util;

public class TransactionMgr
{
	/**
	 * TransactionMgr Class
	 * 
	 * @author Liu Xinzhuo
	 * @author A0136010A
	 * @version 1.1
	 */
	private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	private TransactionDao td;

	public TransactionMgr() throws IOException, DataFileException
	{
		td = new TransactionDao(new Store());
		transactionList = new ArrayList<>();
	}
	
	public void loadData() throws IOException, DataFileException{
		transactionList = td.loadDataFromFile();
	}
	
	public void save() throws IOException
	{
		td.saveDataToFile(transactionList);
	}
	
	public TransactionMgr(Store store)
	{
		td = new TransactionDao(store);
	}
	
	public ArrayList<Transaction> getTransactionList()
	{
		return transactionList;
	}
	
	public void setTransactionList(ArrayList<Transaction> transactionList)
	{
		this.transactionList = transactionList;
	}
	
	public void addTransaction(Transaction transaction)
	{
		if(transaction.getId()==0)
		{
			transaction.setId(getMaxId()+1);
		}
		transactionList.add(transaction);
	}
	
	public ArrayList<Transaction> getTransactionListByDate(Date date)
	{
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		for(int i = 0;i<transactionList.size();i++)
		{
			Transaction t = (Transaction) transactionList.get(i);
			String date1 = Util.dateToString(date);
			String date2 = Util.dateToString(t.getDate());
			if (date1.equals(date2))
				result.add(t);
		}
		return result;
	}
	
	public int getMaxId(){
		int maxId = 0;
		
		for(Transaction transaction:this.transactionList){
			if (transaction.getId() > maxId) maxId = transaction.getId();
		}
		return maxId;
	}
}///~
