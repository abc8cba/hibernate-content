package com.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity  
@Table(name="tbl_person500")  
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "person_id")
	private Integer personId;
	
	@Column(name = "person_name")
	private String name;
	
	@ManyToOne
	private Address address;

	public Person() {
		
	}

	public Person(Integer personId, String name) {
		this.personId = personId;
		this.name = name;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
