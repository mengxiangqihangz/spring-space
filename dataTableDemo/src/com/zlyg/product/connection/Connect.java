package com.zlyg.product.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/test";
	private static String name="root";
	private static String pwd="";
	
	public static Connection getConnection() throws Exception{
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,name,pwd);
		return conn;
	}	
}
