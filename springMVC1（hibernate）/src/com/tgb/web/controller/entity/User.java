package com.tgb.web.controller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_USER")
public class User {
	//唯一的id
	@Id
	@GeneratedValue(generator = "system-uuid")  
    @GenericGenerator(name = "system-uuid", strategy = "uuid") 
    @Column(length=32)
	private String id;
	
	//用户名
	@Column(length=32)
	private String userName;
	
	//密码	
	@Column(length=32)
	private String password;
	
	//昵称
	@Column(length=32)
	private String nickName;
	
	//性别
	@Column(length=4)
	private String gender;
	
	
	//年龄
	@Column(length=32)
	private String age;
	
	
	//登录时间
	@Column(length=32)
	private String logtime;	
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
