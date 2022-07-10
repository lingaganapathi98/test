package com.zoho.contact.test.model;

public class Contacts {
	private String name;
	private String phnum;
	private String email;

	public Contacts() {}
	public Contacts(String name, String phnum, String email) {
		super();
		this.name = name;
		this.phnum = phnum;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhnum() {
		return phnum;
	}
	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
