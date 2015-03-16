package sg.edu.nus.iss.usstore.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Transaction
{
	private int id;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private String date = dateFormat.format(new Date());
	private String costomerID = "public";
	private int discount = 0;
	private ArrayList<TransactionItem> itemList = new ArrayList<TransactionItem>();
	private double cashAmount = 0;
	private int redeemedLoyaltyPoint;

	public Transaction()
	{

	}

	public Transaction(int id, ArrayList<TransactionItem> itemList,
			String costomerID, String date)
	{
		this.id = id;
		this.itemList = itemList;
		this.costomerID = costomerID;
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

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
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

	public void addItem(TransactionItem transactionItem)
	{
		if (itemList.contains(transactionItem))
		{
			int i = itemList.indexOf(transactionItem);
			int add = itemList.get(i).getQty();
			itemList.get(i).setQty(transactionItem.getQty() + add);
		} else
		{
			itemList.add(transactionItem);
		}
	}

	public void removeItem(TransactionItem transactionItem)
	{
		if (itemList.contains(transactionItem))
		{
			itemList.remove(transactionItem);
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
