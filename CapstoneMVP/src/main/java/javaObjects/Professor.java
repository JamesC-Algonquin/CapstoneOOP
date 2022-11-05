package javaObjects;



public class Professor {
	
	private int id;
	private String name;
	private String email;
	
	//Static Professor Object as User, if Prof logs in
	private static Professor profUser;
	
	public Professor(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static void setUser(Professor prof) {
		profUser = prof;
	}
	
	public static Professor getUser(){
		return profUser;
	}
	

}
