package com.mz.webnaplo.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	private String city;

	private String zip;

	private String street;

	/**
	 * ******************** Constructor ***********************
	 */
	public Address() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * ******************** toString ***********************
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", city=");
		builder.append(city);
		builder.append(", zip=");
		builder.append(zip);
		builder.append(", street=");
		builder.append(street);
		builder.append("]");
		return builder.toString();
	}
}
