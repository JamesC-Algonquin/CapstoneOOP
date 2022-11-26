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
		//Connection Objects
		DBConnection dbConn = DBConnection.getDBConnection();
		Connection connect = null;
		//Query Objects
		String sqlPROF = "SELECT COUNT(*) AS COUNT FROM PROFESSOR WHERE EMAIL LIKE ? and PASSWORD LIKE ?;";
		ResultSet result = null;
		//Because email is not case sensitive
		email = email.toLowerCase();
		
		//Check Prof table first
		boolean prof = false;		
		try {
			connect = dbConn.getConnectionToDatabase();
			PreparedStatement stmt = connect.prepareStatement(sqlPROF);
			stmt.setString(1, email);
			stmt.setString(2, password);
			result = stmt.executeQuery();
			result.next();
			prof = result.getInt("COUNT") == 1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//If returns 1, prof logs in
		if(prof)
		{
			return profValid;
		}
		
		//If not, try Student Table
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
			return studentValid;
		}
		//else, reject login
		return 0;		
	}

	public static Professor getProfessor(String email) {
		DBConnection dbConn = DBConnection.getDBConnection();
		Connection conn = null;
		String sql = "SELECT * FROM PROFESSOR WHERE EMAIL LIKE ?;";
		ResultSet result = null;
		Professor prof = null;
		try {
			conn = dbConn.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			result = stmt.executeQuery();
			result.next();
			prof = new Professor(result.getInt("id"), result.getString("name"), result.getString("email"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return prof;
	}
	
	public static Student getStudent(String email) {
		DBConnection dbConn = DBConnection.getDBConnection();
		Connection conn = null;
		String sql = "SELECT * FROM STUDENT WHERE EMAIL LIKE ?;";
		ResultSet result = null;
		Student student = null;
		try {
			conn = dbConn.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			result = stmt.executeQuery();
			result.next();
			student = new Student(result.getInt("id"), result.getString("name"), result.getString("email"));
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		return student;
	}
	
	public static Grade getGrade(int id) {
		DBConnection dbConn = DBConnection.getDBConnection();
		Connection conn = null;
		String sql = "SELECT * FROM GRADE WHERE ID = ?;";
		ResultSet result = null;
		Grade grade = null;
		try {
			conn = dbConn.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			result.next();
			grade = new Grade(result.getInt("id"), result.getString("AssignmentName"), result.getDouble("GradePercentage"));
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		return grade;
	}
	
	public static void updateGrade(int id, String name, double percent) {
		DBConnection dbConn = DBConnection.getDBConnection();
		Connection conn = null;
		String sql = "UPDATE GRADE SET ASSIGNMENTNAME = ?, GRADEPERCENTAGE = ? WHERE ID = ?;";
		
		try {
			conn = dbConn.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setDouble(2, percent);
			stmt.setInt(3, id);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static ArrayList<Course> getCourses(int id){
		ArrayList<Course> courses = new ArrayList<>();
		DBConnection dbConn = DBConnection.getDBConnection();
		Connection conn = null;
		String sql = "SELECT * FROM COURSE WHERE PROFESSOR_ID = ?;";
		ResultSet result = null;
		
		try {
			conn = dbConn.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			while(result.next()) {
				Course course = new Course(result.getInt("id"), result.getString("CourseName"));
				courses.add(course);
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		
		return courses;
	}
	
	public static ArrayList<Enrolment> getEnrolment(int id){
		ArrayList<Enrolment> enrolments = new ArrayList<>();
		DBConnection dbConn = DBConnection.getDBConnection();
		Connection conn = null;
		String sql = "SELECT STUDENT.NAME AS name, STUDENT.EMAIL AS email, STUDENT.ID as sid, ENROLMENT.ID AS id FROM ENROLMENT JOIN STUDENT ON ENROLMENT.STUDENT_ID = STUDENT.ID "
				+ "JOIN COURSE ON ENROLMENT.COURSE_ID = COURSE.ID WHERE COURSE_ID = ?;";
		ResultSet result = null;
		
		try {
			conn = dbConn.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			while(result.next()) {
				Student student = new Student(result.getInt("sid"), result.getString("name"), result.getString("email"));
				Enrolment enrol = new Enrolment(result.getInt("id"), student);
				enrolments.add(enrol);
				
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return enrolments;
	}

	public static ArrayList<Grade> getGrades(int id){
		ArrayList<Grade> grades = new ArrayList<>();
		DBConnection dbConn = DBConnection.getDBConnection();
		Connection conn = null;
		String sql = "SELECT *  FROM GRADE WHERE ENROLMENT_ID = ?";	
		ResultSet result = null;
		
		try {
			conn = dbConn.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			result = stmt.executeQuery();
			while(result.next()) {
				Grade grade = new Grade(result.getInt("id"), result.getString("AssignmentName"), result.getDouble("GradePercentage"));
				grades.add(grade);
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return grades;
	}
	
	public static void insertGrade(int id, String name, double percent) {
		String sql = "INSERT INTO GRADE (ASSIGNMENTNAME, GRADEPERCENTAGE, ENROLMENT_ID) VALUES (?, ?, ?);";
		Connection conn = null;
		DBConnection dbConn = DBConnection.getDBConnection();
		try {
			conn = dbConn.getConnectionToDatabase();
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

	public static void createUser(String name, String email, String password, String type) {
		if (type.equals("prof")) {
			String sql = "INSERT INTO PROFESSOR (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?);";
			DBConnection dbConn = DBConnection.getDBConnection();
			Connection conn = null;
			email = email.toLowerCase();
			try {
				conn = dbConn.getConnectionToDatabase();
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, password);
				stmt.executeUpdate();
				System.out.println("saved to db/");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (type.equals("student")) {
			String sql = "INSERT INTO STUDENT (NAME, EMAIL, PASSWORD) VALUES (?, ?, ?);";
			DBConnection dbConn = DBConnection.getDBConnection();
			Connection conn = null;
			try {
				conn = dbConn.getConnectionToDatabase();
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, password);
				stmt.executeUpdate();
				System.out.println("saved to db/");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteGrade(int id) {
		
		DBConnection dbConn = DBConnection.getDBConnection();
		Connection conn = null;
		
		String sql = "DELETE FROM GRADE WHERE ID=?;";
		
		try {
			conn = dbConn.getConnectionToDatabase();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
