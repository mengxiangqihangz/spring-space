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
		
		String sql="select goods_id,goods_name,goods_price,goods_information,goods_remainNum,goods_picture from goods";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		
		
		
		try {
			pps=conn.prepareStatement(sql);
			res=pps.executeQuery();
			while(res.next()){
				Goods goods=new Goods();
				goods.setGid(res.getInt(1));
				goods.setGname(res.getString(2));
				goods.setGprice(res.getInt(3));
				goods.setGinformation(res.getString(4));
				goods.setGremainNum(res.getInt(5));
				goods.setGpicture(res.getString(6));
				listGoods.add(goods);
			}
			for (Goods good : listGoods) {
				System.out.println(good.getGid()+","+good.getGinformation()+","+good.getGname()+","+good.getGpicture());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
