package com.mz.webnaplo.services;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.webnaplo.domains.Role;
import com.mz.webnaplo.domains.User;
import com.mz.webnaplo.interfaces.UserService;
import com.mz.webnaplo.repository.implementations.UserRepository;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(noRollbackFor={EmptyResultDataAccessException.class,NoResultException.class})
	public User findByEmail(String email) throws NoResultException 
	{
		User user = null;
		try {
			user = userRepository.findByCustomField("email", email);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return user;
	}

	@Transactional(noRollbackFor={EmptyResultDataAccessException.class,NoResultException.class})
	public User findByUsername(String username) throws NoResultException 
	{
		User user = null;
		try {
			user = userRepository.findByCustomField("username", username);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return user;
	}
	
	@Override
	public List<User> getAllUsers() 
	{
		return userRepository.findAll();
	}

	@Override
	public List<User> getAllActiveUsers() 
	{
		return userRepository.getAllActiveUsers();
	}

	@Override
	@Transactional
	public User registrateUser(User user) // throws ThisEntityIsExistException
	{
//		if(getUserByEmail(user.getEmail())!=null){
//			// throw new ThisEntityIsExistException("this.email.address.is.registered.yet");
//		}else{
//			org.springframework.security.crypto.password.PasswordEncoder encoder = new BCryptPasswordEncoder();
//			user.setPassword(encoder.encode(user.getPassword()));
//			// user.addRole("ROLE_USER");
//			user.setRegistrationDate(new Date());
//			// userRepository.create(user);
//		}
		return user;
	}

}
