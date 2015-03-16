package sg.edu.nus.iss.usstore.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.exception.DataInputException;
import sg.edu.nus.iss.usstore.util.Util;

public class ProductDao extends BaseDao{

	private final String filename = "Products.dat";
	
	/**
	 * 
	 * @return
	 * @throws DataInputException 
	 * @throws IOException 
	 */
	public ArrayList<Product> loadDataFromFile() throws DataInputException, IOException {
		ArrayList<String> stringList = null;
		
		stringList = super.loadDataFromFile(this.filename);
		
		ArrayList<Product> dataList = new ArrayList<Product>();
		
		for(String line : stringList){
			
			String[] fields = line.split(Util.C_Separator);
			
			String productId = fields[0];
			String category = null;
			String name = fields[1];
			String briefDescription = fields[2];
			int quantityAvaible = Util.castInt(fields[3]);
			double price = Util.castDouble(fields[4]);
			String barCodeNumber = fields[5];
			int reorderQuantity = Util.castInt(fields[6]);
			int orderQuantity = Util.castInt(fields[7]);	
			
			Product product = new Product(productId, category, name, briefDescription, quantityAvaible, price, barCodeNumber, reorderQuantity, orderQuantity);
			
			dataList.add(product);
		}
		
		return dataList;
	}

	/**
	 * 
	 * @param dataList
	 * @throws FileNotFoundException 
	 */
	public void saveDataToFile(ArrayList<Product> dataList) throws FileNotFoundException {
		
		ArrayList<String> stringList = new ArrayList<String>();
		
		for(Product product : dataList){
			String line;
			
			line = product.getProductId() + Util.C_Separator;
			line = line + product.getName() + Util.C_Separator;
			line = line + product.getBriefDescription() + Util.C_Separator;
			line = line + product.getQuantityAvaible() + Util.C_Separator;
			line = line + product.getPrice() + Util.C_Separator;
			line = line + product.getBarCodeNumber() + Util.C_Separator;
			line = line + product.getReorderQuantity() + Util.C_Separator;
			line = line + product.getOrderQuantity() + Util.C_Separator;
			
			stringList.add(line);
		}
		
		super.saveDataToFile(this.filename, stringList);
		
	}
	
	
	
	
	
	
}
