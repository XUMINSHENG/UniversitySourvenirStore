package sg.edu.nus.iss.usstore.util;

import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.domain.TransactionItem;

public class TransferCheckOutTransaction
{
	public Object[][] UpdateCheckOut(Transaction transaction)
	{
		Object[][] data = new Object[100][6];
		
		for(int i = 0; i < transaction.getItemList().size();i++)
		{
			TransactionItem ti = transaction.getItemList().get(i);
			data[i][0]=i+1;
			data[i][1]=ti.getProduct().getName();
			data[i][2]=ti.getQty();
			data[i][3]=ti.getPrice();
			data[i][4]=ti.calculateAmount();
			data[i][5]=new Boolean(false);
		}
		return data;
	}
}
