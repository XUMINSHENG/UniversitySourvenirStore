package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Category;
import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.ProductMgr;
import sg.edu.nus.iss.usstore.domain.Vendor;

public class ProductMgrTest {

	private ArrayList<Product> list;
	private ProductMgr manager;
	
	public ProductMgrTest(){
		Category c = new Category();
		Product p = new Product("CGY/1",c, "product", "dpt", 10, 10.00, "barcode", 5, 10);
		list = new ArrayList<Product>();
		list.add(p);
		manager = new ProductMgr(list);
	}
	
	@Test
	public void testProductMgr() {
		assertEquals(list, manager.getProductList());
	}
	
	@Test
	public void testCheckInventory() {
		assertTrue(manager.checkInventory().isEmpty());;
	}

	@Test
	public void testGetNewProductIdByCategory() {
		assertEquals("test/1", manager.getNewProductIdByCategory("test"));
	}

	@Test
	public void testAddProduct() {
		Category c = new Category();
		Product p = new Product("CGY/2",c, "new product", "dpt", 20, 20.00, "code", 10, 20);
		list.add(p);
		manager.addProduct("CGY/2", "new product", c, "dpt", 20, 20.00, "code", 10, 20);
		assertEquals(list, manager.getProductList());
	}

	@Test
	public void testModifyProduct() {
		Category c = new Category();
		//Product p = ;
		list.get(0).setName("modify product");
		manager.modifyProduct("CGY/1", "modify product", c, "dpt", 20, 20.00, "code", 10, 20);
		assertEquals(list, manager.getProductList());
	}

	@Test
	public void testDeleteProduct() {
		list.remove(0);
		manager.deleteProduct("CGY/1");
		assertEquals(list, manager.getProductList());
	}

	@Test
	public void testChangeProductQty() {
		list.get(0).setQuantityAvailable(30);
		Category c = new Category();
		Product p = new Product("CGY/1",c, "modify product", "dpt", 20, 20.00, "code", 10, 20);
		manager.changeProductQty(p, 30);
		assertEquals(30, manager.getProductById("CGY/1").getQuantityAvailable());
	}

	@Test
	public void testGetProductById() {
		Category c = new Category();
		Product p = new Product("CGY/2",c, "product2", "dpt", 30, 20.00, "code", 10, 20);
		manager.addProduct("CGY/2", "product2", c, "dpt", 30, 20.00, "code", 10, 20);
		assertEquals("product2",manager.getProductById("CGY/2").getName());
	}

	@Test
	public void testGetProductByBarCode() {
		Category c = new Category();
		Product p = new Product("CGY/1",c, "product", "dpt", 10, 10.00, "barcode", 5, 10);
		manager.addProduct("CGY/1", "product", c, "dpt", 10, 10.00, "barcode", 5, 10);
		assertEquals("product", manager.getProductByBarCode("barcode").getName());
	}

	@Test
	public void testGetProductList() {
		assertEquals(list, manager.getProductList());
	}

}
