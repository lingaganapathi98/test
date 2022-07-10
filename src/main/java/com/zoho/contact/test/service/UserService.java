package com.zoho.contact.test.service;

import java.util.List;

import com.zoho.contact.test.exceptionhandling.IdNotFoundException;
import com.zoho.contact.test.model.ContactModel;
import com.zoho.contact.test.model.Contacts;
import com.zoho.contact.test.model.Credentials;
import com.zoho.contact.test.model.UserModel;


public interface UserService {
	
	public void createUser(UserModel user);
	//public List<ContactModel> listContactById(Long id) throws IdNotFoundException;
	public Long listUser( Credentials user);
	public List<Contacts> listContactById(Long id) throws IdNotFoundException;
	public void addcontact(ContactModel contact);

}
