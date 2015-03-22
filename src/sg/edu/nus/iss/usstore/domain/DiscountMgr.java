package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.util.ArrayList;

import sg.edu.nus.iss.usstore.dao.DiscountDao;
import sg.edu.nus.iss.usstore.exception.DataFileException;

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






}


