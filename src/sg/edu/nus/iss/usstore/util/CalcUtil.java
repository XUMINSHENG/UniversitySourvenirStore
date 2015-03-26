//CalcUtil.java
package sg.edu.nus.iss.usstore.util;

import java.math.BigDecimal;


public class CalcUtil
{
	/**
	 * add method
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double add(double v1, double v2) 
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}
	/**
	 * sub method
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double sub(double v1, double v2)
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}
	/**
	 * mul method
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double mul(double v1, double v2) 
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}
	/**
	 * div method
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double div(double v1, double v2)
	{
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2).doubleValue();
	}
}
