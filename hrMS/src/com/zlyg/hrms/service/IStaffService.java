package com.zlyg.hrms.service;

import com.zlyg.hrms.common.PageNavigation;
import com.zlyg.hrms.model.sys.SysStaff;



public interface IStaffService {

	//分页获取数据
	public PageNavigation<SysStaff> getPageData(PageNavigation<SysStaff> page);
	
	//添加用户信息
	public String addStaff(SysStaff staff);
	
	//分页获取黑名单数据
	public PageNavigation<SysStaff> getBlackList(PageNavigation<SysStaff> page);
	
	//洗白黑名单的数据
	public String washWhite(SysStaff staff);
	
	//关键字查询白名单数据
	public PageNavigation<SysStaff> quPageData(PageNavigation<SysStaff> page,SysStaff staff);
	
	//关键字查询黑名单数据
	public PageNavigation<SysStaff> quhPageData(PageNavigation<SysStaff> page,SysStaff staff);
	
	//获取用户信息到模态框
	public SysStaff fine(SysStaff staff);
}
