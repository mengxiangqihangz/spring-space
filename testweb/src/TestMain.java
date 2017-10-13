import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.DbConnection;

public class TestMain {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// oracle

		Connection con = DbConnection.getConnection("oracle");
		Statement st = con.createStatement();
		String sql = "select ename,sal,comm from emp";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			String name = rs.getString("ename");// String name=rs.getString(0);
			String sal = rs.getString("sal");
			String comm = rs.getString("comm");
			System.out.println("姓名：" + name + ",工资：" + sal + ",奖金：" + comm);
		}

		// mysql
		// Connection con = DbConnection.getConnection(null);
		// Statement st = con.createStatement();
		// String sql = "select fd_name,fd_sex,fd_age from student";
		// ResultSet rs = st.executeQuery(sql);
		// while (rs.next()) {
		// String name = rs.getString("fd_name");// String name=rs.getString(0);
		// String sex = rs.getString("fd_sex");
		// String age = rs.getString("fd_age");
		// System.out.println("姓名：" + name + ",性别：" + sex + ",年龄：" + age);
		// }
		st.close();
		con.close();
	}
}
