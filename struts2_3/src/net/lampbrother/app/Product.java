package net.lampbrother.app;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 流程：先调用构造器创建对象--在调用set方法，将表中的数据进行封装。之后再调用save的方法。到this调用toString的方法
 * 
 */
public class Product extends ActionSupport{
	
	private String productName;
	private String description;
	private String price;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", description="
				+ description + ", price=" + price + "]";
	}
	
	/**
	 * Struts2 框架调用的 action 方法的要求:
	 * 
	 * 1. public 修饰符
	 * 2. String 返回值
	 * 3. 方法不带任何参数
	 * 
	 */
	public String save(){
		System.out.println("Save: " + this); 
		return SUCCESS;
	}
	
	@Override
	public String input() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("input,input,input,input,input,input");
		return INPUT;
	}
	
	
	
	public Product() {
		// TODO Auto-generated constructor stub
		System.out.println("Product...");  
	}
	
}
