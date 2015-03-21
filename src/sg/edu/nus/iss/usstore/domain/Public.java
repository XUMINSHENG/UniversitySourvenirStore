package sg.edu.nus.iss.usstore.domain;

/**
 * @author Achyut Suresh Rao
 */

public class Public extends Customer {

	private static final long serialVersionUID = 1L;

	public Public(String name) {
		super(name);
	}

	public String getID() {
		return "PUBLIC";
	}

}
