package sg.edu.nus.iss.usstore.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import sg.edu.nus.iss.usstore.domain.Member;
import sg.edu.nus.iss.usstore.domain.MemberMgr;
import sg.edu.nus.iss.usstore.exception.DataFileException;

public class MemberMgrTest {

	MemberMgr memMgr;
	ArrayList<Member> member = new ArrayList<>();

	public MemberMgrTest() throws IOException, DataFileException {
		memMgr = new MemberMgr();
	}

	@Test
	public void testMemberMgr() throws IOException, DataFileException {
		MemberMgr memMgr1 = new MemberMgr();
		assertFalse(memMgr1.toString() == null);
		assertTrue(memMgr.toString() != null);
	}

	@Test
	public void testRegisterMember() {
		member.add(new Member("sam", "a0123654", 100));
		assertFalse(member.isEmpty());

	}

	@Test
	public void testGetMemberList() {
		member.add(new Member("sam", "a0123654", 100));
		member.add(new Member("john", "a0223654", 200));
		assertEquals("[sam,a0123654,100, john,a0223654,200]", member.toString());
	}

	/*@Test
	public void testGetMemberByID() {
		
	}

	
	 * @Test public void testWriteFile() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testReadFile() { fail("Not yet implemented"); }
	 */

}
