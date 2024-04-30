package com.project.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pt_employee")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "e_id")),
	@AttributeOverride(name = "name", column = @Column(name="e_name"))
})
public class PartTimeEmployee extends Employee {

	@Column(name = "pay_per_hour")
	private float pay_per_hour;
	
	@Column(name = "contract_duration")
	private String contract_duration;

	public PartTimeEmployee() {
		super();
	}

	public PartTimeEmployee(Integer id, String name, float pay_per_hour, String contract_duration) {
		super(id, name);
		this.pay_per_hour = pay_per_hour;
		this.contract_duration = contract_duration;
	}

	public float getPay_per_hour() {
		return pay_per_hour;
	}

	public void setPay_per_hour(float pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	public String getContract_duration() {
		return contract_duration;
	}

	public void setContract_duration(String contract_duration) {
		this.contract_duration = contract_duration;
	}

}
