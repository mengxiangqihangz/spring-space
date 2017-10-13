package net.lampbrother.app;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterDispatcher implements Filter {
	/**
	 * 展示StrutsPrepareAndExecuteFilter这个过滤器的 处理原理
	 */

	public void destroy() {}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//1. 获取 servletPath
		String servletPath = req.getServletPath();
		
		//2. 检验 servletPath 是否以 ".action" 结尾
		//3. 若以 .action 结尾, 则
		if(servletPath.endsWith(".action")){
			
			String path = null;
			
			//3.1 检验 servletPath 为 /Product_input.action, 
			//则转发页面到 /jsp/ProductForm.jsp
			if("/Product_input.action".equals(servletPath)){ //这个相当于result 中的name="Product_input"
				path = "/jsp/ProductForm.jsp";  //这个相当于<result>/jsp/ProductForm.jsp<\result>
			}
			//3.2 若 servletPath 为 /Product_save.action, 
			else if("/Product_save.action".equals(servletPath)){
				//获取表单信息, 把表单信息封装到 Product 对象中
				Product product = new Product();
				product.setDescription(request.getParameter("description"));
				product.setPrice(request.getParameter("price"));
				product.setProductName(request.getParameter("productName"));
				
				//保存 Prodcut 对象到数据库中
				System.out.println("Save: " + product);  
				
				//把 Product 对象保存到 request 中, 且键为 "product"
				request.setAttribute("product", product);
				
				//则转发页面到 /jsp/ProductDetails.jsp
				path = "/jsp/ProductDetails.jsp";
			}
			
			request.getRequestDispatcher(path).forward(request, response);
		}
		//4. 若不以 .action 结尾, 正常放行
		else{
			
			//不让用户直接访问 /images/lampbrother.png
			//检验用户请求的是否为 "/images/lampbrother.png"
			//若是, 则响应一个错误页面
			if("/images/lampbrother.png".equals(servletPath)){
				resp.sendError(resp.SC_FORBIDDEN);
			}else{
				chain.doFilter(request, response);	//他的作用是将请求转发给过滤器链上下一个对象。--http://www.oschina.net/question/106215_13779?fromerr=ueqXvAW4
			}
			
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {}

}
