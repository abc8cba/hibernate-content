package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_dummy_employee")
public class DummyEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private Integer id;

	@Column(name = "s_name", length = 50, nullable = false)
	private String name;

	@Column(name = "s_city", length = 50)
	private String city;

	public DummyEmployee() {
		
	}

	public DummyEmployee(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public DummyEmployee(Integer id, String name, String city) {
		this.id = id;
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
		return "Employee [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

}
