package com.zoho.contact.test.jparepository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zoho.contact.test.model.ContactModel;
import com.zoho.contact.test.model.Contacts;

@Repository
public interface ContactJPARepo extends JpaRepository<ContactModel, Long>{
	
	@Query(value = "SELECT c.name,c.phnum,c.email FROM contact c where user_id = :user_id ",nativeQuery=true)
	public List<String> listcontactById(@Param("user_id")Long id);

}
