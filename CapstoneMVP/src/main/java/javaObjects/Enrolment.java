package javaObjects;

public class Enrolment {
	
	private int id;
	private Student student;
	private Course course;
	
	public Enrolment(int i, Student s) {
		id = i;
		student = s;
	}
	
	public Enrolment(int i, Course c) {
		id = i;
		course = c;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Course getCourse() {
		return course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
