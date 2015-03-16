package sg.edu.nus.iss.usstore.domain;

import java.util.ArrayList;

public class TransactionMgr
{
	private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	
	public void setTransaction(ArrayList<Transaction> transactionList)
	{
		this.transactionList = transactionList;
	}
	
	public void newTransaction(Transaction transaction)
	{
		transactionList.add(transaction);
	}
	
	public ArrayList<Transaction> getTransactionListByDate(String date)
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
//	public static void main(String[] args)
//	{
//		Transaction t = new Transaction();
//		Transaction t2 = new Transaction();
//		Transaction t3 = new Transaction();
//		t.setDate("1990-1-1");
//		t.setId(3);
//		System.out.println(t.getId());
//		System.out.println(t.getDate());
//		t2.setDate("1990-1-2");
//		t2.setId(5);
//		System.out.println(t2.getId());
//		System.out.println(t2.getDate());
//		t3.setDate("1990-1-1");
//		t3.setId(7);
//		System.out.println(t3.getId());
//		System.out.println(t3.getDate());		
//		TransactionMgr tm = new TransactionMgr();
//		tm.newTransaction(t);
//		tm.newTransaction(t2);
//		tm.newTransaction(t3);
//		System.out.println(t.getId());
//		System.out.println(t2.getId());
//		System.out.println(t3.getId());
//		ArrayList<Transaction> al=tm.getTransactionListByDate("1990-1-1");
//		System.out.println(al.size());
//		for (int i = 0; i < al.size();i++ )
//		{
//			Transaction tran = al.get(i);
//			System.out.println(tran.getId());
//		}
//	}
}
