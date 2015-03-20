package sg.edu.nus.iss.usstore.domain;

import java.util.ArrayList;
import java.util.Date;

public class Transaction
{


	private int id;
	private Date date;
	private String customerID=null;
	private int discount;
	private ArrayList<TransactionItem> itemList = new ArrayList<TransactionItem>();
	private double cashAmount;
	public String getCustomerID()
	{
		return customerID;
	}

	public void setCustomerID(String customerID)
	{
		this.customerID = customerID;
	}

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
	// public static void main(String[] args)
	// {
	// Product pr= new Product("1","2","3","4",5,6.0,"7",8,9);
	// Product pr2= new Product("11","12","13","14",15,16.0,"17",18,19);
	// Product pr3= new Product("21","22","23","24",25,26.0,"27",28,29);
	// Product pr4= new Product("31","32","33","34",35,36.0,"37",38,39);
	// TransactionItem ti = new TransactionItem(pr,pr.getPrice(),5);
	// TransactionItem ti2 = new TransactionItem(pr2,pr2.getPrice(),4);
	// TransactionItem ti3 = new TransactionItem(pr3,pr3.getPrice(),3);
	// TransactionItem ti4 = new TransactionItem(pr4,pr4.getPrice(),4);
	// System.out.println(ti.calculateAmount());
	// System.out.println(ti2.calculateAmount());
	// System.out.println(ti3.calculateAmount());
	// System.out.println(ti4.calculateAmount());
	// Transaction t= new Transaction();
	// t.addItem(ti);
	// t.addItem(ti2);
	// t.addItem(ti3);
	// t.addItem(ti4);
	// System.out.println(t.calcTotalPrice());
	//
	// }

}
