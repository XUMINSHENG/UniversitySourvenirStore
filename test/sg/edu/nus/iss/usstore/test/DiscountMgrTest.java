package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Discount;
import sg.edu.nus.iss.usstore.domain.DiscountMgr;
import sg.edu.nus.iss.usstore.domain.MemberDiscount;

public class DiscountMgrTest {

	ArrayList<Discount> discountList = new ArrayList<>();
	MemberDiscount dis1 = new MemberDiscount("Member", "For member", 20, "A");
	DiscountMgr disMgr = new DiscountMgr();
	

	@Test
	public void testDiscountMgr() {
		discountList.add(dis1);
		assertTrue(disMgr.toString() !=null);
		
	}
	
	@Test
	public void testGetDiscountlist() {
		discountList.add(dis1);
		assertEquals("Member,For member,20,A",disMgr.getDiscountlist());
	}
	
	/*@Test
	public void testRegisterDiscount() {
		disMgr.registerDiscount("Member", "For Members", "ALWAYS","ALWAYS",10,"A");
	}*/
	
	

	@Test
	public void testGetDiscountCode() {
		discountList.add(dis1);
		assertEquals("Member", disMgr.getDiscountCode("Member"));
	}
	/*
	@Test
	public void testGetMaxDiscount() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddDiscount() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyMemberDiscount() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyOcassionalDiscount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDiscount() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDiscountByCode() {
		fail("Not yet implemented");
	}
*/
}
