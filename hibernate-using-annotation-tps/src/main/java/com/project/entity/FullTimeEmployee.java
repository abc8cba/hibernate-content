package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ft_emp")
@PrimaryKeyJoinColumn(name = "id")
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
