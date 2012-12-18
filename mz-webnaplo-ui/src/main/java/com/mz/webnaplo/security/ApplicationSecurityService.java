package com.mz.webnaplo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.webnaplo.domains.Role;
import com.mz.webnaplo.interfaces.UserService;

@Service("applicationSecurityService")
@Transactional(readOnly = true)
public class ApplicationSecurityService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		com.mz.webnaplo.domains.User domainUser = userService.findByUsername(username);
		if( domainUser == null) {
			throw new UsernameNotFoundException("cant.find.any.user.with.address:"+username);
		}
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new User(
				domainUser.getUsername(),
				domainUser.getPassword(),
				enabled,
				accountNonExpired,
				credentialsNonExpired,
				accountNonLocked,
				getGrantedAuthorities(domainUser.getRoles())
				);
	}

	public Collection<? extends GrantedAuthority> getGrantedAuthorities(Set<Role> roles) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(0);
		for (Role role : roles) {
			authList.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authList;
	}
	
}
