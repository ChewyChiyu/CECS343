
public class Owner{

	private String name, password;

	public Owner(String name, String password){
		this.name = name;
		this.password = password;
	}

	public String getName(){ return name; }
	public String getPassword(){ return password; }

	public String toString(){ return "name: " + name + " password: " + password; }

	public String getData(){ return name + "," + password;	}

	public boolean equals(Owner o){ return name.equals(o.name)&&password.equals(o.password); }

}