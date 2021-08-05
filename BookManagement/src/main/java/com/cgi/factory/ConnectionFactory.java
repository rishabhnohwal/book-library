package com.cgi.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionFactory {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/booksdb";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root123";
	
	public static Connection getConnectionObject() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	    System.out.println("Connected to Database.");
	    return connection;
	}
	
//	static Connection con;
//	static {
//		try {
//			Context context = new InitialContext();
//			Context envContext = (Context) context.lookup("java:comp/env");
//			DataSource ds = (DataSource) envContext.lookup("jdbc/TomcatPool");
//			con=ds.getConnection();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static Connection getConnectionObject() {
//		return con;
//	}

}
