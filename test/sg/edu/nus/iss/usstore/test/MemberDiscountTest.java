
package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.MemberDiscount;

public class MemberDiscountTest {
	
	MemberDiscount memDisc1 = new MemberDiscount("Member_First", "FirstPurchase",null,0,60,"M" );
	MemberDiscount memDisc2 = new MemberDiscount("Member1", "new discount1", null, 0, 30, "m");
	MemberDiscount memDisc3 = new MemberDiscount("Member2", "new discount2", null, 0, 25, "m");
	MemberDiscount memDisc4 = new MemberDiscount("Member3", "new discount3", null, 0, 17, "m");
	MemberDiscount memDisc5 = new MemberDiscount("Member4", "new discount4", null, 0, 12, "m");
	@Test
	public void testDiscountCode() {
		assertFalse(memDisc1 == memDisc2);
		assertFalse(memDisc1.equals(memDisc2));
	}

	@Test
	public void testDiscountDescription() {
		assertFalse(memDisc1 == memDisc2);
		assertFalse(memDisc1.equals(memDisc2));
	
	}
	

	

	
}
