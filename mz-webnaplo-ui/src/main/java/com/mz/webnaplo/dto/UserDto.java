package com.mz.webnaplo.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.mz.webnaplo.domains.Role;
import com.mz.webnaplo.domains.SystemSettings;
import com.mz.webnaplo.domains.User;

public class UserDto {

	private long id;
	private String email;
	private String username;
	private String password;
	private String repassword;
	private Set<Role> roles = new HashSet<Role>(1);
	private Integer enabled = User.USER_ENABLED;
	private Integer activated = User.USER_NOTACTIVATED;
	private Integer registrationType = User.REGISTRATION_FULL;
	private Date lastLogin;
	private SystemSettings systemSettings;

	

}
