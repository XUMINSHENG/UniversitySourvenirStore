package sg.edu.nus.iss.usstore.domain;

import java.util.Date;

public abstract class Discount {
	private String discountCode;
	private String discountDescription;
	private Date startDate;
	private int period;
	private double percent;
	private String Applicable;

	public Discount(String discountCode, String discountDescription,
			Date startDate, int period, double percent, String Applicable) {
		this.discountCode = discountCode;
		this.discountDescription = discountDescription;

	}

	public String getDiscountcode() {
		// TODO Auto-generated method stub
		return discountCode;
	}

	public String getDiscountDescription() {
		// TODO Auto-generated method stub
		return discountDescription;
	}

	public Date getStartDate() {
		// TODO Auto-generated method stub
		return startDate;
	}

	public int getPeriod() {
		return period;
	}

	public double getPercent() {
		return percent;
	}

	public String getApplicable() {
		return Applicable;
	}

}
