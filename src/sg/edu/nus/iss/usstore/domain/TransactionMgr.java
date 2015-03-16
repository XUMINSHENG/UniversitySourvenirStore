package sg.edu.nus.iss.usstore.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionMgr
{
	private ArrayList transactionList;
	
	public void setTransaction(ArrayList transactionList)
	{
		this.transactionList = transactionList;
	}
	
	public void newTransaction()
	{
		
	}
	
	public ArrayList<Transaction> getTransactionListByDate(Date date)
	{
		ArrayList<Transaction> result = new ArrayList<Transaction>();
		for(int i = 0;i<transactionList.size();i++)
		{
			Transaction t = (Transaction) transactionList.get(i);
			if (date == t.getDate());
				result.add(t);
		}
		return result;
	}
	
}
