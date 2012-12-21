package com.mz.webnaplo.ui.listener;

import java.util.Date;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mz.webnaplo.domains.Address;
import com.mz.webnaplo.domains.Gallery;
import com.mz.webnaplo.domains.Picture;
import com.mz.webnaplo.domains.Role;
import com.mz.webnaplo.domains.SystemSettings;
import com.mz.webnaplo.domains.User;
import com.mz.webnaplo.enums.Gender;

public class ApplicationStartupListener implements ServletContextListener {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) 
	{
		ServletContext ctx = sce.getServletContext();
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);
		entityManagerFactory = (EntityManagerFactory) springContext.getBean("entityManagerFactory");
		entityManager = entityManagerFactory.createEntityManager();
		
		createTestUsers();
		
//		Gallery g = findGalleryById(1L);
//		deleteGallery(g);
		
//		Address address = findAddressById(1L);
//		System.out.println("##### find addr to remove : "+address);
//		deleteAddress(address);
		
//		Role role = findRoleByName("ROLE_MANAGER");
//		System.out.println("##### find role to remove : "+role);
//		deleteRole(role);
//		role = findRoleByName("ROLE_USER");
//		System.out.println("##### find role to remove : "+role);
//		deleteRole(role);
//		role = findRoleByName("ROLE_ADMIN");
//		System.out.println("##### find role to remove : "+role);
//		deleteRole(role);

		User user = findUserByName("pista");
//		deleteUser(user);
//		user = findUserByName("jolan");
		//deleteUser(user);
		
	}

	private void deleteGallery(Gallery g) 
	{
		entityManager.getTransaction().begin();
		//entityManager.createQuery("delete from Gallery a where a.id='"+g.getId()+"'").executeUpdate();
		entityManager.remove(g);
		System.out.println("###### gallery removed... ");
		entityManager.getTransaction().commit();
	}

	private Gallery findGalleryById(long id) {
		Gallery g = (Gallery) entityManager.createQuery("Select o from Gallery o where o.id='"+id+"'").getSingleResult();
		System.out.println("###### find Gallery... "+g);
		return g;
	}

	private void deleteRole(Role role) 
	{
		entityManager.getTransaction().begin();
		entityManager.remove(role);
		System.out.println("###### role removed... ");
		entityManager.getTransaction().commit();
	}
	
	private Role findRoleByName(String name) {
		Role role = (Role) entityManager.createQuery("Select o from Role o where o.name='"+name+"'").getSingleResult();
		System.out.println("###### find role... "+role);
		return role;
	}

	private void deleteAddress(Address address) 
	{
		entityManager.getTransaction().begin();
		//entityManager.remove(address);
		entityManager.createQuery("delete from Address a where a.id='"+address.getId()+"'").executeUpdate();
		System.out.println("###### Address removed... ");
		entityManager.getTransaction().commit();
	}
	
	private Address findAddressById(Long id) {
		Address address = (Address) entityManager.createQuery("Select o from Address o where o.id='"+id+"'").getSingleResult();
		System.out.println("###### find address... "+address);
		return address;
	}
	
	private void deleteUser(User user) 
	{
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		System.out.println("###### user removed... ");
		entityManager.getTransaction().commit();
	}

	private User findUserByName(String name) {
		User user = (User) entityManager.createQuery("Select u from User u where u.username='"+name+"'").getSingleResult();
		System.out.println("###### find user... "+user);
		return user;
	}

	private void createTestUsers() 
	{
		Role role_admin = createRole("ROLE_ADMIN");
		Role role_user = createRole("ROLE_USER");
		Role role_manager = createRole("ROLE_MANAGER");
		Address address = createAddress("city", "zip", "street");
		Address address2 = createAddress("city2", "zip2", "street2");
		Address address3 = createAddress("city25", "zip25", "jolan street2");
		User user = createTestUser("pista", "pista@email.com", role_admin, role_user, role_manager, address, address2);
		User user2 = createTestUser("jolan", "jolan@email.com", role_user, role_manager, null, address3, null);
		
		SystemSettings sys1 = new SystemSettings();
		sys1.setLocale(Locale.ENGLISH);
		sys1.setUser(user);
		user.setFacebookClientId("224886380976924");
		user.setFacebookClientSecret("cbf8d7fd4c1fd8a06c863ef7abf7108c");
		user.setSystemSettings(sys1);
		
		Gallery gal1 = new Gallery();
		gal1.setCreationDate(new Date());
		gal1.setName("galeria 1");
		user.addGallery(gal1);

		Gallery gal2 = new Gallery();
		gal2.setCreationDate(new Date());
		gal2.setName("galeria 2");
		user.addGallery(gal2);
		
		Picture pic1 = new Picture();
		pic1.setContentType("contentType");
		pic1.setCreationDate(new Date());
		pic1.setName("regi fenykep");
		gal1.addPicture(pic1);
		
		persistUser(user);
		persistUser(user2);
	}
	
	private void persistUser(User user) 
	{
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		System.out.println("###### user persisted... ");
		entityManager.getTransaction().commit();
	}

	private Role createRole(String name) 
	{
		Role role = new Role();
		role.setName(name);
		return role;
	}

	private Address createAddress(String city, String zip, String street) 
	{
		Address address = new Address();
		address.setCity(city);
		address.setZip(zip);
		address.setStreet(street);
		return address;
	}

	private User createTestUser(String username, String email, Role role, Role role2, Role role3, Address address, Address address2) 
	{
		User user = new User();
		user.setUsername(username);
		user.setPassword(username);
		user.setEmail(email);
		user.setActivated(true);
		user.setEnabled(true);
		user.setRegistrationTypeFull(true);
		user.setBirthdate(new Date(323744523));
		user.setDescription("description");
		user.setRegistrationDate(new Date());
		user.setPhone("phone");
		user.setGender(Gender.MALE);
		user.addAddress(address);
		address.setUser(user);
		if (address2 != null) {
			user.addAddress(address2);
			address2.setUser(user);
		}
		user.addRole(role);
		role.addUser(user);
		if (role2 != null) {
			user.addRole(role2);
			role2.addUser(user);
		}
		if (role3 != null) {
			user.addRole(role3);
			role3.addUser(user);
		}
		System.out.println("###### test user created... "+user);
		return user;
	}

}
