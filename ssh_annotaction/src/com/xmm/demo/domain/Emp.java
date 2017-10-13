package com.xmm.demo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 雇员
 */
@Entity
@Table(name = "emp")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE) 
public class Emp implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "empno", length = 4)
	private Integer empno; // 雇员编号
	
	@Column(name = "ename", length = 10)
	private String ename; // 雇员姓名
	
	@Column(name = "job")
	private String job; // 工作
	
	@Column(name = "mgr")
	private Integer mgr; // 上级雇员的编号
	
	@Column(name = "hiredate", columnDefinition = "DATE")
	private Date hiredate; // 入职日期
	
	@Column(name = "sal")
	private Double sal; // 薪水
	
	@Column(name = "comm")
	private Double comm; // 奖金
	
	@Column(name = "deptno")
	private Integer deptno; // 部门编号

	public Emp() {
	}

	public Emp(Integer empno, String ename, Date hiredate, Double sal) {
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job
				+ ", mgr=" + mgr + ", hiredate=" + hiredate + ", sal=" + sal
				+ ", comm=" + comm + ", deptno=" + deptno + "]";
	}

}
