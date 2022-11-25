package javaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaObjects.Course;
import javaObjects.Enrolment;
import javaObjects.Grade;
import javaObjects.Professor;
import javaObjects.Student;

public class ApplicationDAO {
	
	private static final int profValid = 1;
	private static final int studentValid = 2;
	
	public static int authenticateLogin(String email, String password) throws ClassNotFoundException, SQLException {
		Connection connect = null;
		String sqlPROF = "SELECT COUNT(*) AS COUNT FROM PROFESSOR WHERE EMAIL LIKE ? and PASSWORD LIKE ?;";
		ResultSet result = null;
		email = email.toLowerCase();
		boolean prof = false;		
		try {
			connect = DBConnection.getConnectionToDatabase();
			PreparedStatement stmt = connect.prepareStatement(sqlPROF);
			stmt.setString(1, email);
			stmt.setString(2, password);
			result = stmt.executeQuery();
			result.next();
			prof = result.getInt("COUNT") == 1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if(prof)
		{
			Professor.setUser(ApplicationDAO.getProfessor(email));
			return profValid;
		}
		
		String sqlStudent = "SELECT COUNT(*) AS COUNT FROM STUDENT WHERE EMAIL LIKE ? and PASSWORD LIKE ?;";
		result = null;
		boolean student = false;	
		try {
			PreparedStatement stmt = connect.prepareStatement(sqlStudent);
			stmt.setString(1, email);
			stmt.setString(2, password);
			result = stmt.executeQuery();
			result.next();
			student = result.getInt("COUNT") == 1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if(student)
		{
			Student.setUser(ApplicationDAO.getStudent(email));
			return studentValid;
		}
		
		return 0;		
	}

	public static Professor getProfessor(String email) {
		Connection conn = null;
		String sql = "SELECT * FROM PROFESSOR WHERE EMAIL LIKE ?;";
		ResultSet result = null;
		Professor prof = null;
		try {
			conn = DBConnection.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			result = stmt.executeQuery();
			result.next();
			prof = new Professor(result.getInt("id"), result.getString("name"), result.getString("email"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return prof;
	}
	
	public static Student getStudent(String email) {
		Connection conn = null;
		String sql = "SELECT * FROM STUDENT WHERE EMAIL LIKE ?;";
		ResultSet result = null;
		Student student = null;
		try {
			conn = DBConnection.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			result = stmt.executeQuery();
			result.next();
			student = new Student(result.getInt("id"), result.getString("name"), result.getString("email"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public static ArrayList<Course> getCourses(int id){
		ArrayList<Course> courses = new ArrayList<>();
		
		Connection conn = null;
		String sql = "SELECT * FROM COURSE WHERE PROFESSOR_ID = ?;";
		ResultSet result = null;
		
		try {
			conn = DBConnection.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			while(result.next()) {
				Course course = new Course(result.getInt("id"), result.getString("CourseName"));
				courses.add(course);
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return courses;
	}
	
	public static ArrayList<Enrolment> getEnrolment(int id){
		ArrayList<Enrolment> enrolments = new ArrayList<>();
		
		Connection conn = null;
		String sql = "SELECT STUDENT.NAME AS name, STUDENT.EMAIL AS email, STUDENT.ID as sid, ENROLMENT.ID AS id FROM ENROLMENT JOIN STUDENT ON ENROLMENT.STUDENT_ID = STUDENT.ID "
				+ "JOIN COURSE ON ENROLMENT.COURSE_ID = COURSE.ID WHERE COURSE_ID = ?;";
		ResultSet result = null;
		
		try {
			conn = DBConnection.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			while(result.next()) {
				Student student = new Student(result.getInt("sid"), result.getString("name"), result.getString("email"));
				Enrolment enrol = new Enrolment(result.getInt("id"), student);
				enrolments.add(enrol);
				
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return enrolments;
	}
	
	public static ArrayList<Grade> getGrades(int id){
		ArrayList<Grade> grades = new ArrayList<>();
		
		Connection conn = null;
		String sql = "SELECT *  FROM GRADE WHERE ENROLMENT_ID = ?";	
		ResultSet result = null;
		
		try {
			conn = DBConnection.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			while(result.next()) {
				Grade grade = new Grade(result.getInt("id"), result.getString("AssignmentName"), result.getDouble("GradePercentage"));
				grades.add(grade);
			}			
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return grades;
	}
	
	public static void insertGrade(int id, String name, double percent) {
		String sql = "INSERT INTO GRADE (ASSIGNMENTNAME, GRADEPERCENTAGE, ENROLMENT_ID) VALUES (?, ?, ?);";
		Connection conn = null;
		
		try {
			conn = DBConnection.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setDouble(2, percent);
			stmt.setInt(3, id);
			stmt.executeUpdate();
			System.out.println("saved to db/");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
