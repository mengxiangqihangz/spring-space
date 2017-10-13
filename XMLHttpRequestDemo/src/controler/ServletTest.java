package controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfo;

import serveice.ILoginService;
import serveice.serviceimp.LoginServiceImp;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ServletTest extends HttpServlet {
	
	ILoginService loginService;
	
	//处理get请求
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		
			throws ServletException, IOException {
	}
	//处理post请求
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession sion = req.getSession();
		String name = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		if(name.equals("abc")&&pwd.equals("123")){
			req.getSession().setAttribute("islogin", true);
//			resp.getWriter().write("登录成功："+name);
			resp.getWriter().print(name);
//---------------------------------------print/write都可以将参数返回
		}else{
			resp.sendRedirect("login.jsp");
		}
//		UserInfo user = new UserInfo();
//		req.setAttribute("user", user);
//		UserInfo user = new UserInfo();
//		try {
//			loginService.validateLogin(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	//初始化方法
	public void init() throws ServletException {
		if(loginService==null){
			try {
				loginService = new LoginServiceImp();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("servlet初始化！");
		super.init();
	}
	//销毁方法
	public void destroy() {
		super.destroy();
	}
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}
	//处理客户端请求
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getMethod();
		if(methodName.equalsIgnoreCase("post")){
			this.doPost(request, response);
		}else if(methodName.equalsIgnoreCase("get")){
			this.doGet(request, response);
		}
	}

}
