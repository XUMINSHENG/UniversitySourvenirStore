package sg.edu.nus.iss.usstore.domain;

import java.util.Scanner;

/**
 * 
 * @author Charan
 *
 */
public class BarCodeReader {

	private Scanner reader;
	
	public BarCodeReader() {
		// TODO Auto-generated constructor stub
		reader = new Scanner(System.in);
	}
	
	public String scanMemberId()
	{
		System.out.print("Enter Member ID: ");
		String result  = reader.nextLine();
		System.out.print("Please Click 'Set Member' Button to set member on the GUI");
		return result;
	}
	
	public String scanProductBarCode()
	{
		System.out.print("Enter Product Bar Code: ");
		return reader.nextLine();
	}
		
}

