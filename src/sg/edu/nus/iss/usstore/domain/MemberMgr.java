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
	private MemberDao memberDao;

	public MemberMgr() throws IOException, DataFileException {

		memberList = new ArrayList<Member>();
		memberDao = new MemberDao();
		readFile();
	}

	public ArrayList<Member> registerMember(String name, String memberID,
			int loyaltyPoint) {

		memberList.add(new Member(name, memberID, loyaltyPoint));
		return memberList;
	}

	public ArrayList<Member> getMemberList() {

		return memberList;

	}

	public Member getMemberByID(String memID) {
		Iterator<Member> i = memberList.iterator();
		while (i.hasNext()) {
			Member mem = i.next();
			if (mem.getMemberID().equals(memID))
				return mem;
		}
		return null;
	}

	public void writeFile() throws IOException {
		memberDao.saveDataToFile(memberList);
	}

	public void readFile() throws IOException, DataFileException {
		memberList = memberDao.loadDataFromFile();
	}

}
