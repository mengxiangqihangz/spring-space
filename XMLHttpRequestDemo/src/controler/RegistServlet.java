package controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		req.setCharacterEncoding("GBK");
//		resp.setCharacterEncoding("text/html");
		
		PrintWriter out=resp.getWriter();	
		resp.setCharacterEncoding("UTF-8");
		String name = req.getParameter("userName");
		if(name.equalsIgnoreCase("admin")){
			out.print("true");							//输出信息
//			resp.getWriter().write("此用户名已注册！");
		}else{
			out.print("false");
		}
		out.close();
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

}
