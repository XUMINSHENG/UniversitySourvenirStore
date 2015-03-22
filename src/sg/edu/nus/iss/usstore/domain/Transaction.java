//Transaction.java
package sg.edu.nus.iss.usstore.domain;

import java.util.ArrayList;
import java.util.Date;

public class Transaction
{
	/**
	 * Transaction Class
	 * 
	 * @author Liu Xinzhuo
	 * @author A0136010A
	 * @version 1.0
	 */
	private int id;
	private Date date;
	private String customerID=null;
	private int discount;
	private ArrayList<TransactionItem> itemList = new ArrayList<TransactionItem>();
	private double cashAmount;

	public int getDiscount()
	{
		return discount;
	}

	public void setDiscount(int discount)
	{
		this.discount = discount;
	}

	private int redeemedLoyaltyPoint;

	public Transaction()
	{
	}
	
	public Transaction(int id,String customerID, Date date)
	{
		this.id = id;
		this.customerID=customerID;
		this.date = date;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public ArrayList<TransactionItem> getItemList()
	{
		return itemList;
	}

	public void setItemList(ArrayList<TransactionItem> itemList)
	{
		this.itemList = itemList;
	}

	public double getCashAmount()
	{
		return cashAmount;
	}

	public void setCashAmount(double cashAmount)
	{
		this.cashAmount = cashAmount;
	}

	public int getRedeemedLoyaltyPoint()
	{
		return redeemedLoyaltyPoint;
	}

	public void setRedeemedLoyaltyPoint(int redeemedLoyaltyPoint)
	{
		this.redeemedLoyaltyPoint = redeemedLoyaltyPoint;
	}
	
//	public void addItem(TransactionItem transactionItem)
//	{
//		
//		if (itemList.contains(transactionItem))
//		{
//			int i = itemList.indexOf(transactionItem);
//			int add = itemList.get(i).getQty();
//			itemList.get(i).setQty(transactionItem.getQty() + add);
//		} else
//		{
//			itemList.add(transactionItem);
//		}
//	}
//	
	public void addItem(Product product,int qty)
	{
		TransactionItem transactionitem = new TransactionItem(product,product.getPrice(),qty);
		if (itemList.contains(transactionitem))
		{
			int i = itemList.indexOf(transactionitem);
			int add = itemList.get(i).getQty();
			itemList.get(i).setQty(transactionitem.getQty() + add);
		} else
		{
			itemList.add(transactionitem);
		}
	}
	
	public void addItem(Product product,double price,int qty)
	{
		TransactionItem transactionitem = new TransactionItem(product,price,qty);
		itemList.add(transactionitem);
	}

	public void removeItem(Product product)
	{
		for(int i = 0; i<itemList.size();i++)
		{
			if (itemList.get(i).getProduct()==product)
				itemList.remove(i);
		}
	}

	public double calcTotalPrice()
	{
		double sum = 0;
		for (int i = 0; i < itemList.size(); i++)
		{
			TransactionItem it = (TransactionItem) itemList.get(i);
			sum = sum + it.calculateAmount();
		}
		return sum;
	}

	public double calcDiscountPrice()
	{
		return calcTotalPrice() * (100 - discount) / 100;
	}

	public double calcChange()
	{
		return cashAmount - calcDiscountPrice();
	}

	public int calcGainedPoint()
	{
		return (int) (calcDiscountPrice() / 100);
	}

	public String getCustomerID()
	{
		return customerID;
	}

	public void setCustomerID(String costomerID)
	{
		this.customerID = costomerID;
	}
}///~
