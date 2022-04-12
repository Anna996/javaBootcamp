package bootcamp.oop.library;

public class Author {
	protected String name;
	protected char gender;
	
	
	public Author(String name, char gender) {
		setName(name);
		setGender(gender);
	}


	private void setName(String name) {
		this.name = name;
	}


	// N: None
	private void setGender(char gender) {
		this.gender = gender == 'm' || gender == 'f' ? gender : 'N';
	}	
}
