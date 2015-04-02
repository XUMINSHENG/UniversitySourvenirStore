//TransactionMgr.java
package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
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
	 * @version 1.1
	 */
	private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	private TransactionDao td;
	
	public TransactionMgr() throws IOException, DataFileException
	{
		td = new TransactionDao(new Store());
		transactionList = td.loadDataFromFile();
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
			if (date.equals(t.getDate()))
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
