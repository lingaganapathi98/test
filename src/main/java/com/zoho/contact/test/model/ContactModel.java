package com.zoho.contact.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.NonNull;

@Entity
@Table(name = "contact")
public class ContactModel {
	
	@Id
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 1, allocationSize = 100)
	@GeneratedValue(generator = "SeqGen")
	private Long id;
	private String name;
	private String phnum;
	private String email;
	@NonNull
	private Long user_id;
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public ContactModel() {
		
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

	public Long getUserModel() {
		return user_id;
	}

	public void setUserModel(Long userModel) {
		this.user_id = userModel;
	}
	public ContactModel(String name, String phnum, String email, Long user_id) {
		super();
		this.name = name;
		this.phnum = phnum;
		this.email = email;
		this.user_id = user_id;
	}
	
	

}
