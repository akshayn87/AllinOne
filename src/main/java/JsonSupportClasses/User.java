package JsonSupportClasses;

public class User {
	
	
	private String name;
    private String occupation;
    private int Age;
    private boolean married;
    
    
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOccupation() {
		return occupation;
	}


	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public boolean isMarried() {
		return married;
	}


	public void setMarried(boolean married) {
		this.married = married;
	}


	public User(String name, String occupation, int age, boolean married) {
		super();
		this.name = name;
		this.occupation = occupation;
		Age = age;
		this.married = married;
	}
	
	public User () {
		
	}
	
	 @Override
	    public String toString() {
	        final StringBuilder sb = new StringBuilder("User{");
	        sb.append("name='").append(name).append('\'');
	        sb.append(", occupation='").append(occupation).append('\'');
	        sb.append(", married=").append(married);
	        sb.append('}');
	        return sb.toString();
	    }
    
    

}
