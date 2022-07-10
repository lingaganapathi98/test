package com.zoho.contact.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoho.contact.test.exceptionhandling.IdNotFoundException;
import com.zoho.contact.test.model.ContactModel;
import com.zoho.contact.test.model.Contacts;
import com.zoho.contact.test.model.Credentials;
import com.zoho.contact.test.model.UserModel;
import com.zoho.contact.test.service.UserService;

@CrossOrigin("*")
@RestController
public class User {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/createuser")
	public void createUser(@RequestBody UserModel user) {
		userservice.createUser(user);
	}
	
	@GetMapping("/getcontacts")
	public List<Contacts> listcontact(HttpSession session) throws IdNotFoundException {
		try {
			@SuppressWarnings("unchecked")
			Long userid = (Long) session.getAttribute("SESSION_ID");
			List<Contacts> contact = userservice.listContactById(userid);
		return contact; 
		} catch (IdNotFoundException e) {
			throw new IdNotFoundException("Please enter valid ID.");
		}
	}
	
	@GetMapping("/getuserdetails/{un}/{pw}")
	public Credentials getuser(@PathVariable String un,@PathVariable String pw, HttpServletRequest request) {
		Credentials user = new Credentials();
		user.setUsername(un);
		user.setPassword(pw);
		@SuppressWarnings("unchecked")
		Long id = (Long) request.getSession().getAttribute("SESSION_ID");
		Long userid = userservice.listUser(user);
		if(userid != 0L) {
		request.getSession().setAttribute("SESSION_ID", userid);
		return user;
		}
		return null;
	}
	
	@PostMapping("/addcontact")
	public void addcontact(@RequestBody ContactModel contact, HttpSession session) {
		@SuppressWarnings("unchecked")
		Long userid = (Long) session.getAttribute("SESSION_ID");
		contact.setUser_id(userid);
		System.out.println(userid);
		userservice.addcontact(contact);
	}
	@PostMapping("/logout")
	public void destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		
	}

}
