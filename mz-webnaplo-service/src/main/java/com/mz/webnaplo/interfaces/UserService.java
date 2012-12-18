package com.mz.webnaplo.interfaces;

import java.util.List;

import com.mz.webnaplo.domains.User;

public interface UserService {

	User findByEmail(String email);
	User findByUsername(String username);

	List<User> getAllUsers();
	List<User> getAllActiveUsers();

	User registrateUser(User user);
	
}
