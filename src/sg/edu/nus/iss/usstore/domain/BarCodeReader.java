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
		return reader.nextLine();
	}
	
	public String scanProductBarCode()
	{
		System.out.print("Enter Product Bar Code: ");
		return reader.nextLine();
	}
		
}

