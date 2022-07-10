package com.zoho.contact.test.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoho.contact.test.exceptionhandling.IdNotFoundException;
import com.zoho.contact.test.jparepository.ContactJPARepo;
import com.zoho.contact.test.jparepository.UserJPARepo;
import com.zoho.contact.test.model.ContactModel;
import com.zoho.contact.test.model.Contacts;
import com.zoho.contact.test.model.Credentials;
import com.zoho.contact.test.model.UserModel;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserJPARepo userjpa;
	@Autowired
	ContactJPARepo contactjpa;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public void createUser(UserModel user) {
		userjpa.save(user);
		logger.info("saved {}",user);
		
	}

	@Override
	public List<Contacts> listContactById(Long id) throws IdNotFoundException {
		List<Contacts> conts = new ArrayList<Contacts>();
		logger.info("listcontactby id {}",id);
		List<String> cont = contactjpa.listcontactById(id);
		for(String it:cont) {
			String[] value = it.split(",");
			Contacts ct = new Contacts();
			ct.setName(value[0]);
			ct.setEmail(value[2]);
			ct.setPhnum(value[1]);
			conts.add(ct);
		}
		logger.info("contacts {}",conts);
		return conts;
	}

	public Long listUser( Credentials user) {
		Long id = userjpa.listUser(user.getUsername(),user.getPassword());
		try {
		if(id != 0) {
			logger.info("userid {}",id);
			return id;
		}
		logger.info("userid no found {}",id);
		}catch(Exception e) {
			logger.error("{}",e);
		}
		return 0L;
	}

	@Override
	public void addcontact(ContactModel contact) {
		contactjpa.save(contact);
		logger.info("contact saved {}",contact);
	}

}
