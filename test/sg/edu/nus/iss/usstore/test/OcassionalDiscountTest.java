
package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Member;
import sg.edu.nus.iss.usstore.domain.OcassionalDiscount;

public class OcassionalDiscountTest {

	OcassionalDiscount ocaDisc1 = new OcassionalDiscount("CENTENARY","Centenary Celebration in 2014",null,365,15.0,"A");
	OcassionalDiscount ocaDisc2 = new OcassionalDiscount("ORIENTATION_DAY","ORIENTATION_DAY",null,1,50.0,"A");

	@Test
	public void testMember() {
		assertFalse(ocaDisc1 == ocaDisc2);
		assertFalse(ocaDisc1.equals(ocaDisc2));
	}

	

}
