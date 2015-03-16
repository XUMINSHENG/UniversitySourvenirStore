package sg.edu.nus.iss.usstore.util;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sg.edu.nus.iss.usstore.exception.DataInputException;

public class Util {

	
	public static final String C_Separator = ",";
	
	public static final Color C_Color_Err = Color.RED;
	public static final Color C_Color_Ok = Color.WHITE;
	
	public static final String C_Date_Format = "dd/mm/yyyy";
	
	/**
	 * front-end validation 
	 * throw Exception when Component's text contains "," 
	 * 
	 * @return Component's text
	 * @throws DataInputException 
	 */
	public static String castString(javax.swing.text.JTextComponent sender) throws DataInputException{
		
		if (sender.getText().contains(C_Separator)){
			sender.setBackground(C_Color_Err);
			throw new DataInputException("text contains unexpected char(',')");
		}else{
			sender.setBackground(C_Color_Ok);
			return sender.getText();
		}
		
	}
	
	/**
	 * front-end validation
	 * 
	 * @return cast text to integer
	 * @throws DataInputException 
	 */
	public static int castInt(javax.swing.text.JTextComponent sender) throws DataInputException{
		
		int result;
		
		try{
			result = Integer.parseInt(sender.getText());
			sender.setBackground(C_Color_Ok);
			
		}catch(NumberFormatException e){
			sender.setBackground(C_Color_Err);
			throw new DataInputException("is not integer");
		}

		return result;
		
	}
	
	/**
	 * front-end validation
	 * 
	 * @return cast text to double
	 * @throws DataInputException 
	 */
	public static double castDouble(javax.swing.text.JTextComponent sender) throws DataInputException{
		
		double result;
		
		try{
			result = Double.parseDouble(sender.getText());
			sender.setBackground(C_Color_Ok);
			
		}catch(NumberFormatException e){
			sender.setBackground(C_Color_Err);
			throw new DataInputException("is not double");
		}

		return result;
	}
	
	/**
	 * front-end validation
	 * 
	 * @return cast text to date
	 * @throws DataInputException 
	 */
	public static Date castDate(javax.swing.text.JTextComponent sender) throws DataInputException{
		
		Date result;
		SimpleDateFormat sdf = new SimpleDateFormat(C_Date_Format);
		
		try{
			result = sdf.parse(sender.getText());
			sender.setBackground(C_Color_Ok);
			
		}catch(ParseException e){
			sender.setBackground(C_Color_Err);
			throw new DataInputException("is not a valid date");
		}

		return result;
	}
	
	
	
	
	
	
	
}
