package sg.edu.nus.iss.usstore.domain;

import java.util.ArrayList;

/**
 * 
 * @author Xu Minsheng
 *
 */
public class Category {
	private String code;
	private String name;
	private ArrayList<Vendor> vendorList;
	
	public Category(String code, String name, ArrayList<Vendor> vendorList) {
		super();
		this.code = code;
		this.name = name;
		this.vendorList = vendorList;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Vendor> getVendorList() {
		return vendorList;
	}
	public void setVendorList(ArrayList<Vendor> vendorList) {
		this.vendorList = vendorList;
	}
	
	/**
	 * 
	 * @return most preference vendor
	 */
	public Vendor getFirstVendor(){
		Vendor vendor = null;
		
		// has vendor
		if (!this.vendorList.isEmpty()){
			vendor = this.vendorList.get(0);
		}
		
		return vendor;
	}
	
}
