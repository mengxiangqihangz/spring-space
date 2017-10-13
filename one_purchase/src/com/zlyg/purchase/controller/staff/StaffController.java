package com.zlyg.purchase.controller.staff;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.tracing.dtrace.Attributes;
import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysStaff;
import com.zlyg.purchase.service.sys.IStaffService;
import com.zlyg.purchase.utils.JsonUtils;


@Controller
@RequestMapping("sys/staff/")
public class StaffController {
	@Autowired
	private IStaffService staffService;
	
	/**
	 * 
	 * 分页获取白名单数据
	 * @return
	 */
	@RequestMapping("list")
	public String list (Model model,SysStaff staff,String pageNo,String pageSize) {
		
		PageNavigation<SysStaff> pn = new PageNavigation<>(pageNo,pageSize);
		pn = staffService.getPageData(pn);
		model.addAttribute("page", pn);
		model.addAttribute("menu","jobs");

		return "staff/staffList";
	}
	
	/**
	 * 添加员工信息
	 * @param rsponse
	 * @param user
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add (HttpServletResponse rsponse,SysStaff staff) {
		System.out.println("-----添加员工信息------");
		String falg = staffService.addStaff(staff);		
		
		return falg;
	}
	
	/**
	 * 
	 * 分页获取黑名单数据
	 * @return
	 */
	@RequestMapping("blackList")
	public String blackList (Model model,SysStaff staff,String pageNo,String pageSize) {
		
		PageNavigation<SysStaff> pn = new PageNavigation<>(pageNo,pageSize);
		pn = staffService.getBlackList(pn);
		model.addAttribute("page", pn);
		model.addAttribute("menu","blacklist");
		return "staff/blackList";
	}
	
	/**
	 * 洗白黑名单的数据
	 * @return
	 */
	@RequestMapping("washWhite")
	public void washWhite(HttpServletResponse rsponse,SysStaff staff){
		String falg = staffService.washWhite(staff);
		try {
			PrintWriter pw = rsponse.getWriter();
			pw.write(falg);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过关键字查询白名单数据
	 * @return
	 */
	@RequestMapping("quda")
	public String queryda(Model model,SysStaff staff,String pageNo,String pageSize){
		PageNavigation<SysStaff> pn = new PageNavigation<>(pageNo,pageSize);
		try {
			String ss=new String(staff.getKey().getBytes("ISO-8859-1"),"utf-8");
			staff.setKey(ss);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		pn = staffService.quPageData(pn,staff);
		model.addAttribute("page", pn);
		return "staff/staffList";
	}
	
	/**
	 * 通过关键字查询黑名单数据
	 * @return
	 */
	@RequestMapping("quhda")
	public String queryhda(Model model,SysStaff staff,String pageNo,String pageSize){
		PageNavigation<SysStaff> pn = new PageNavigation<>(pageNo,pageSize);
		try {
			String ss=new String(staff.getKey().getBytes("ISO-8859-1"),"utf-8");
			staff.setKey(ss);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		pn = staffService.quhPageData(pn,staff);
		model.addAttribute("page", pn);
		return "staff/blackList";
	}
	@RequestMapping("exit")
	public String exit(){
		
		return "redirect:/login.jsp";
	}
	

	/**
	 * 编辑面试人员信息
	 * @author lizhuhui 
	 */
	@RequestMapping("edit")
	@ResponseBody
	public String edit(SysStaff staff){
		System.out.println("编辑用户信息");
		int count = staffService.StaffEdit(staff);
		if (count>0) {
			System.out.println("编辑成功");
			return "1";
		}
		return "0";
	}
	
	/**
	 * 根据ID查询
	 * @author lizhuhui
	 */
	@RequestMapping("get/{id}")
	@ResponseBody
	public void getUserById(@PathVariable Long id,HttpServletResponse rsponse) {
		System.out.println("查询结果：" + id);
		SysStaff u = new SysStaff();
		u.setId(id);
		u=staffService.fine(u);
		String str = JsonUtils.objToJsonStr(u);
		try {
			rsponse.setCharacterEncoding("UTF-8");
			PrintWriter pw = rsponse.getWriter();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 拉黑面试个人信息
	 * @return
	 */
	@RequestMapping("delete")
	public void blacklist(String id,HttpServletResponse rsponse){
		System.out.println(id);
		
		try {
			String flag = staffService.blackList(id);
			rsponse.setCharacterEncoding("UTF-8");
			PrintWriter pw = rsponse.getWriter();
			pw.write(flag);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public int getId(){
		return staffService.getId();
	}

}
