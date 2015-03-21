package sg.edu.nus.iss.usstore.domain;

public class Product {

	private String productId;
	private String category;
	private String name;
	private String briefDescription;
	private int quantityAvaible;
	private double price;
	private String barCodeNumber;
	private int reorderQuantity;
	private int orderQuantity;	
	
	public Product(String productId, String category, String name,
			String briefDescription, int quantityAvaible, double price,
			String barCodeNumber, int recorderQuantity, int orderQuantity) {
		super();
		this.productId = productId;
		this.category = category;
		this.name = name;
		this.briefDescription = briefDescription;
		this.quantityAvaible = quantityAvaible;
		this.price = price;
		this.barCodeNumber = barCodeNumber;
		this.reorderQuantity = recorderQuantity;
		this.orderQuantity = orderQuantity;
	}

	public boolean checkInventoryLevel(){
		if(this.quantityAvaible < this.reorderQuantity){
			return false;
		}
		return true;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	public int getQuantityAvaible() {
		return quantityAvaible;
	}

	public void setQuantityAvaible(int quantityAvaible) {
		this.quantityAvaible = quantityAvaible;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBarCodeNumber() {
		return barCodeNumber;
	}

	public void setBarCodeNumber(String barCodeNumber) {
		this.barCodeNumber = barCodeNumber;
	}

	public int getReorderQuantity() {
		return reorderQuantity;
	}

	public void setRecorderQuantity(int recorderQuantity) {
		this.reorderQuantity = recorderQuantity;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	public void show(){
		System.out.println(name);
	}
}
