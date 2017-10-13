package mysqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MysqlTest {
	public static void main(String[] args) throws Exception {
		List<Goods> listGoods=new ArrayList<>();
		PreparedStatement pps;
		ResultSet res;
		
		String sql="select spittername,spitterpassword from spitter";
		String sq="insert into spitter values ('Ñ¹Ëõ','123')";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/upi-yx-mg","upi-yx-mg","1IzUt+rvO+TAcULVtuwBtQ==");
		
		pps=conn.prepareStatement(sq);
		pps.execute();
		conn.close();
		pps.close();
//		try {
//			pps=conn.prepareStatement(sql);
//			res=pps.executeQuery();
//			while(res.next()){
//				System.out.println(res.getString(1));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
	}
}
