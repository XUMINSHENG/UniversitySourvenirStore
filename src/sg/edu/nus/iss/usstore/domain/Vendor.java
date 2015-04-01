package sg.edu.nus.iss.usstore.domain;

/**
 * 
 * @author 
 *
 */
public class Vendor implements Comparable<Vendor>{
	private String name;
	private String description;
	private int preference;
	
	public Vendor(String name, String description, int preference) {
		super();
		this.name = name;
		this.description = description;
		this.preference = preference;
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
	
	public int getPreference() {
		return preference;
	}

	public void setPreference(int preference) {
		this.preference = preference;
	}

	public Vendor comparePreference(Vendor anotherVd){
		Vendor result;
		if (anotherVd == null){
			result = this;
		}
		else{
			if (this.getPreference() < anotherVd.getPreference()){
				result = this;
			}else{
				result = anotherVd;
			}
		}
		return result;
	}

	@Override
	public int compareTo(Vendor o) {
		// TODO Auto-generated method stub
		
		if( this.getPreference() > o.getPreference()) return 1;
		else return -1;
	}
	
}
