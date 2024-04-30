package com.project.entity;

public class Regular_Employee extends Employee {

	private float salary;
	private int bonus;

	public Regular_Employee() {
		super();
	}

	public Regular_Employee(Integer id, String name, float salary, int bonus) {
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
