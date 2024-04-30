package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_emp")
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
	private Integer id;

	@Column(name = "ename", nullable = false, length = 40)
	private String name;

	@Column(name = "city", length = 40)
	private String city;

	public Emp() {

	}

	public Emp(Integer id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Emp(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

}
