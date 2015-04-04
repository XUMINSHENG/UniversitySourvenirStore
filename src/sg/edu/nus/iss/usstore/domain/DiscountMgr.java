package sg.edu.nus.iss.usstore.domain;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import sg.edu.nus.iss.usstore.dao.DiscountDao;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.util.Util;

/*
 * 
 * 
 * @ tanuj
 */
public class DiscountMgr {
	private ArrayList<Discount> discountList;
	private DiscountDao discountDao;
	
	public DiscountMgr(){
		discountDao = new DiscountDao();
		discountList = new ArrayList<>();
	}

	public void loadData() throws IOException, DataFileException{
		discountList = discountDao.loadDataFromFile();
	}
	
	
	public void saveData() throws IOException{
		discountDao.saveDataToFile(discountList);
		
	}

	public ArrayList<Discount> getDiscountlist(){
		return this.discountList;
	}


	
	
	/**
	 * 
	 * @param discountCode
	 * @param discountDescription
	 * @param startDate
	 * @param period
	 * @param percent
	 * @param Applicable
	 * @return
	 */
	public ArrayList<Discount> registerDiscount(String discountCode, String discountDescription,
			Date startDate, int period, double percent, String Applicable) {

		discountList.add(new MemberDiscount(discountCode, discountDescription, period, Applicable));
		return discountList;
	}

	public ArrayList<Discount> getdiscountList(){

		return discountList;

	}

	public Discount getdiscountCode(String discountCode) {
		Iterator<Discount> i = discountList.iterator();
		while (i.hasNext()) {
			Discount disc = i.next();
			if (disc.getDiscountcode().equals(discountCode))
				return disc;
		}
		return null;
	}

	public void writeFile() throws IOException {
		discountDao.saveDataToFile(discountList);
	}

	public void readFile() throws IOException, DataFileException {
		discountList = discountDao.loadDataFromFile();
	}

	
	
	
	
	
	
/**
 * 
 * @param customerId
 * @param loyaltyPoint
 * @return
 */
	
	
		
	/* maximum disc*/
	public double getMaxDiscount(String customerId,int loyaltyPoint){
		boolean isMember = false;
		boolean hasTransaction=false;
		double maxDiscount=0;
	    Date currentDate= new Date();
		
		ArrayList<Discount> discList = new ArrayList<Discount>();
		
		if(! customerId.equalsIgnoreCase("Public"))
		{
			isMember=true	;	
		}	
		if(loyaltyPoint!=-1)
		{
		
		hasTransaction=true;
		}
		
		discList= this.getDiscountlist();
		
		for(Discount d:discList)
		{
			if (d instanceof MemberDiscount && isMember){
			    
				if(!hasTransaction && d.getDiscountcode().equalsIgnoreCase("MEMBER_FIRST")){
					 if(maxDiscount < d.getPercent()){
						maxDiscount=d.getPercent();							  
					 }		
				}
				else if(!d.getDiscountcode().equalsIgnoreCase("MEMBER_FIRST")){
				
					if(maxDiscount < d.getPercent()){
						maxDiscount=d.getPercent();							  
					}		
				}
	
			} 
			else if (d instanceof OcassionalDiscount)
			{
				OcassionalDiscount od = (OcassionalDiscount)d;
				if(od.getStartDate().compareTo(currentDate) <= 0 && 
					Util.addDays(od.getStartDate(),od.getPeriod()).compareTo(currentDate) >=0 ) {
					if(maxDiscount < d.getPercent())
					{
						maxDiscount=d.getPercent();			  
					}	
				}
			}
			
		}
						
		return maxDiscount;
		
	}

	/**
	 * according to customer's type, return the applicable and highest discount
	 * 
	 * @param customer
	 * @return highest discount (may be null)
	 */
	public Discount getMaxDiscount(Customer customer){
		boolean isMember = false;
		boolean hasTransaction=false;
		Discount maxDiscount = null;
	    Date currentDate= new Date();
		
		if(customer instanceof Member){
			isMember=true;
			if(((Member) customer).getLoyaltyPoint() != -1){
				hasTransaction=true;
			}
		}
		
		for(Discount discount:this.discountList){
			if (discount instanceof MemberDiscount && isMember){
			    // discount for member only && customer is a member 
				
				if(!hasTransaction && discount.getDiscountcode().equalsIgnoreCase("MEMBER_FIRST")){
					// discount for member's first purchase only
					maxDiscount = discount.getHigherDiscount(maxDiscount);
				}
				else if(!discount.getDiscountcode().equalsIgnoreCase("MEMBER_FIRST")){
					// discount for member's subseq purchase
					maxDiscount = discount.getHigherDiscount(maxDiscount);
				}
			}
			else if(discount instanceof OcassionalDiscount) {
				OcassionalDiscount od = (OcassionalDiscount)discount;
				if(od.getStartDate().compareTo(currentDate) <= 0 && 
					Util.addDays(od.getStartDate(), od.getPeriod()).compareTo(currentDate) >=0 ) {
					// occasional discount is valid for current date 
					maxDiscount = discount.getHigherDiscount(maxDiscount);
				}
			}
		}
		
		return maxDiscount;
	}

	public void modifyDiscount(String discountCode, String discountDescription,
			Date startDate, int period, double percent, String applicable) {
		// TODO Auto-generated method stub
		
	}

	public void deleteDiscount(int index) {
		// TODO Auto-generated method stub
		
	} 


}
