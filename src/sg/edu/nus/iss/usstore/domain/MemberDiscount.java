package sg.edu.nus.iss.usstore.domain;

import java.util.Date;

public class MemberDiscount extends Discount{

	public MemberDiscount(String discountCode, String discountDescription,
			Date startDate, int period, double percent, String Applicable) {
		super(discountCode, discountDescription, startDate, period, percent, Applicable);
		// TODO Auto-generated constructor stub
	}

}