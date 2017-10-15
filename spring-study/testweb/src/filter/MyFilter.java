package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

	private FilterConfig config;
	private String ip;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器过滤请求");
		request.setCharacterEncoding("UTF-8");
//		if(ip.equals(request.getRemoteAddr())){
//			System.out.println("非法地址");
//			response.setCharacterEncoding("UTF-8");
//			PrintWriter pw = response.getWriter();
//			String msg = "请求地址为非法地址！";
//			pw.print(msg);
//		}else{
//			chain.doFilter(request, response);
//		}
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession sion = req.getSession();
		Object obj = sion.getAttribute("islogin");
		if(obj!=null){
			boolean flag = (Boolean)obj;
			if(flag){
				chain.doFilter(request, response);
			}else{
				request.getRequestDispatcher("login.html").forward(request, response);
			}
		}else{
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect("/testweb/login.html");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器初始化");
		this.config=arg0;
		this.ip=arg0.getInitParameter("ip");

	}

}
