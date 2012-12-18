package com.mz.webnaplo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class SocialConfig {
	
	@Autowired 
    private Environment env;
	
    @Autowired
    private DataSource dataSource;
    
    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() 
    {
    	// We have declared a ConnectionFactoryLocator which allows us to register connections to Facebook and Twitter. Notice how we passed the OAuth secret IDs and secret keys to the locator
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory("224886380976924","cbf8d7fd4c1fd8a06c863ef7abf7108c"
//        		env.getRequiredProperty("facebook.clientId"),
//        		env.getRequiredProperty("facebook.clientSecret")
      	));
 
        /*
        registry.addConnectionFactory(new TwitterConnectionFactory(
        		env.getRequiredProperty("twitter.consumerKey"),
        		env.getRequiredProperty("twitter.consumerSecret")));
        		*/
        return registry;
    }	
    
    @Bean
    public TextEncryptor textEncryptor() 
    {
        return Encryptors.noOpText();
    }
 
    @Bean
    public UsersConnectionRepository usersConnectionRepository() 
    {
		return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), textEncryptor());
    }
    
    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public ConnectionRepository connectionRepository() 
    {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
		}
		return usersConnectionRepository().createConnectionRepository(authentication.getName());
	}
 
    @Bean
    public ConnectController connectController() 
    {
    	// ConnectController is a controller for managing the connection flow to social media sites
    	ConnectController controller = new ConnectController(connectionFactoryLocator(), connectionRepository());
        // XXX controller.setApplicationUrl(env.getRequiredProperty("application.url"));
    	controller.setApplicationUrl("http://localhost:8080/mz-webnaplo-ui");
        return controller;
    }
    
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() 
    {
    	// HiddenHttpMethodFilter is required by Spring Social so that users can disconnect from social media sites. The filter needs to be declared in the web.xml or ApplicationInitializer
    	HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
    	return filter;
    }
    
}
