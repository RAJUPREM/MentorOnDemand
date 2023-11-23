package com.mentorOnDemand.entity;

import jakarta.persistence.*;


@Entity
public class Person {
    public Person() {
		super();
	}
	public Person(int id, String personName, String password, String role) {
		super();
		this.id = id;
		this.personName = personName;
		this.password = password;
		this.role = role;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String personName;
    private String password;
    private String role;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", personName=" + personName + ", password=" + password + ", role=" + role + "]";
	}

}
