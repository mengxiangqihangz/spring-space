package com.tgb.web.controller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(generator = "system-uuid")  
    @GenericGenerator(name = "system-uuid", strategy = "uuid") 
    
    @Column(length=32)
	private String id;
	
	@Column(length=32)
	private String proID;
	
	@Column(length=32)
	private String proName;
	
	@Column(length=32)
	private String proNo;

	@Column(length=1024)
	private String proEstimate;

	@Column(length=1024)
	private String proO;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo = proNo;
	}

	public String getProEstimate() {
		return proEstimate;
	}

	public void setProEstimate(String proEstimate) {
		this.proEstimate = proEstimate;
	}

	public String getProO() {
		return proO;
	}

	public void setProO(String proO) {
		this.proO = proO;
	}
	
}
