package com.finalpakage;

public class Entity {
	private int id;
	private String name;
	private String job;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Entity(int id, String name, String job, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.salary = salary;
	}
	public Entity( String name, String job, int salary) {
		super();
		
		this.name = name;
		this.job = job;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", job=" + job + ", salary=" + salary + "]";
	}
	
	
	
}
