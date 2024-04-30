package com.project.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ft_employee")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "e_id")),
	@AttributeOverride(name = "name", column = @Column(name="e_name"))
})
public class FullTimeEmployee extends Employee {

	@Column(name = "salary")
	private float salary;
	
	@Column(name = "bonus")
	private int bonus;

	public FullTimeEmployee() {
		super();
	}

	public FullTimeEmployee(Integer id, String name, float salary, int bonus) {
		super(id, name);
		this.salary = salary;
		this.bonus = bonus;
	}
	
	

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
