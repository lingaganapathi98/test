package com.zoho.contact.test.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zoho.contact.test.model.UserModel;


@Repository
public interface UserJPARepo extends JpaRepository<UserModel, Long> {

	@Query("SELECT user_id FROM UserModel where username = :username and password = :password")
	public Long listUser(@Param("username") String username, 
			  @Param("password") String password);
}
