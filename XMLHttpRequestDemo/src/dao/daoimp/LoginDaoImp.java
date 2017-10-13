package dao.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.DbConnection;

import dao.ILoginDao;

public class LoginDaoImp implements ILoginDao {

	Connection con;
	
	public LoginDaoImp() throws Exception{
		if(con==null){
			con=DbConnection.getConnection("");
		}
	}
	@Override
	public boolean validateLogin(String sql) throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs.next();
	}

}
