package com.mz.webnaplo.domains;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SystemSettings {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Locale locale;
	
	@OneToOne
    private User user;

	/**
	 * ******************** Constructor ***********************
	 */
	public SystemSettings() {
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

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ******************** toString ***********************
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SystemSettings [id=");
		builder.append(id);
		builder.append(", locale=");
		builder.append(locale);
		builder.append("]");
		return builder.toString();
	}
}
