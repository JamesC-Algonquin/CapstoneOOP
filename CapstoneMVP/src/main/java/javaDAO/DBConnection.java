package javaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static final String dbUser = "dbuser";
    private static final String dbPassword = "dbpassword";
    private static final String connString = "jdbc:mysql://localhost:3306/gradedb";

    public static Connection getConnectionToDatabase() throws ClassNotFoundException, SQLException {
    	
    	//MYSQL connection that doesn't work without depricated features...
    	try {
    	Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e) {
    		System.err.println(e);
    	}
        Connection connection = null;
        try {
        	connection = DriverManager.getConnection(connString, dbUser, dbPassword);
        	System.out.println("DB connected.");
        }catch (SQLException e) {
        	System.err.println(e);
        }
     

        return connection;
    }

}
