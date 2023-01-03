package com.qsp.prepared_statement_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class StudentConnection {
	
	static Connection connection=null; 
public static Connection getConnection () {
	
	try {
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/jdbc-noida-preparestatement-project";
	String user = "root";
	String password = "Rahul123";
	connection =DriverManager.getConnection(url, user, password);
	return connection;	
	
     }catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;	
	
}

}
