package com.tgb.web.controller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_FUR")
public class Fur {
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
	
	//电影图片url
	@Column(length=8)
	private String fuScore;

	//用户评价
	@Column(length=1024)
	private String fuReviews;

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

	public String getFuScore() {
		return fuScore;
	}

	public void setFuScore(String fuScore) {
		this.fuScore = fuScore;
	}

	public String getFuReviews() {
		return fuReviews;
	}

	public void setFuReviews(String fuReviews) {
		this.fuReviews = fuReviews;
	}


	
	
}
