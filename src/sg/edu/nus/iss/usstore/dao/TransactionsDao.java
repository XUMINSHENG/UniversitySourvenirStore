package sg.edu.nus.iss.usstore.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import sg.edu.nus.iss.usstore.domain.Product;
import sg.edu.nus.iss.usstore.domain.Transaction;
import sg.edu.nus.iss.usstore.domain.TransactionItem;
import sg.edu.nus.iss.usstore.exception.DataFileException;
import sg.edu.nus.iss.usstore.exception.DataInputException;
import sg.edu.nus.iss.usstore.util.Util;

/**
 * provide Data Access to file for Product entity
 * 
 * @author Liu Xinzhuo
 *
 */
public class TransactionsDao extends BaseDao{

	// datafile name
	private static final String C_File_Name = "Transactions.dat";
	// determine if the No. of fields of a record is correct
	private static final int C_Field_No = 5; 

	/**
	 * 
	 * @return
	 * @throws DataInputException 
	 * @throws IOException 
	 * @throws DataFileException 
	 */
	public ArrayList<Transaction> loadDataFromFile() throws IOException, DataFileException {
		ArrayList<String> stringList = null;
		int flag = 0;
		Transaction tflag = new Transaction();
		stringList = super.loadStringFromFile(super.getcDatafolderpath() + C_File_Name);
		ArrayList<Transaction> dataList = new ArrayList<Transaction>();
		StringBuffer errMsg = new StringBuffer();
		for(int lineNo = 0; lineNo < stringList.size() ; lineNo++){
			String line = stringList.get(lineNo);
			String[] fields = line.split(Util.C_Separator);
			// when the No. of fields of a record is less then C_Field_No, skip this record
			if (fields.length != C_Field_No) {
				errMsg.append("datafile[" + C_File_Name + "] LineNo:" + (lineNo + 1) + System.getProperty("line.separator"));
				continue;
			}
			try {
				int id = Util.castInt(fields[0]);
				String productID = fields[1];
				String costomerID = fields[2];
				int qty = Util.castInt(fields[3]);
				
				Date date = Util.castDate(fields[4]);
				System.out.println("Dao"+date);
				if (flag == id)
				{
					TransactionItem ti = new TransactionItem(productID,qty);
					tflag.addItem(ti);
					//System.out.println("1");
				}
				else
				{
					TransactionItem ti = new TransactionItem(productID,qty);
					Transaction t = new Transaction(id,costomerID,date);
					t.addItem(ti);
					dataList.add(t);
					tflag = t;
					//System.out.println("2");
				}
				flag=id;
			}catch(DataInputException e){
				errMsg.append("datafile[" + C_File_Name + "] LineNo:" + (lineNo + 1) + System.getProperty("line.separator"));
			}
		}
		if (errMsg.length() > 0){
			String exceptionMsg = "Following data in file is not correct:" + System.getProperty("line.separator") + errMsg;
			throw new DataFileException(exceptionMsg);
		}
		//System.out.println(dataList.size());
		return dataList;
	}

	/**
	 * 
	 * @param dataList
	 * @throws IOException 
	 */
	public void saveDataToFile(ArrayList<Product> dataList) throws IOException {
		ArrayList<String> stringList = new ArrayList<String>();
		for(Product product : dataList){
			StringBuffer line;
			line = new StringBuffer(product.getProductId() + Util.C_Separator);
			line.append(product.getName() + Util.C_Separator);
			line.append(product.getBriefDescription() + Util.C_Separator);
			line.append(product.getQuantityAvaible() + Util.C_Separator);
			line.append(product.getPrice() + Util.C_Separator);
			line.append(product.getBarCodeNumber() + Util.C_Separator);
			line.append(product.getReorderQuantity() + Util.C_Separator);
			line.append(product.getOrderQuantity() + Util.C_Separator);
			stringList.add(line.toString());
		}
		super.saveStringToFile(super.getcDatafolderpath() + C_File_Name, stringList);
	}
}
