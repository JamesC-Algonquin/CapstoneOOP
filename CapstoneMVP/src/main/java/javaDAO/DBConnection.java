package javaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static final String dbUser = "dbuser";
    private static final String dbPassword = "dbpassword";
    private static final String connString = "jdbc:mysql://localhost:3306/gradedb";
    
    private static Connection connection;
    private static DBConnection instance;
    
    //Singleton
    private DBConnection() {
    	//MYSQL connection that doesn't work without depricated features...
    	try {
    	Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e) {
    		System.err.println(e);
    	}
        try {
        	connection = DriverManager.getConnection(connString, dbUser, dbPassword);
        	System.out.println("DB connected.");
        }catch (SQLException e) {
        	System.err.println(e);
        }}
    
    public static DBConnection getDBConnection() {
    	if(instance == null) {
    		instance = new DBConnection();
    	}
    	return instance;
    }

    public Connection getConnectionToDatabase() throws ClassNotFoundException, SQLException {

        return connection;
    }

}
