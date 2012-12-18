package com.mz.webnaplo.repository.implementations;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mz.webnaplo.domains.User;
import com.mz.webnaplo.repository.base.AbstractGenericDao;

@Component
public class UserRepository extends AbstractGenericDao<User>{

	 public UserRepository() {
		 super(User.class);
	 }
	 
	 public List<User> getAllActiveUsers() {
		 return super.runCustomQuery(entityManager.createQuery("SELECT u FROM User u WHERE u.enabled='1'", User.class));
	 }
}
