package com.zlyg.purchase.common;

import java.util.List;

public class PageNavigation<T> {
	
	private int DEFAULT_PAGE_SIZE = 5;
	
	// 当前页
	private int pageNo;

	// 每页显示的条数
	private int pageSize;

	// 总记录数
	private int totalCount;

	// 总页数
	private int totalPage;

	private int minResult;

	private int maxResult;

	private List<T> data;

	public PageNavigation() {

	}

	public PageNavigation(String pageNo, String pageSize) {
		if (pageNo != null) {
			this.pageNo = Integer.parseInt(pageNo);
		}else{
			this.pageNo = 1;
		}
		
		if (pageSize != null && !pageSize.equals("0")) {
			this.pageSize = Integer.parseInt(pageSize);
		}else{
			this.pageSize = DEFAULT_PAGE_SIZE;
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount % this.pageSize == 0) {
			this.totalPage = totalCount / this.pageSize;
		} else {
			this.totalPage = totalCount / this.pageSize + 1;
		}
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getMinResult() {
		return (this.pageNo - 1) * this.pageSize ;
	}

	public void setMinResult(int minResult) {
		this.minResult = minResult;
	}

	public int getMaxResult() {
//		this.maxResult = minResult + this.pageSize;
		this.maxResult = this.pageSize;
		return this.maxResult;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
