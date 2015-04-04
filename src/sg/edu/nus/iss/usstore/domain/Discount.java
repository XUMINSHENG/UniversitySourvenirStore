package sg.edu.nus.iss.usstore.domain;

/**
 * 
 * @author tanuj
 *
 */

public abstract class Discount {
	private String discountCode;
	private String discountDescription;
	//private String startDate;
	private int percent;
	private String Applicable;

	public Discount(String discountCode, String discountDescription,
			 int percent, String Applicable) {
			this.discountCode = discountCode;
			this.discountDescription = discountDescription;
        
			this.percent=percent;
			this.Applicable=Applicable;
        
		}

	public String getDiscountcode() {
		// TODO Auto-generated method stub
		return discountCode;
	}

	public String getDiscountDescription() {
		// TODO Auto-generated method stub
		return discountDescription;
	}
	
	public int getPercent() {
		return percent;
	}

	public String getApplicable() {
		return Applicable;
	}
	
	/**
	 * compare  percent with another discount, return the higher one
	 * 
	 * @param discount
	 * @return higher discount
	 */
	public Discount getHigherDiscount(Discount discount){
		if ((discount == null) || (this.getPercent() > discount.getPercent())) 
			return this;
	else 
			return discount;
	}

}
