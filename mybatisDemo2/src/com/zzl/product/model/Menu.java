package com.zzl.product.model;

public class Menu {
	private int id;
	private int parentId;
	private String name;
	private String url;
	private int siShowLeft;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSiShowLeft() {
		return siShowLeft;
	}
	public void setSiShowLeft(int siShowLeft) {
		this.siShowLeft = siShowLeft;
	}
	
}
