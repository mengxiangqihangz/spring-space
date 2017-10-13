package com.zlyg.purchase.dao.sys.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IUserDao;
import com.zlyg.purchase.model.sys.SysRole;
import com.zlyg.purchase.model.sys.SysUser;
import com.zlyg.purchase.utils.getAgeUtils;


@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;

	@Override
	public PageNavigation<SysUser> getPageData(PageNavigation<SysUser> page) {
		page.setTotalCount(jdbcTemplate
				.queryForInt("select count(*) from sys_user where visitable = 1"));
		String sql = "select * from sys_user,sys_role where post_id = role_id and visitable =1 limit ?,? ";
		List<SysUser> list = jdbcTemplate.query(sql, new RowMapper<SysUser>() {
			public SysUser mapRow(ResultSet rs, int i) throws SQLException {
				SysUser user = new SysUser();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getInt("sex"));
				user.setCardId(rs.getString("cardid"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setTel(rs.getString("tel"));
				user.setStatus(rs.getInt("status"));
				user.setPostName(rs.getString("role_name"));
				user.setAccount(rs.getString("account"));
				user.setPwd(rs.getString("pwd"));
				return user;
			}
		}, page.getMinResult(), page.getMaxResult());
		page.setData(list);
		return page;
	}

	@Override
	public int addUser(SysUser user) {
		// TODO Auto-generated method stub
		getAgeUtils gau = new getAgeUtils();//获取年龄
		user.setAge(gau.getAgeByCardId(user.getCardId()));
		String sql = "insert into sys_user values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = jdbcTemplate.update(sql,user.getUserId(),user.getUserName(), user.getAge(),
				user.getSex(), user.getCardId(), user.getEmail(),
				user.getMobile(), user.getTel(), user.getStatus(),
				user.getPostId(), user.getAccount(), user.getPwd(),user.getVisitable());
		return i;
	}

	@Override
	public int deleteUser(SysUser user) {
		// TODO Auto-generated method stub
		String sql = "update sys_user set visitable = '0',status = '0' where visitable = '1' and user_id = ?";
		int i = jdbcTemplate.update(sql, user.getUserId());
		return i;
	}

	@Override
	public int editUser(SysUser user) {
		// TODO Auto-generated method stub
		getAgeUtils gau = new getAgeUtils();
		user.setAge(gau.getAgeByCardId(user.getCardId()));
		String sql = "update sys_user set user_name = ?,age = ?,sex = ?,cardid=?,email=?,mobile=?,tel=?,status=?,post_id=?,account=?,pwd=? where user_id = ? ";
		int i = jdbcTemplate.update(sql, user.getUserName(), user.getAge(),
				user.getSex(), user.getCardId(), user.getEmail(),
				user.getMobile(), user.getTel(), user.getStatus(),
				user.getPostId(), user.getAccount(), user.getPwd(),user.getUserId());
		System.out.println(i);
		return i;
	}

	@Override
	public SysUser findUserById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from sys_user,sys_role where post_id = role_id and user_id = ?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<SysUser>() {

			@Override
			public SysUser mapRow(ResultSet rs, int i) throws SQLException {
				// TODO Auto-generated method stub
				SysUser user = new SysUser();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getInt("sex"));
				user.setCardId(rs.getString("cardid"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setTel(rs.getString("tel"));
				user.setStatus(rs.getInt("status"));
				user.setPostId(rs.getInt("post_id"));
				user.setAccount(rs.getString("account"));
				user.setPwd(rs.getString("pwd"));
				user.setVisitable(rs.getInt("visitable"));
				return user;
			}
		}, id);
		
	}
	
	

	@Override
	public List<SysRole> getRole() {
		// TODO Auto-generated method stub
		String sql = "select * from sys_role";

		List<SysRole> list = jdbcTemplate.query(sql, new RowMapper<SysRole>() {
			public SysRole mapRow(ResultSet rs, int i) throws SQLException {
				SysRole role = new SysRole();
				role.setRoleId(rs.getString("role_id"));
				role.setRoleName(rs.getString("role_name"));
				return role;
			}
		});
		return list;
	}

	@Override
	public PageNavigation<SysUser> getSerchData(PageNavigation<SysUser> page,String key) {
		// TODO Auto-generated method stub
		
		page.setTotalCount(jdbcTemplate.queryForInt("select count(*) from sys_user where visitable = 1 and user_name like '%"+key+"%'"));
		String sql = "select * from sys_user,sys_role where post_id = role_id and user_name like '%"+key+"%' and visitable =1 limit ?,? ";
		List<SysUser> list = jdbcTemplate.query(sql, new RowMapper<SysUser>() {
			public SysUser mapRow(ResultSet rs, int i) throws SQLException {
				SysUser user = new SysUser();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getInt("sex"));
				user.setCardId(rs.getString("cardid"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setTel(rs.getString("tel"));
				user.setStatus(rs.getInt("status"));
				user.setPostName(rs.getString("role_name"));
				user.setAccount(rs.getString("account"));
				user.setPwd(rs.getString("pwd"));
				user.setVisitable(rs.getInt("visitable"));
				return user;
			}
		}, page.getMinResult(), page.getMaxResult());
		page.setData(list);
		return page;
	}

	@Override
	public PageNavigation<SysUser> getDelData(PageNavigation<SysUser> page) {
		// TODO Auto-generated method stub
		page.setTotalCount(jdbcTemplate
				.queryForInt("select count(*) from sys_user where visitable = 0"));
		String sql = "select * from sys_user,sys_role where post_id = role_id and visitable =0 limit ?,? ";
		List<SysUser> list = jdbcTemplate.query(sql, new RowMapper<SysUser>() {
			public SysUser mapRow(ResultSet rs, int i) throws SQLException {
				SysUser user = new SysUser();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getInt("sex"));
				user.setCardId(rs.getString("cardid"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setTel(rs.getString("tel"));
				user.setStatus(rs.getInt("status"));
				user.setPostName(rs.getString("role_name"));
				user.setAccount(rs.getString("account"));
				user.setPwd(rs.getString("pwd"));
				user.setVisitable(rs.getInt("visitable"));
				return user;
			}
		}, page.getMinResult(), page.getMaxResult());
		page.setData(list);
		return page;
	}

	@Override
	public int recover(SysUser user) {
		// TODO Auto-generated method stub
		String sql = "update sys_user set visitable = '1',status='1' where user_id = ?";
		int flag = jdbcTemplate.update(sql, user.getUserId());
		return flag;
	}

/*	@Override
	public List<SysUser> getUser() {
		String sql = "select * from sys_user";

		List<SysUser> list = jdbcTemplate.query(sql, new RowMapper<SysUser>() {
			public SysUser mapRow(ResultSet rs, int i) throws SQLException {
				SysUser user = new SysUser();
				user.setAccount(rs.getString("account"));
				user.setPwd(rs.getString("pwd"));
				user.setPostId(rs.getInt("post_id"));
				return user;
			}
		});
		return list;
	}*/

	@Override
	public int judgeLogin(SysUser user) {
		String sql="select count(*) from sys_user where account='"+user.getUserName()+ "' and pwd='"+user.getPwd()+"'";
		int i =jdbcTemplate.queryForInt(sql);
		return i ;
	}

}
