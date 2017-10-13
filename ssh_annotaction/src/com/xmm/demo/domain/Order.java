package com.xmm.demo.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 订单
 */
@Entity
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;	

	@Id				//主键
	@Column(name = "id")
	private Integer id; // id
	
	@Column(name = "orderNumber")
	private String orderNumber; // 订单号
	
//	@Column(name = "customer_id")
//	private String customerid;
	
	@ManyToOne
	@JoinTable(name="customer_id")  		//
	private Customer customer; // 所属客户

	public Order() {
	}

//	public String getCustomerid() {
//		return customerid;
//	}
//
//	public void setCustomerid(String customerid) {
//		this.customerid = customerid;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + "]";
	}

}
