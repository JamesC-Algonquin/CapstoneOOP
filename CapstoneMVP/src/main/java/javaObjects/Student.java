package javaObjects;

public class Student {
	
	private int id;
	private String name;
	private String email;
	//Static Student as User if Student Logs in
	private static Student studentUser;
	
	public Student(int id, String name, String email) {
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
	
	public static void setUser(Student student) {
		studentUser = student;
	}
	
	public static Student getUser() {
		return studentUser;
	}

}
