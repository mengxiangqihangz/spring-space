package com.zlyg.hrms.controller.staff;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlyg.hrms.common.PageNavigation;
import com.zlyg.hrms.model.sys.SysStaff;
import com.zlyg.hrms.service.IStaffService;
import com.zlyg.hrms.utils.JsonUtils;

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
		model.addAttribute("page", pn); //page不可重复，保证此page的唯一性不要在页面，xml里面
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
			String key=new String(staff.getKey().getBytes("ISO-8859-1"),"utf-8");
			staff.setKey(key);
			model.addAttribute("key", key);
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
			String key=new String(staff.getKey().getBytes("ISO-8859-1"),"utf-8");
			staff.setKey(key);
			model.addAttribute("key",key);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		pn = staffService.quhPageData(pn,staff);
		model.addAttribute("page", pn);
		return "staff/blackList";
	}
	
	/**
	 * 通过id获取用户数据传到编辑模态框
	 * @param model
	 * @param id
	 * @returnException 
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
	
//	@RequestMapping("delete")
//	public void delete(SysStaff staff,HttpServletResponse rsponse){
//		try {
//			PrintWriter pw = rsponse.getWriter();
//			pw.write("1");
//			pw.flush();
//			pw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
