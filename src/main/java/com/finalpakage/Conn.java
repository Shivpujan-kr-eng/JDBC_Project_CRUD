package com.finalpakage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	private static Connection conn;
	public static Connection getConnection() {
		if(conn==null) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://192.168.56.1:3306/college","admin","Root");
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        
			
		}
		
		
		return conn;
	}

}
