package sg.edu.nus.iss.usstore.domain;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;


public class Transaction {
	private int id;
	private Date date;
	//private costomer contomer;
	//private discount discount;
	private List itemList = new List();
	private double cashAmount;
	private int redeemedLoyaltyPoint;
	
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
	public List getItemList()
	{
		return itemList;
	}
	public void setItemList(List itemList)
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
	
	public void addItem(Product pro,int quan)
	{
	}
	
	public void removeItem()
	{
		
	}
	
	public void calcTotalPrice()
	{}
	
	public void calcDiscountedPrice()
	{}
	
	public void calcChange()
	{}
	
	public void calcGainedPoint()
	{}
	
//	public void printReceipt()
//	{}
	
	
	
}
