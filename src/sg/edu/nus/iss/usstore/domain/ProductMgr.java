package store.product;

import java.util.ArrayList;
import store.gui.ProductsWindow;

public class ProductMgr {
	
	private ArrayList<Product> productList;
	
	
	public ProductMgr(ArrayList<Product> list){
		this.productList = list;
	}
	
	public ArrayList<Product> checkInventory(){
		if(productList.size()==0){
			return null;
		}
		ArrayList<Product> orderList = new ArrayList<Product>();
		for(int i=0;i<productList.size();i++){
			if(!productList.get(i).checkInventoryLevel()){
				orderList.add(productList.get(i));
			}
		}
		return null;
	}
	
	public Product getProductById(String id){
		for(int x=0;x<productList.size();x++){
			if(id.equals(productList.get(x).getProductId())){
				return productList.get(x);
			}
		}
		return null;
	}
	
	public ArrayList<Product> getProductList(){
		return this.productList;
	}
	
	public void addProduct(Product p){
		if(productList.contains(p)){
			int i = productList.indexOf(p);
			int add = productList.get(i).getQuantityAvaible();
			productList.get(i).setQuantityAvaible(p.getQuantityAvaible()+add);
		}else{
			this.productList.add(p);
		}
	}
	
	public void changeProductQty(Product p, int qty){
		if(productList.contains(p)){
			int i = productList.indexOf(p);
			productList.get(i).setQuantityAvaible(qty);
		}
		
	}
	
	public Product getProductByBarCode(String barCode){
		for(int x=0;x<productList.size();x++){
			if(barCode.equals(productList.get(x).getBarCodeNumber())){
				return productList.get(x);
			}
		}
		return new Product();
	}

}
