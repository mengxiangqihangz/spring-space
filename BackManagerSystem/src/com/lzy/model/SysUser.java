package com.lzy.model;

import java.io.Serializable;
import java.util.Date;


/**
 * @author justin
 * 
 *         系统用户model类
 * @version 1.0
 * 
 */
public class SysUser {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6657285542494432242L;
	
	private Long id;
	private int userId;
	private String userName;
	private String sex;
	private int age;
	private String cardId;
	private String email;
	private String mobile;
	private String qq;
	private String status;
	private String userAccount;
	private String userPwd;
	private String createDate;
	private String remark;
	private String addr;

	public SysUser() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	

	public String getQq() {
		return qq;
	}

	public void setQq(String string) {
		this.qq = string;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String date) {
		this.createDate = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}
