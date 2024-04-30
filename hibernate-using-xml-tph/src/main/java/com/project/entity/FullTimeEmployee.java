package com.project.entity;

public class FullTimeEmployee extends Employee {

	private float salary;
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
