package com.potegd.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TEST_EMP", schema = "CBA")
public class Employee implements java.io.Serializable {
	// Fields
	private static final long serialVersionUID = 1L;
	private Long eno;
	private Department dept;
	private String ename;
	private String sex;
	private Short age;
	private Timestamp hiredate;

	/** default constructor */
	public Employee() {
	}

	/** full constructor */
	public Employee(String ename, String sex, Short age,
			Timestamp hiredate,Department dept) {
		this.dept = dept;
		this.ename = ename;
		this.sex = sex;
		this.age = age;
		this.hiredate = hiredate;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ENO", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getEno() {
		return this.eno;
	}

	public void setEno(Long eno) {
		this.eno = eno;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DNO", nullable = false)
	public Department getDept() {
		return this.dept;
	}

	public void setDept(Department Dept) {
		this.dept = Dept;
	}

	@Column(name = "ENAME", nullable = false)
	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "SEX", nullable = false, length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "AGE", nullable = false, precision = 3, scale = 0)
	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	@Column(name = "HIREDATE", nullable = false, length = 7)
	public Timestamp getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}

}