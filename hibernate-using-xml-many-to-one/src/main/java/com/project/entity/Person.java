package com.project.entity;

public class Person {

	private Integer personId;
	private String name;
	private Address address;

	public Person() {
		
	}

	public Person(Integer personId, String name, Address address) {
		super();
		this.personId = personId;
		this.name = name;
		this.address = address;
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

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", name=" + name + ", address=" + address + "]";
	}

}
