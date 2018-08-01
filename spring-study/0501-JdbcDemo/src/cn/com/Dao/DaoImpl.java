package cn.com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import cn.com.source.Spitter;

public class DaoImpl {
	private static String sql="insert into spitter(username,password) values (?,?)";
	
	private BasicDataSource dataSource;
	
	public void addSpitter(Spitter spit){
		Connection conn=null;
		PreparedStatement stat=null;
		
		try {
			conn=dataSource.getConnection();
			stat=conn.prepareStatement(sql);
			stat.setString(1, spit.getUsername());
			stat.setString(2, spit.getPassword());
			stat.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
