package sg.edu.nus.iss.usstore.domain;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import sg.edu.nus.iss.usstore.dao.DiscountDao;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.util.Util;

/*
 * 
 * 
 * @ tanuj
 */
public class DiscountMgr {
	private ArrayList<Discount> discountlist;
	private DiscountDao discountDao;
	
	public DiscountMgr() throws IOException, DataFileException{
		discountDao = new DiscountDao();
		loadData();
	}

	public DiscountMgr(ArrayList<Discount> list){
		this.discountlist = list;
	}

	public void loadData() throws IOException, DataFileException{
		discountlist = discountDao.loadDataFromFile();
	}
	
	
	public void saveData() throws IOException{
		discountDao.saveDataToFile(discountlist);
		
	}

	public ArrayList<Discount> getDiscountlist(){
		return this.discountlist;
	}

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
			if (d.getApplicable().equalsIgnoreCase("m") && isMember){
			    
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
				 
	else if(d.getStartDate().compareTo(currentDate) <= 0 && Util.addDays(d.getStartDate(), d.getPeriod()).compareTo(currentDate) >=0 ) {
				  if(maxDiscount < d.getPercent())
				  {
						maxDiscount=d.getPercent();
									  
					  }
				
			}
			
			
			
			}
			
			
			//System.out.println(d.getDiscountcode()+","+d.getDiscountDescription()+","+
		//d.getStartDate()+","+d.getPeriod()+","+d.getApplicable());
			
		
					
		return maxDiscount;
		
	}



}


