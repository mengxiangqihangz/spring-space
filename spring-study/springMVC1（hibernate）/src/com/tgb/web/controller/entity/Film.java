package com.tgb.web.controller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_FILM")
public class Film {
	//Id
	@Id
	@GeneratedValue(generator = "system-uuid")  
    @GenericGenerator(name = "system-uuid", strategy = "uuid") 
 
    @Column(length=32)
	private String id;

	//电影编号
	@Column(length=32)
	private String filmID;
	
	//电影名字
	@Column(length=32)
	private String filmName;
	
	//电影图片url
	@Column(length=32)
	private String filmURL;
	
	//电影图片url1
	@Column(length=32)
	private String filmURL1;

	//电影价格
	@Column(length=8)
	private String filmPrice;
	
	//电影排名
	@Column(length=8)
	private String filmRank;
	
	//电影得分
	@Column(length=8)
	private String filmScore;
	
	//剧情
	@Column(length=1024)
	private String filmSynopsis;

	//编辑评价
	@Column(length=1024)
	private String filmReviews;

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

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmURL() {
		return filmURL;
	}

	public void setFilmURL(String filmURL) {
		this.filmURL = filmURL;
	}

	public String getFilmPrice() {
		return filmPrice;
	}

	public void setFilmPrice(String filmPrice) {
		this.filmPrice = filmPrice;
	}

	public String getFilmScore() {
		return filmScore;
	}

	public void setFilmScore(String filmScore) {
		this.filmScore = filmScore;
	}

	public String getFilmSynopsis() {
		return filmSynopsis;
	}

	public void setFilmSynopsis(String filmSynopsis) {
		this.filmSynopsis = filmSynopsis;
	}

	public String getFilmReviews() {
		return filmReviews;
	}

	public void setFilmReviews(String filmReviews) {
		this.filmReviews = filmReviews;
	}

	public String getFilmRank() {
		return filmRank;
	}

	public void setFilmRank(String filmRank) {
		this.filmRank = filmRank;
	}

	public String getFilmURL1() {
		return filmURL1;
	}

	public void setFilmURL1(String filmURL1) {
		this.filmURL1 = filmURL1;
	}
	
	
	
}
