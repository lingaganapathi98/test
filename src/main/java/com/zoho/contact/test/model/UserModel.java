package com.zoho.contact.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "user_details")
public class UserModel {
	
	@Id
	@SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 1, allocationSize = 100)
	@GeneratedValue(generator = "mySeqGen")
	private Long user_id=1L;
	private String username;
	private String password;
	private String code;
	
	public UserModel() {
		
	}
	
	public UserModel(String username, String password, String code) {
		super();
		this.username = username;
		this.password = password;
		this.code = code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}
