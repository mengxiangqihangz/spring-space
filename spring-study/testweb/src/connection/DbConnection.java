package connection;

import java.sql.Connection;
import java.sql.DriverManager;

import util.PropertieUtil;

public class DbConnection {
	
	public static Connection getConnection(String tag) throws Exception{
		String path=DbConnection.class.getResource("").getPath();
		if(tag==null||tag==""){
			path+="mysql.properties";
		}else{
			path+="oracle.properties";
		}
		String driver=PropertieUtil.getValue(path, "driver");
		String url=PropertieUtil.getValue(path, "url");
		String name=PropertieUtil.getValue(path, "name");
		String pwd=PropertieUtil.getValue(path, "password");
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, name, pwd);
		return con;
	}
	
//	public static void main(String[] args) throws Exception{
//		DbConnection.getConnection("");
//	}
}
