package com.zlyg.purchase.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.dao.sys.IStaffDao;
import com.zlyg.purchase.model.sys.SysStaff;
import com.zlyg.purchase.service.sys.IStaffService;



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
	
	/**
	 * 编辑用户
	 * @author lizhuhui
	 */
	@Override
	public int StaffEdit(SysStaff staff) {
		try {
			staffDao.StaffEdit(staff);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 根据ID查找员工
	 * @author lizhuhui 
	 */
	@Override
	public SysStaff fine(SysStaff staff) {
		return staffDao.fine(staff);
	}
	
	@Override
	public String blackList(String id) {
		return staffDao.blackList(id);
	}

	@Override
	public int getId() {
		
		return staffDao.getId();
	}

}
