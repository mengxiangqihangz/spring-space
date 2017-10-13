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
	 * չʾStrutsPrepareAndExecuteFilter����������� ����ԭ��
	 */

	public void destroy() {}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//1. ��ȡ servletPath
		String servletPath = req.getServletPath();
		
		//2. ���� servletPath �Ƿ��� ".action" ��β
		//3. ���� .action ��β, ��
		if(servletPath.endsWith(".action")){
			
			String path = null;
			
			//3.1 ���� servletPath Ϊ /Product_input.action, 
			//��ת��ҳ�浽 /jsp/ProductForm.jsp
			if("/Product_input.action".equals(servletPath)){ //����൱��result �е�name="Product_input"
				path = "/jsp/ProductForm.jsp";  //����൱��<result>/jsp/ProductForm.jsp<\result>
			}
			//3.2 �� servletPath Ϊ /Product_save.action, 
			else if("/Product_save.action".equals(servletPath)){
				//��ȡ����Ϣ, �ѱ���Ϣ��װ�� Product ������
				Product product = new Product();
				product.setDescription(request.getParameter("description"));
				product.setPrice(request.getParameter("price"));
				product.setProductName(request.getParameter("productName"));
				
				//���� Prodcut �������ݿ���
				System.out.println("Save: " + product);  
				
				//�� Product ���󱣴浽 request ��, �Ҽ�Ϊ "product"
				request.setAttribute("product", product);
				
				//��ת��ҳ�浽 /jsp/ProductDetails.jsp
				path = "/jsp/ProductDetails.jsp";
			}
			
			request.getRequestDispatcher(path).forward(request, response);
		}
		//4. ������ .action ��β, ��������
		else{
			
			//�����û�ֱ�ӷ��� /images/lampbrother.png
			//�����û�������Ƿ�Ϊ "/images/lampbrother.png"
			//����, ����Ӧһ������ҳ��
			if("/images/lampbrother.png".equals(servletPath)){
				resp.sendError(resp.SC_FORBIDDEN);
			}else{
				chain.doFilter(request, response);	//���������ǽ�����ת����������������һ������--http://www.oschina.net/question/106215_13779?fromerr=ueqXvAW4
			}
			
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {}

}
