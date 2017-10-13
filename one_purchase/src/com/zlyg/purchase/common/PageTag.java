package com.zlyg.purchase.common;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private int pageNo;
	private int pageLast;
	private int pageSize;
	private String pageUrl;
	private String key;
	
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageLast() {
		return pageLast;
	}

	public void setPageLast(int pageLast) {
		this.pageLast = pageLast;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	
	
	/**
	 * 上一页
	 * @return
	 */
	public int prevPage() {
		if (this.pageNo == 1) {
			return this.pageNo;
		} else {
			return this.pageNo - 1;
		}
	}

	/**
	 * 下一页
	 * @return
	 */
	public int nextPage() {
		if (this.pageNo == this.pageLast) {
			return this.pageNo;
		} else {
			return this.pageNo + 1;
		}
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();

		StringBuffer sf = new StringBuffer();

		sf.append("<ul class='pagination pagination-lg' >");
		// sf.append("<li><a href='"+this.pageUrl+"?pageNo="+prevPage()+"&pageSize="+this.pageSize+"'>&laquo;</a></li>");
		sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo=" + prevPage()+ "&pageSize=" + this.pageSize + "'>上一页</a></li>");
		appendLi(sf);
		// sf.append("<li><a href='"+this.pageUrl+"?pageNo="+nextPage()+"&pageSize="+this.pageSize+"'>&raquo;</a></li>");
		sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo=" + nextPage()+ "&pageSize=" + this.pageSize + "'>下一页</a></li>");
		sf.append("</ul>");

		try {
			out.println(sf.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.SKIP_BODY;
	}

	private StringBuffer appendLi(StringBuffer sf) {
		// 每页显示5条，
		int endNo = this.getPageLast() - this.getPageNo();
		int p = this.getPageNo();

		// 前半部分分页，以第五页做分界线
		if (p <= 5) {
			for (int i = 1; i < p; i++) {
				sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo=" + i
						+ "&pageSize=" + this.pageSize + "'>" + i + "</a></li>");
			}
		} else {
			sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo=" + 1
					+ "&pageSize=" + this.pageSize + "'>" + 1 + "</a></li>");
			sf.append("<li><a href='#'>...</a></li>");
			sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo="
					+ (this.pageNo - 3) + "&pageSize=" + this.pageSize + "'>"
					+ (this.pageNo - 3) + "</a></li>");
			sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo="
					+ (this.pageNo - 2) + "&pageSize=" + this.pageSize + "'>"
					+ (this.pageNo - 2) + "</a></li>");
			sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo="
					+ (this.pageNo - 1) + "&pageSize=" + this.pageSize + "'>"
					+ (this.pageNo - 1) + "</a></li>");
		}

		// 当前页
		sf.append("<li><a style='background-color: #eee' href='" + this.pageUrl
				+ "?key=" + this.key+ "&pageNo=" + p + "&pageSize=" + this.pageSize + "'>" + p
				+ "</a></li>");

		// 后半部分分页，以小于等于最后3页做分界线
		if (endNo <= 3) {
			for (int i = this.getPageLast(); i > this.getPageNo(); i--) {
				p = p + 1;
				sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo=" + p
						+ "&pageSize=" + this.pageSize + "'>" + p + "</a></li>");
			}
		} else if (endNo > 3) {
			sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo=" + (p + 1)
					+ "&pageSize=" + this.pageSize + "'>" + (p + 1)
					+ "</a></li>");
			sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo=" + (p + 2)
					+ "&pageSize=" + this.pageSize + "'>" + (p + 2)
					+ "</a></li>");
			sf.append("<li><a href='#'>...</a></li>");
			sf.append("<li><a href='" + this.pageUrl + "?key=" + this.key+ "&pageNo="
					+ this.getPageLast() + "&pageSize=" + this.pageSize + "'>"
					+ this.getPageLast() + "</a></li>");
		}
		return sf;
	}

}
