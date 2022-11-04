package javaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			return studentValid;
		}
		
		return 0;		
	}

}
