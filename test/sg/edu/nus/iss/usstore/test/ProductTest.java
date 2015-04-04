package sg.edu.nus.iss.usstore.test;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.experimental.categories.Categories;

import sg.edu.nus.iss.usstore.domain.Category;
import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.Vendor;

public class ProductTest {

	ProductTest test;
	
	@Test
	public void testProduct(){
		test = new ProductTest();
		Vendor vendor1 = new Vendor("vendor1", "the first vendor", 1);
		Vendor vendor2 = new Vendor("vendor2", "the sencond vendor", 0);
		ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
		vendorList.add(vendor1);
		vendorList.add(vendor2);
		Category category = new Category("category1","the first category",vendorList);
		//Product product1 = new Product(Category,"product1",);
	}
	
	
	
}
