package javaObjects;

public class Enrolment {
	
	private int id;
	private Student student;
	
	public Enrolment(int i, Student s) {
		id = i;
		student = s;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
