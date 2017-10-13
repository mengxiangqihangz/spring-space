package com.zlyg.purchase.dao.sys.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IRoleDao;
import com.zlyg.purchase.model.sys.SysPri;
import com.zlyg.purchase.model.sys.SysPriId;
import com.zlyg.purchase.model.sys.SysRole;
@Repository
public class RoleDaoImpl implements IRoleDao {

	@Autowired
	public SimpleJdbcTemplate jdbcTemplate;


	@Override
	public PageNavigation<SysRole> list(PageNavigation<SysRole> page) {

		page.setTotalCount(getTotalRecord());


		String sql = "select * from sys_role limit ?,?";

		List<SysRole> list = jdbcTemplate.query(sql, new RowMapper<SysRole>() {
			public SysRole mapRow(ResultSet rs, int i) throws SQLException {
				SysRole role = new SysRole();
				role.setId(rs.getLong("id"));
				String sql1="select pri_id,pri_name from sys_pri where pri_id in (select pri_id from sys_pri_role where role_id='"+rs.getString("role_id")+"')";
				role.setRoleId(rs.getString("role_id"));
				role.setRoleName(rs.getString("role_name"));
				role.setRemark(rs.getString("remark"));
				role.setDataPri(jdbcTemplate.query(sql1, new RowMapper<SysPri>() {
					public SysPri mapRow(ResultSet rs, int i) throws SQLException {
						SysPri pri = new SysPri();
						pri.setPriId(rs.getString("pri_id"));
						pri.setPriName(rs.getString("pri_name"));
						return pri;
					}
				}));

				return role;
			}
		}, page.getMinResult(),page.getMaxResult());

		page.setData(list);

		return page;
	}



	private int getTotalRecord() {
		return jdbcTemplate.queryForInt("select count(*) from sys_role");
	}




	@Override
	public boolean addRole(SysRole role,SysPriId pri) {
		String sql = "insert into sys_role(role_id,role_name,remark) values(?,?,?)";
		String sql1="insert into sys_pri_role value(?,?)";

		int i = jdbcTemplate.update(sql,role.getRoleId(),role.getRoleName(),role.getRemark());
		if (pri.getPriId1()!=null) {
			jdbcTemplate.update(sql1,role.getRoleId(),pri.getPriId1());
		}
		if (pri.getPriId2()!=null) {
			jdbcTemplate.update(sql1,role.getRoleId(),pri.getPriId2());
		}
		if (pri.getPriId3()!=null) {
			jdbcTemplate.update(sql1,role.getRoleId(),pri.getPriId3());
		}
		if (pri.getPriId4()!=null) {
			jdbcTemplate.update(sql1,role.getRoleId(),pri.getPriId4());
		}
		

//		for ( String ww: pri.getPriIdLi()) {
//
//			jdbcTemplate.update(sql1,role.getRoleId(),ww);
//		}
		if(i>0){
			return true;
		}else{
			return false;
		}

	}



	@Override
	public boolean delRole(String id) {
		String sql = "delete from sys_role where id=?";
		String sql1 = "delete from sys_pri_role where role_id=(select role_id from sys_role where id =?)";

		jdbcTemplate.update(sql1,id);
		int i = jdbcTemplate.update(sql,id);
		if(i>0){
			return true;
		}else{
			return false;
		}

	}



	@Override
	public boolean editRole(SysRole role,SysPriId pri) {
		
		
		//获取数据role里的id,用于判断roleId是否改变
		String sq0 = "select role_id from sys_role ";
		
		List<SysRole> list = jdbcTemplate.query(sq0, new RowMapper<SysRole >() {
			public SysRole  mapRow(ResultSet rs, int i) throws SQLException {
				SysRole roleSql = new SysRole ();
				roleSql.setRoleId(rs.getString("role_id"));
				return roleSql;
			}
		});
		//判断前后roleId是否相等,不相等tag为假，可知更改了roleId;相等则tag为真,可知没有更改roleId
		boolean tag =false;
		String oleRoleId = null;
		for (SysRole sysRoleSql : list) {
			if(role.getRoleId()==sysRoleSql.getRoleId()){
				tag =true;
				oleRoleId = sysRoleSql.getRoleId();
			}
		}
		
		String sqlDel1="delete from sys_pri_role  where role_id="+role.getRoleId();
		String sqlDel2="delete from sys_pri_role  where role_id="+oleRoleId;
		
		if(tag){
			//没有更改roleId
			jdbcTemplate.update(sqlDel1);
		}else{
			//更改了roleId的
			jdbcTemplate.update(sqlDel2);
		}
		
		
		
		String sql = "update sys_role set role_id=?,  role_name=?,remark=? where id=?";
		
		String sqlAdd="insert into sys_pri_role value(?,?)";

		int i = jdbcTemplate.update(sql,role.getRoleId(),role.getRoleName(),role.getRemark(),role.getId());
		
		if (pri.getPriId1()!=null) {
			jdbcTemplate.update(sqlAdd,role.getRoleId(),pri.getPriId1());
		}
		if (pri.getPriId2()!=null) {
			jdbcTemplate.update(sqlAdd,role.getRoleId(),pri.getPriId2());
		}
		if (pri.getPriId3()!=null) {
			jdbcTemplate.update(sqlAdd,role.getRoleId(),pri.getPriId3());
		}
		if (pri.getPriId4()!=null) {
			jdbcTemplate.update(sqlAdd,role.getRoleId(),pri.getPriId4());
		}
		
		if(i>0){
			return true;
		}else{
			return false;
		}
	}


    /**
     * 根绝Id获取对应的角色信息，用于赋予编辑模态框
     */
	@Override
	public SysRole getRole(String id) {
		String sql = "select * from sys_role where id = ?";
		SysRole role =new SysRole();

		List<SysRole> role1 =  jdbcTemplate.query(sql, new RowMapper<SysRole>() {
			public SysRole mapRow(ResultSet rs, int i) throws SQLException {
				SysRole role = new SysRole();
				role.setId(rs.getLong("id"));
				role.setRoleId(rs.getString("role_id"));
				role.setRoleName(rs.getString("role_name"));
				role.setRemark(rs.getString("remark"));
				return role;
			}
		},id);

		role =role1.get(0);
		
		//根据roleId选择角色权限关联表里的priId
		String sql1 = "select * from sys_pri_role where role_id = ?";
		
	List<SysPri> priId = jdbcTemplate.query(sql1, new RowMapper<SysPri>() {
		public SysPri mapRow(ResultSet rs, int i) throws SQLException {
			SysPri pri = new SysPri();
			pri.setPriId(rs.getString("pri_id"));
			return pri;
		}
	}, id);
	
	
		role.setDataPri(priId);

		return role;
	}

/**
 *选择权限表里的内容，用于在角色添加编辑里的权限选择
 */
	public List<SysPri> getPri() {
		String sql = "select * from sys_pri";

		List<SysPri> list = jdbcTemplate.query(sql, new RowMapper<SysPri>() {
			public SysPri mapRow(ResultSet rs, int i) throws SQLException {
				SysPri pri = new SysPri();
				pri.setId(rs.getLong("id"));
				pri.setPriId(rs.getString("pri_id"));
				pri.setPriName(rs.getString("pri_name"));
				return pri;
			}
		});
		return list;
	}
}
