package com.potegd.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TestDept entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TEST_DEPT", schema = "CBA")
public class Department implements java.io.Serializable {
	// Fields
	private static final long serialVersionUID = 1L;
	private Long dno;
	private String dname;
	private Set<Employee> emps = new HashSet<Employee>(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(Long dno) {
		this.dno = dno;
	}

	/** full constructor */
	public Department(Long dno, String dname, Set<Employee> emps) {
		this.dno = dno;
		this.dname = dname;
		this.emps = emps;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "DNO", unique = true, nullable = false, precision = 10, scale = 0)
	public Long getDno() {
		return this.dno;
	}

	public void setDno(Long dno) {
		this.dno = dno;
	}

	@Column(name = "DNAME")
	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dept")
	public Set<Employee> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

}