package com.zlyg.product.model;

public class Goods {
	private int gid;
	private String gname;
	private int gprice;
	private String ginformation;
	private int gremainNum;
	private String gpicture;
	private String sysemail;
	private String sysmobile;
	private String category;
	
	public String getSysemail() {
		return sysemail;
	}
	public void setSysemail(String sysemail) {
		this.sysemail = sysemail;
	}
	public String getSysmobile() {
		return sysmobile;
	}
	public void setSysmobile(String sysmobile) {
		this.sysmobile = sysmobile;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public String getGinformation() {
		return ginformation;
	}
	public void setGinformation(String ginformation) {
		this.ginformation = ginformation;
	}
	public int getGremainNum() {
		return gremainNum;
	}
	public void setGremainNum(int gremainNum) {
		this.gremainNum = gremainNum;
	}
	public String getGpicture() {
		return gpicture;
	}
	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}
}
