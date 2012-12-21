package com.mz.webnaplo.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
public class SocialConfig {

	@Value("${facebook.clientId}")
	private String clientId;

	@Value("${facebook.clientSecret}")
	private String clientSecret;

	@Inject
	private DataSource dataSource;

	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator() 
	{
		ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
		registry.addConnectionFactory(getFacebookConnectionFactory());
		return registry;
	}

	private FacebookConnectionFactory getFacebookConnectionFactory() 
	{
		return new FacebookConnectionFactory(clientId, clientSecret);
	}

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
	public ConnectionRepository connectionRepository() 
	{
		/*
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
		}
		*/
		// XXX authentication.getName()
		ConnectionRepository connRep = usersConnectionRepository().createConnectionRepository("pista");
		return connRep;
		// XXX todo
	}

	@Bean
	public UsersConnectionRepository usersConnectionRepository() {
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), textEncryptor());
		// repository.setConnectionSignUp(new SimpleConnectionSignUp());
		return repository;
	}

	@Bean
	public TextEncryptor textEncryptor() {
		return Encryptors.noOpText();
	}

	/*
	@Bean
	public ConnectController connectController() 
	{
		ConnectionRepository x = connectionRepository();
		ConnectController conn = new ConnectController(connectionFactoryLocator(), x);
		return conn;
	}
	*/

	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)	
	public Facebook facebook() {
	    return connectionRepository().getPrimaryConnection(Facebook.class).getApi();
	}

}
