package javaObjects;

public class Grade {
	
	private int id;
	private String assignmentName;
	private double gradePercentage;
	
	public Grade(int id, String assignmentName, double gradePercentage) {
		this.id = id;
		this.assignmentName = assignmentName;
		this.gradePercentage = gradePercentage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public double getGradePercentage() {
		return gradePercentage;
	}

	public void setGradePercentage(double gradePercentage) {
		this.gradePercentage = gradePercentage;
	}
	

}
