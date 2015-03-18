package sg.edu.nus.iss.usstore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sg.edu.nus.iss.usstore.exception.DataInputException;

/**
 * 
 * @author Xu Minsheng
 *
 */
public class Util {

	
	public static final String C_Separator = ",";
		
	public static final String C_Date_Format = "yyyy-mm-dd";
	
	/**
	 * front-end validation 
	 * throw Exception when Component's text contains "," 
	 * 
	 * @return Component's text
	 * @throws DataInputException 
	 */
	public static String castString(String s) throws DataInputException{
		
		if (s.contains(C_Separator)){
			
			throw new DataInputException(s + " contains unexpected char(',')");
		}else{
			return s;
		}
		
	}
	
	/**
	 * front-end validation
	 * 
	 * @return cast text to integer
	 * @throws DataInputException 
	 */
	public static int castInt(String s) throws DataInputException{
		
		int result;
		
		try{
			result = Integer.parseInt(s);			
		}catch(NumberFormatException e){
			throw new DataInputException(s + " is not integer");
		}

		return result;
		
	}
	
	/**
	 * front-end validation
	 * 
	 * @return cast text to double
	 * @throws DataInputException 
	 */
	public static double castDouble(String s) throws DataInputException{
		
		double result;
		
		try{
			result = Double.parseDouble(s);
		
		}catch(NumberFormatException e){
			throw new DataInputException(s + " is not double");
		}

		return result;
	}
	
	/**
	 * front-end validation
	 * 
	 * @return cast text to date
	 * @throws DataInputException 
	 */
	public static Date castDate(String s) throws DataInputException{
		
		Date result;
		SimpleDateFormat sdf = new SimpleDateFormat(C_Date_Format);
		
		try{
			result = sdf.parse(s);
			
		}catch(ParseException e){
			throw new DataInputException(s + " is not a valid date");
		}

		return result;
	}
	
	
	
	
	
	
	
}
