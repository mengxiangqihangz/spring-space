package cn.com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	static Connection conn;
	static Statement state;
	static ResultSet res;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		connectOracle();
		connectMysql();
	}

	public static void connectOracle() throws ClassNotFoundException, SQLException {
		String sql = "select spittername,spassword from spitter";

		Class.forName("oracle.jdbc.OracleDriver");// 加载驱动
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");// 与数据库建立连接
		state = conn.createStatement(); // 创建（此数据库的）语句容器。
		res = state.executeQuery(sql);
		// 将sql语句塞入容器中（对此数据库进行查询，并返回查询结果，将结果塞入Resultset容器中。）

		while (res.next()) {
			String in = res.getString("spittername");
			String st = res.getString("spassword");
			System.out.println(in + "," + st);
		}
	}

	public static void connectMysql() throws ClassNotFoundException, SQLException {
		String sql = "select spittername,spitterpassword from spitter";

		Class.forName("com.mysql.jdbc.Driver");// 加载驱动
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");// 与数据库建立连接
		state = conn.createStatement(); // 创建（此数据库的）语句容器。
		res = state.executeQuery(sql); // 将sql语句塞入容器中（对此数据库进行查询，并返回查询结果，将结果塞入Resultset容器中。）

		while (res.next()) {
			String in = res.getString("spittername");
			String st = res.getString("spitterpassword");
			System.out.println(in + "," + st);
		}
	}
}
