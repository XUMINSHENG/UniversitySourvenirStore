package sg.edu.nus.iss.usstore.domain;

public class TransactionItem
{
	private Product product;
	private double price;
	private int qty;
	
	public TransactionItem()
	{
		
	}
	
	public TransactionItem(Product product,double price,int qty)
	{
		this.product = product;
		this.price = price;
		this.qty = qty;
	}
	
	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product product)
	{
		this.product = product;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getQty()
	{
		return qty;
	}
	public void setQty(int qty)
	{
		this.qty = qty;
	}
	
	
	public double calculateAmount()
	{
		return this.price*this.qty;
	}
	
//	public static void main(String[] args)
//	{
//		Product pr= new Product("1","2","3","4",5,6.0,"7",8,9);
//		Product pr2= new Product("11","12","13","14",15,16.0,"17",18,19);
//		Product pr3= new Product("21","22","23","24",25,26.0,"27",28,29);
//		Product pr4= new Product("31","32","33","34",35,36.0,"37",38,39);
//		TransactionItem ti = new TransactionItem(pr,pr.getPrice(),5);
//		TransactionItem ti2 = new TransactionItem(pr2,pr2.getPrice(),4);
//		TransactionItem ti3 = new TransactionItem(pr3,pr3.getPrice(),3);
//		TransactionItem ti4 = new TransactionItem(pr4,pr4.getPrice(),4);
//		System.out.println(ti.calculateAmount());
//		System.out.println(ti2.calculateAmount());
//		System.out.println(ti3.calculateAmount());
//		System.out.println(ti4.calculateAmount());
//	}
}
