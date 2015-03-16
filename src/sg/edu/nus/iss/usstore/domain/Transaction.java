package sg.edu.nus.iss.usstore.domain;

import java.util.Date;
import java.util.List;




public class Transaction {
	private int id;
	private Date date;
	private String contomer;
	private int discount;
	private List itemList;
	private double cashAmount;
	private int redeemedLoyaltyPoint;
	public Transaction()
	{
		
	}
	public Transaction(int id,List itemList,double cashAmount,int redeemedLoyaltyPoint)
	{
		this.id = id;
		this.itemList = itemList;
		this.cashAmount = cashAmount;
		this.redeemedLoyaltyPoint = redeemedLoyaltyPoint;
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
	public void addItem()
	{}
	public void removeItem()
	{}
	public double calcTotalPrice()
	{
		return 0;
	}
	public double calcDiscountPrice()
	{
		return calcTotalPrice()*discount;
	}
	public double calcChange()
	{
		return cashAmount-calcDiscountPrice();
	}
	public int calcGainedPoint()
	{
		return (int)(calcDiscountPrice()/100);
	}
	
}
