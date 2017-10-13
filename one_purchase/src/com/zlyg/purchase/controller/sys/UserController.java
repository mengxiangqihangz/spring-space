package com.zlyg.purchase.controller.sys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zlyg.purchase.common.PageNavigation;
import com.zlyg.purchase.model.sys.SysRole;
import com.zlyg.purchase.model.sys.SysUser;
import com.zlyg.purchase.service.sys.IUserService;
import com.zlyg.purchase.utils.JsonUtils;


@Controller
@RequestMapping("sys/user/")
public class UserController {
	@Autowired
	private IUserService userService;

	/**
	 * 查看用户列表
	 */
	@RequestMapping("list")
	public String list(Model model, SysUser user, String pageNo, String pageSize) {
		PageNavigation<SysUser> pn = new PageNavigation<>(pageNo, pageSize);
		pn = userService.getPageData(pn);
		model.addAttribute("page", pn);
		
		List<SysRole> ro = userService.getRole();
		model.addAttribute("post",ro);
		model.addAttribute("menu", "user");
		return "sys/list";
	}

	/**
	 * ������
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(SysUser user) {
		 System.out.println(user.getTel());
		int count = userService.addUser(user);
		if (count > 0) {
			
			System.out.println("添加成功");
			return "1";
		} else {
			return "0";
		}
	}

	/**
	 * 删除数据
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(SysUser user) {
		System.out.println("删除ID：" + user.getUserId());
		int falg = userService.delateUser(user);
		return String.valueOf(falg);
	}

	/**
	 * 修改用户
	 */
	@RequestMapping("edit")
	@ResponseBody
	public String edit(SysUser user) {
		int i = userService.editUser(user);
		if (i > 0) {
			System.out.println("更改成功");
			return "1";
		} else {
			return "0";
		}
	}
	/**
	 * 编辑用户时提取信息
	 */
	@RequestMapping("/get/{id}")
	@ResponseBody
	public void getUserById(Model model, @PathVariable Integer id,HttpServletResponse rs) {
		// PageNavigation<SysUser> pn = new PageNavigation<>();
		SysUser user = new SysUser();
		user = userService.findUserById(id);
		System.out.println("查询结果：" + id);
		String str = JsonUtils.objToJsonStr(user);
		rs.setCharacterEncoding("utf-8");
		PrintWriter pw;
		try {
			pw = rs.getWriter();
			pw.write(str);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 通过关键字搜索
	 */
	@RequestMapping("search")
	public String search(Model model,  String pageNo,
			String pageSize, SysUser user) throws Exception{
		String k =new String(user.getKey().getBytes("ISO-8859-1"),"utf-8");
		user.setKey(k);
		model.addAttribute("key", k);
		PageNavigation<SysUser> pn = new PageNavigation<>(pageNo, pageSize);
		pn = userService.getSearchData(pn, user.getKey());
		model.addAttribute("page", pn);
		
		List<SysRole> ro = userService.getRole();
		model.addAttribute("post",ro);
		return "sys/list";
	}
	/**
	 * 查询被删用户信息
	 */
	@RequestMapping("searchDelUser")
	public String getDel(Model model,  String pageNo,
			String pageSize, String key) {
		PageNavigation<SysUser> pn = new PageNavigation<>(pageNo, pageSize);
		pn = userService.getDelData(pn);
		model.addAttribute("page", pn);
		List<SysRole> ro = userService.getRole();
		model.addAttribute("post",ro);
		return "sys/list";
	}
	/**
	 * 恢复数据
	 */
	
	@RequestMapping("recover")
	@ResponseBody
	public String recover(SysUser user) {
		System.out.println("恢复ID：" + user.getUserId());
		int falg = userService.recover(user);
		return String.valueOf(falg);
	}
	/**
	 * 跳转JSP
	 * 
	 * @param jspName
	 * @return
	 */
	@RequestMapping("/jsp/{jspName}")
	public String toJsp(@PathVariable String jspName) {
		System.out.println("JSP TO -->>" + jspName);
		return jspName;
	}
}
