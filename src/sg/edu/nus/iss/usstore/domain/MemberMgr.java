package sg.edu.nus.iss.usstore.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import sg.edu.nus.iss.usstore.dao.CustomerDao;
import sg.edu.nus.iss.usstore.exception.DataFileException;

/**
 * @author Achyut Suresh Rao
 */

public class MemberMgr {

	private ArrayList<Member> member;
	private CustomerDao customerDao;

	public MemberMgr() throws IOException, DataFileException {

		member = new ArrayList<Member>();
		customerDao = new CustomerDao();
		readFile();
	}

	public ArrayList<Member> registerMember(String name, String memberID,
			int loyaltyPoint) throws IOException {

		member.add(new Member(name, memberID, loyaltyPoint));
		writeFile();
		return member;
	}

	public ArrayList<Member> getMemberList() {

		return member;

	}

	public Member getMemberByID(String memID) {
		Iterator<Member> i = member.iterator();
		while (i.hasNext()) {
			Member mem = i.next();
			if (mem.getMemberID() == memID)
				return mem;
		}
		return null;
	}

	public void writeFile() throws IOException {
		customerDao.saveDataToFile(member);
	}

	public void readFile() throws IOException, DataFileException {
		member = customerDao.loadDataFromFile();
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
