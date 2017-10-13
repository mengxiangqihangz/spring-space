package com.zlyg.purchase.model.sys;

/**
 * @author kim 
 * 用户实体类
 */
public class SysUser {
	private String key;
	private Integer userId;
	private String userName;
	private Integer age;
	private Integer sex;
	private String cardId;
	private String email;
	private String mobile;
	private String tel;
	private Integer status;
	private String postName;
	private Integer postId;
	private String account;
	private String pwd;
	private Integer visitable;

	public SysUser() {

	}
	

	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getVisitable() {
		return visitable;
	}

	public void setVisitable(Integer visitable) {
		this.visitable = visitable;
	}

}
