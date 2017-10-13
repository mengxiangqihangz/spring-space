package com.tgb.web.controller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_RECOMMEND")
public class Recommend {
	//Id
	@Id
	@GeneratedValue(generator = "system-uuid")  
    @GenericGenerator(name = "system-uuid", strategy = "uuid") 
 
    @Column(length=32)
	private String id;

	//用户名
	@Column(length=32)
	private String userName;
	
	//电影编号
	@Column(length=32)
	private String filmID;
	
	//推荐顺序
	@Column(length=8)
	private String filmOrder;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilmID() {
		return filmID;
	}

	public void setFilmID(String filmID) {
		this.filmID = filmID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFilmOrder() {
		return filmOrder;
	}

	public void setFilmOrder(String filmOrder) {
		this.filmOrder = filmOrder;
	}





	
	
}
