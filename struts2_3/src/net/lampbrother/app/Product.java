package net.lampbrother.app;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ���̣��ȵ��ù�������������--�ڵ���set�����������е����ݽ��з�װ��֮���ٵ���save�ķ�������this����toString�ķ���
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
	 * Struts2 ��ܵ��õ� action ������Ҫ��:
	 * 
	 * 1. public ���η�
	 * 2. String ����ֵ
	 * 3. ���������κβ���
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
