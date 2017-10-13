package net.lampbrother.app;

public class Product {
	
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
	
	public String save(){
		System.out.println("Save: " + this); 
		return "success";
	}
}
