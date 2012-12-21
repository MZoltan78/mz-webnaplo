package com.mz.webnaplo.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;

import com.mz.webnaplo.enums.Gender;

@Entity
public class User {

	public static final int USER_DISABLED	 	= 0;
	public static final int USER_ENABLED 		= 1;

	public static final int USER_NOTACTIVATED	= 0;
	public static final int USER_ACTIVATED		= 1;

	public static final int REGISTRATION_SHALLOW 	= 0;
	public static final int REGISTRATION_FULL 		= 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, unique = true)
	@Email
	private String email;

	@Column(unique = true)
	private String username;

	private String password;

	private String description;

	private Gender gender;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthdate;

	private String phone;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Address> addresses = new HashSet<Address>(0);

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") })
	private Set<Role> roles = new HashSet<Role>(1);

	private Integer enabled = USER_ENABLED;

	private Integer activated = USER_NOTACTIVATED;

	private Integer registrationType = REGISTRATION_FULL;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Gallery> galleries = new ArrayList<Gallery>(0);

	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private SystemSettings systemSettings;
	
	// linkedin connection information
	private String linkedInAccessToken;
	private String linkedInSecret;
	
	// facebook connection information
	private String facebookClientId;
	private String facebookClientSecret;
	
	// twitter connection information
	private String twitterAccessToken;
	private String twitterSecret;
	
	
	/**
	 * ******************** Constructor ***********************
	 */
	public User() {
	}

	/**
	 * ******************** Getters and setters ***********************
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public void addAddress(Address address) {
		this.addresses.add(address);
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role) {
		this.roles.add(role);
	}

	public void removeRole(Role role) 
	{
		roles.remove(role);
	}

	public boolean isEnabled() {
		return ( enabled == USER_ENABLED );
	}

	public void setEnabled(boolean enabled) {
		if (enabled) {
			this.enabled = USER_ENABLED;
		} else {
			this.enabled = USER_DISABLED;
		}
	}

	public boolean isActivated() {
		return ( activated == USER_ACTIVATED );
	}

	public void setActivated(boolean activated) {
		if (activated) {
			this.activated = USER_ACTIVATED;
		} else {
			this.activated = USER_NOTACTIVATED;
		}
	}
	public boolean isRegistrationTypeFull() {
		return ( registrationType == REGISTRATION_FULL );
	}

	public void setRegistrationType(int registrationType) {
		this.registrationType = registrationType;
	}

	public void setRegistrationTypeFull(boolean regFull) {
		if (regFull) {
			this.registrationType = REGISTRATION_FULL;
		} else {
			this.registrationType = REGISTRATION_SHALLOW;
		}		
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Gallery> getGalleries() {
		return galleries;
	}

	public void addGallery(Gallery gallery) 
	{
		if (gallery.getUser() != null) {
			throw new IllegalArgumentException();
		}
		galleries.add(gallery);
		gallery.setUser(this);
	}
	
	public SystemSettings getSystemSettings() {
		return systemSettings;
	}

	public void setSystemSettings(SystemSettings systemSettings) {
		this.systemSettings = systemSettings;
	}

	public String getLinkedInAccessToken() {
		return linkedInAccessToken;
	}

	public void setLinkedInAccessToken(String linkedInAccessToken) {
		this.linkedInAccessToken = linkedInAccessToken;
	}

	public String getLinkedInSecret() {
		return linkedInSecret;
	}

	public void setLinkedInSecret(String linkedInSecret) {
		this.linkedInSecret = linkedInSecret;
	}

	public String getFacebookClientId() {
		return facebookClientId;
	}

	public void setFacebookClientId(String facebookClientId) {
		this.facebookClientId = facebookClientId;
	}

	public String getFacebookClientSecret() {
		return facebookClientSecret;
	}

	public void setFacebookClientSecret(String facebookClientSecret) {
		this.facebookClientSecret = facebookClientSecret;
	}

	public String getTwitterAccessToken() {
		return twitterAccessToken;
	}

	public void setTwitterAccessToken(String twitterAccessToken) {
		this.twitterAccessToken = twitterAccessToken;
	}

	public String getTwitterSecret() {
		return twitterSecret;
	}

	public void setTwitterSecret(String twitterSecret) {
		this.twitterSecret = twitterSecret;
	}

	/**
	 * ******************** toString ***********************
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", username=");
		builder.append(username);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", birthdate=");
		builder.append(birthdate);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", addresses=");
		builder.append(addresses);
		builder.append(", roles=");
		builder.append(roles);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", activated=");
		builder.append(activated);
		builder.append(", registrationType=");
		builder.append(registrationType);
		builder.append(", registrationDate=");
		builder.append(registrationDate);
		builder.append("]");
		return builder.toString();
	}
}
