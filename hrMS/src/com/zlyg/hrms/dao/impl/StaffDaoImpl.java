package com.zlyg.hrms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zlyg.hrms.common.PageNavigation;
import com.zlyg.hrms.dao.IStaffDao;
import com.zlyg.hrms.model.sys.SysStaff;




@Repository
public class StaffDaoImpl implements IStaffDao{

	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;
	
	/* 
	 * 员工分页分页数据
	 */
	@Override
	public PageNavigation<SysStaff> getPageData(PageNavigation<SysStaff> page) {
		page.setTotalCount(jdbcTemplate.queryForInt("select count(*) from sys_staff where staff_visible='1'"));
		String sql="select * from sys_staff where staff_visible='1' limit ?,?";
		List <SysStaff>list = jdbcTemplate.query(sql,new RowMapper<SysStaff>(){
			public SysStaff mapRow(ResultSet rs,int i) throws SQLException{
				SysStaff staff = new SysStaff();
				staff.setId(rs.getLong("Id"));
				staff.setStaff_id(rs.getString("staff_id"));
				staff.setStaff_name(rs.getString("staff_name"));
				staff.setSex(rs.getString("Staff_sex"));
				staff.setStatus(rs.getString("staff_status"));
				staff.setSource(rs.getString("staff_source"));
				staff.setReservation(rs.getString("staff_reservation"));
				staff.setBuildDate(rs.getString("staff_buildDate"));
				staff.setBuildMan(rs.getString("staff_buildMan"));
				staff.setVisitDate(rs.getString("staff_visitDate"));
				staff.setBirthday(rs.getString("staff_birthday"));
				staff.setGraduateSchool(rs.getString("staff_graduateSchool"));
				staff.setEducation(rs.getString("staff_education"));
				staff.setContact(rs.getString("staff_contact"));
				staff.setUrgencyName(rs.getString("staff_urgencyName"));
				staff.setUrgencyPhone(rs.getString("staff_urgencyPhone"));
				staff.setJobInterview(rs.getString("staff_jobInterview"));
				staff.setVisible(rs.getString("staff_visible"));
				staff.setUserId(rs.getString("user_id"));
				return staff;
			}
		}, page.getMinResult(),page.getMaxResult());
		page.setData(list);
		jdbcTemplate.queryForList(sql, page.getMinResult(),page.getMaxResult());
		return page;
	}
	/* 
	 * 添加前来面试的人员信息
	 */
	@Override
	public String addStaff(SysStaff staff) {
		String sql="insert into sys_staff value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		int i=jdbcTemplate.update(sql, 
				staff.getId(),
				staff.getStaff_id(),
				staff.getStaff_name(),
				staff.getSex(),
				staff.getStatus(),
				staff.getSource(),
				staff.getReservation(),
				staff.getBuildDate(),
				staff.getBuildMan(),
				staff.getVisitDate(),
				staff.getBirthday(),
				staff.getGraduateSchool(),
				staff.getEducation(),
				staff.getContact(),
				staff.getUrgencyName(),
				staff.getUrgencyPhone(),
				staff.getJobInterview(),
				staff.getVisible(),
				staff.getUserId());
		
		return String.valueOf(i);
	}

	/*
	 * 分页获取黑名单数据
	 */
	@Override
	public PageNavigation<SysStaff> getBlackList(PageNavigation<SysStaff> page) {
		page.setTotalCount(jdbcTemplate.queryForInt("select count(*) from sys_staff where staff_visible='0'"));
		String sql="select * from sys_staff where staff_visible='0' limit ?,?";
		List <SysStaff>list = jdbcTemplate.query(sql, new RowMapper<SysStaff>(){
			public SysStaff mapRow(ResultSet rs,int i) throws SQLException{
				SysStaff staff = new SysStaff();
				staff.setId(rs.getLong("Id"));
				staff.setStaff_id(rs.getString("staff_id"));
				staff.setStaff_name(rs.getString("staff_name"));
				staff.setSex(rs.getString("Staff_sex"));
				staff.setStatus(rs.getString("staff_status"));
				staff.setSource(rs.getString("staff_source"));
				staff.setReservation(rs.getString("staff_reservation"));
				staff.setBuildDate(rs.getString("staff_buildDate"));
				staff.setBuildMan(rs.getString("staff_buildMan"));
				staff.setVisitDate(rs.getString("staff_visitDate"));
				staff.setBirthday(rs.getString("staff_birthday"));
				staff.setGraduateSchool(rs.getString("staff_graduateSchool"));
				staff.setEducation(rs.getString("staff_education"));
				staff.setContact(rs.getString("staff_contact"));
				staff.setUrgencyName(rs.getString("staff_urgencyName"));
				staff.setUrgencyPhone(rs.getString("staff_urgencyPhone"));
				staff.setJobInterview(rs.getString("staff_jobInterview"));
				staff.setVisible(rs.getString("staff_visible"));
				staff.setUserId(rs.getString("user_id"));
				return staff;
			}
		}, page.getMinResult(),page.getMaxResult());
		page.setData(list);
		return page;
	}

	/* 
	 * 洗白黑名单的数据
	 */
	@Override
	public String washWhite(SysStaff staff) {
		String sql="update sys_staff set staff_visible='1'  where Id=?";
		int i=jdbcTemplate.update(sql, 
				staff.getId());
		return String.valueOf(i);
	}

	/* 
	 * 关键字查询白名单数据
	 */
	@Override
	public PageNavigation<SysStaff> quPageData(PageNavigation<SysStaff> page, SysStaff staff) {
		String sqll="select count(*) from sys_staff where staff_name like'%"+staff.getKey()+"%' and staff_visible='1'";
		page.setTotalCount(jdbcTemplate.queryForInt(sqll));
		String sql="select * from sys_staff where staff_name like'%"+staff.getKey()+"%' and staff_visible='1' limit ?,?";
		List <SysStaff>list = jdbcTemplate.query(sql, new RowMapper<SysStaff>(){
			public SysStaff mapRow(ResultSet rs,int i) throws SQLException{
				SysStaff staff1 = new SysStaff();
				staff1.setId(rs.getLong("Id"));
				staff1.setStaff_id(rs.getString("staff_id"));
				staff1.setStaff_name(rs.getString("staff_name"));
				staff1.setSex(rs.getString("Staff_sex"));
				staff1.setStatus(rs.getString("staff_status"));
				staff1.setSource(rs.getString("staff_source"));
				staff1.setReservation(rs.getString("staff_reservation"));
				staff1.setBuildDate(rs.getString("staff_buildDate"));
				staff1.setBuildMan(rs.getString("staff_buildMan"));
				staff1.setVisitDate(rs.getString("staff_visitDate"));
				staff1.setBirthday(rs.getString("staff_birthday"));
				staff1.setGraduateSchool(rs.getString("staff_graduateSchool"));
				staff1.setEducation(rs.getString("staff_education"));
				staff1.setContact(rs.getString("staff_contact"));
				staff1.setUrgencyName(rs.getString("staff_urgencyName"));
				staff1.setUrgencyPhone(rs.getString("staff_urgencyPhone"));
				staff1.setJobInterview(rs.getString("staff_jobInterview"));
				staff1.setVisible(rs.getString("staff_visible"));
				staff1.setUserId(rs.getString("user_id"));
				return staff1;
			}
		},page.getMinResult(),page.getMaxResult());
		page.setData(list);
		return page;
	}
	
	
	/* 
	 * 关键字查询黑名单数据
	 */
	@Override
	public PageNavigation<SysStaff> quhPageData(PageNavigation<SysStaff> page, SysStaff staff) {
		page.setTotalCount(jdbcTemplate.queryForInt("select count(*) from sys_staff where staff_name like"+"\"%"+staff.getKey()+"%"+"\" and staff_visible='0'"));
		String sql="select * from sys_staff where staff_name like'%"+staff.getKey()+"%' and staff_visible='0' limit ?,?";
		List <SysStaff>list = jdbcTemplate.query(sql, new RowMapper<SysStaff>(){
			public SysStaff mapRow(ResultSet rs,int i) throws SQLException{
				SysStaff staff1 = new SysStaff();
				staff1.setId(rs.getLong("Id"));
				staff1.setStaff_id(rs.getString("staff_id"));
				staff1.setStaff_name(rs.getString("staff_name"));
				staff1.setSex(rs.getString("Staff_sex"));
				staff1.setStatus(rs.getString("staff_status"));
				staff1.setSource(rs.getString("staff_source"));
				staff1.setReservation(rs.getString("staff_reservation"));
				staff1.setBuildDate(rs.getString("staff_buildDate"));
				staff1.setBuildMan(rs.getString("staff_buildMan"));
				staff1.setVisitDate(rs.getString("staff_visitDate"));
				staff1.setBirthday(rs.getString("staff_birthday"));
				staff1.setGraduateSchool(rs.getString("staff_graduateSchool"));
				staff1.setEducation(rs.getString("staff_education"));
				staff1.setContact(rs.getString("staff_contact"));
				staff1.setUrgencyName(rs.getString("staff_urgencyName"));
				staff1.setUrgencyPhone(rs.getString("staff_urgencyPhone"));
				staff1.setJobInterview(rs.getString("staff_jobInterview"));
				staff1.setVisible(rs.getString("staff_visible"));
				staff1.setUserId(rs.getString("user_id"));
				return staff1;
			}
		},page.getMinResult(),page.getMaxResult());
		page.setData(list);
		return page;
	}
	
	/* 
	 * 获取用户信息到模态框
	 */
	public SysStaff fine(SysStaff staff){
		
		String sql = "select * from sys_staff where id="+staff.getId();
			return jdbcTemplate.queryForObject(sql, new RowMapper<SysStaff>(){
			public SysStaff mapRow(ResultSet rs,int i) throws SQLException{
				SysStaff staff = new SysStaff();
				staff.setId(rs.getLong("id"));
				staff.setStaff_id(rs.getString("staff_id"));
				staff.setStaff_name(rs.getString("staff_name"));
				staff.setSex(rs.getString("Staff_sex"));
				staff.setStatus(rs.getString("staff_status"));
				staff.setSource(rs.getString("staff_source"));
				staff.setReservation(rs.getString("staff_reservation"));
				staff.setBuildDate(rs.getString("staff_buildDate"));
				staff.setBuildMan(rs.getString("staff_buildMan"));
				staff.setVisitDate(rs.getString("staff_visitDate"));
				staff.setBirthday(rs.getString("staff_birthday"));
				staff.setGraduateSchool(rs.getString("staff_graduateSchool"));
				staff.setEducation(rs.getString("staff_education"));
				staff.setContact(rs.getString("staff_contact"));
				staff.setUrgencyName(rs.getString("staff_urgencyName"));
				staff.setUrgencyPhone(rs.getString("staff_urgencyPhone"));
				staff.setJobInterview(rs.getString("staff_jobInterview"));
				staff.setVisible(rs.getString("staff_visible"));
				staff.setUserId(rs.getString("user_id"));
				return staff;
			}
			});
	}

}
