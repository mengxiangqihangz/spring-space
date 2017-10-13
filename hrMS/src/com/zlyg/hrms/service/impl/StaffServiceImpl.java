package com.zlyg.hrms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlyg.hrms.common.PageNavigation;
import com.zlyg.hrms.dao.IStaffDao;
import com.zlyg.hrms.model.sys.SysStaff;
import com.zlyg.hrms.service.IStaffService;


@Service
public class StaffServiceImpl implements IStaffService{

	@Autowired
	private IStaffDao staffDao;
	
	@Override
	public PageNavigation<SysStaff> getPageData(PageNavigation<SysStaff> page) {
		return staffDao.getPageData(page);
	}

	@Override
	public String addStaff(SysStaff staff) {
		return staffDao.addStaff(staff);
	}

	@Override
	public PageNavigation<SysStaff> getBlackList(PageNavigation<SysStaff> page) {
		return staffDao.getBlackList(page);
	}

	@Override
	public String washWhite(SysStaff staff) {
		return staffDao.washWhite(staff);
	}

	@Override
	public PageNavigation<SysStaff> quPageData(PageNavigation<SysStaff> page, SysStaff staff) {
		return staffDao.quPageData(page,staff);
	}

	@Override
	public PageNavigation<SysStaff> quhPageData(PageNavigation<SysStaff> page,
			SysStaff staff) {
		return staffDao.quhPageData(page, staff);
	}

	@Override
	public SysStaff fine(SysStaff staff) {
		return staffDao.fine(staff);
	}

}
