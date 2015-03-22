package sg.edu.nus.iss.usstore.domain;

/**
 * 
 * @author Xu Minsheng
 *
 */
public class Vendor {
	private String name;
	private String description;
	
	public Vendor(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}