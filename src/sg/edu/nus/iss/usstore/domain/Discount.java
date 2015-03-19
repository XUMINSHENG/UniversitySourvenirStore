package sg.edu.nus.iss.usstore.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Discount {




	String discountCode;
	String discountDescription;
	Date startDate;
	int period;
	int percent;
	String Applicable;
	String isValid;

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public void setIsValid(String startDate, String period) {

		this.isValid = "N";

		int numPeriod;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Date discountDate = new Date();

		if (startDate.equalsIgnoreCase("ALWAYS")) {
			this.isValid = "Y";
		} else {
			try {
				discountDate = df.parse(startDate);
				
				/* * System.out.println("My Date is"+discountDate);
				 * System.out.println("Today Date is"+today); if
				 * (today.compareTo(discountDate)<0)
				 * System.out.println("Today Date is Lesser than discount Date"
				 * ); else if (today.compareTo(discountDate)>0)
				 * System.out.println
				 * ("Today Date is Greater than discount date"); else
				 * System.out.println("Both Dates are equal");
				 */
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		if ((today.compareTo(discountDate) >= 0)
				&& period.equalsIgnoreCase("ALWAYS")) {
			this.isValid = "Y";
		}
		if (!period.equalsIgnoreCase("ALWAYS")
				&& !startDate.equalsIgnoreCase("ALWAYS")) {

			// System.out.println("I am here");
			numPeriod = Integer.parseInt(period);
			Calendar c = Calendar.getInstance();
			c.setTime(discountDate);
			c.add(Calendar.DATE, numPeriod);
			Date discountEndDate = c.getTime();

			/*
			 * System.out.println("My Date is"+discountDate);
			 * System.out.println("Today Date is"+today);
			 * System.out.println("End Date is"+discountEndDate);
			 */

			if (today.compareTo(discountDate) >= 0
					&& today.compareTo(discountEndDate) < 0) {
				this.isValid = "Y";
			}

		}
		System.out.println("Is Valid" + this.isValid);

	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getDiscountDescription() {
		return discountDescription;
	}

	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setStartDate(String startDate) {
		Date date = null;

		if (startDate.equalsIgnoreCase("ALWAYS")) {
			startDate = "1900-01-01";
		}
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		try {
			date = df.parse(startDate);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		this.startDate = date;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public void setPeriod(String period) {
		if (period.equalsIgnoreCase("ALWAYS")) {
			period = "9999999";
		}
		this.period = Integer.parseInt(period);
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public void setPercent(String percent) {
		this.percent = Integer.parseInt(percent);
	}

	public String getApplicable() {
		return Applicable;
	}

	public void setApplicable(String applicable) {
		Applicable = applicable;
	}

	public Discount(String discountCode, String discountDescription,
			Date startDate, int period, int percent, String applicable) {
		super();
		this.discountCode = discountCode;
		this.discountDescription = discountDescription;
		this.startDate = startDate;
		this.period = period;
		this.percent = percent;
		Applicable = applicable;
	}

	public Discount() {
		super();
	}

	public static boolean isDiscountValid(String startDate, String period) {

		boolean isValid = false;

		int numPeriod;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Date discountDate = new Date();

		if (startDate.equalsIgnoreCase("ALWAYS")) {
			isValid = true;
		} else {
			try {
				discountDate = df.parse(startDate);
				/*
				 * System.out.println("My Date is"+discountDate);
				 * System.out.println("Today Date is"+today); if
				 * (today.compareTo(discountDate)<0)
				 * System.out.println("Today Date is Lesser than discount Date"
				 * ); else if (today.compareTo(discountDate)>0)
				 * System.out.println
				 * ("Today Date is Greater than discount date"); else
				 * System.out.println("Both Dates are equal");
				 */
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}

		if ((today.compareTo(discountDate) >= 0)
				&& period.equalsIgnoreCase("ALWAYS")) {
			isValid = true;
		}
		if (!period.equalsIgnoreCase("ALWAYS")
				&& !startDate.equalsIgnoreCase("ALWAYS")) {

			// System.out.println("I am here");
			numPeriod = Integer.parseInt(period);
			Calendar c = Calendar.getInstance();
			c.setTime(discountDate);
			c.add(Calendar.DATE, numPeriod);
			Date discountEndDate = c.getTime();

			/*
			 * System.out.println("My Date is"+discountDate);
			 * System.out.println("Today Date is"+today);
			 * System.out.println("End Date is"+discountEndDate);
			 */

			if (today.compareTo(discountDate) >= 0
					&& today.compareTo(discountEndDate) < 0) {
				isValid = true;
			}

		}
		System.out.println("Is Valid" + isValid);

		return isValid;

	}

}
