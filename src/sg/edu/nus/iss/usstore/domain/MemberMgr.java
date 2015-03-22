package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import sg.edu.nus.iss.usstore.dao.MemberDao;
import sg.edu.nus.iss.usstore.exception.DataFileException;

/**
 * @author Achyut Suresh Rao
 */

public class MemberMgr {

	private ArrayList<Member> memberList;
	private MemberDao customerDao;

	public MemberMgr() throws IOException, DataFileException {

		memberList = new ArrayList<Member>();
		customerDao = new MemberDao();
		readFile();
	}

	public ArrayList<Member> registerMember(String name, String memberID,
			int loyaltyPoint) throws IOException {

		memberList.add(new Member(name, memberID, loyaltyPoint));
		writeFile();
		return memberList;
	}

	public ArrayList<Member> getMemberList() {

		return memberList;

	}

	public Member getMemberByID(String memID) {
		Iterator<Member> i = memberList.iterator();
		while (i.hasNext()) {
			Member mem = i.next();
			if (mem.getMemberID() == memID)
				return mem;
		}
		return null;
	}

	public void writeFile() throws IOException {
		customerDao.saveDataToFile(memberList);
	}

	public void readFile() throws IOException, DataFileException {
		memberList = customerDao.loadDataFromFile();
	}

	/**
	 * public void writeToFile(ArrayList<Member> mem) { try { ObjectOutputStream
	 * os = new ObjectOutputStream( new FileOutputStream("member.dat"));
	 * os.writeObject(mem); os.close(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * public void readFromFile() { try { ObjectInputStream oi = new
	 * ObjectInputStream(new FileInputStream( "member.dat"));
	 * 
	 * @SuppressWarnings("unchecked") ArrayList<Member> mem =
	 *                                (ArrayList<Member>) oi.readObject();
	 *                                System.out.println(mem.toString());
	 *                                oi.close(); } catch (Exception e) { //
	 *                                TODO Auto-generated catch block
	 *                                e.printStackTrace(); }
	 * 
	 *                                }
	 **/

}
