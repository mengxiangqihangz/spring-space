package com.zlyg.purchase.model;

import java.util.List;


public class SysTree {
	
	private Long id;
	private String text;
	private String href;
	private boolean selectable;

	private State state;
	// 显示的标记格式一般是：['4']
	private String tags;
	private List<SysTree> nodes;
	
	public SysTree () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public List<SysTree> getNodes() {
		return nodes;
	}

	public void setNodes(List<SysTree> nodes) {
		this.nodes = nodes;
	}
}
