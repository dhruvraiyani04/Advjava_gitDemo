package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static void main(String[] args)  {
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/24advgen";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url,userName,password);
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
