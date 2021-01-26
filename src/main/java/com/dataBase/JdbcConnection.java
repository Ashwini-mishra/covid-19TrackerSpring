package com.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
	public Connection getDBConnection() {
		Connection conn = null;
		String User = "root";
		String Pass = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/country_data?allowPublicKeyRetrieval=true&useSSL=false", User, Pass);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
