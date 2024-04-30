package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address102")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	private String countryName;
	private String stateName;
	private String cityName;
	private String pincode;
	private String landmark;

	@OneToOne
	private Person person;

	public Address() {

	}

	public Address(Integer addressId, String countryName, String stateName, String cityName, String pincode,
			String landmark, Person person) {
		this.addressId = addressId;
		this.countryName = countryName;
		this.stateName = stateName;
		this.cityName = cityName;
		this.pincode = pincode;
		this.landmark = landmark;
		this.person = person;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", countryName=" + countryName + ", stateName=" + stateName
				+ ", cityName=" + cityName + ", pincode=" + pincode + ", landmark=" + landmark + ", person=" + person
				+ "]";
	}

}
