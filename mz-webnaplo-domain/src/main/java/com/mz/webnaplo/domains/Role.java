package com.mz.webnaplo.domains;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<User>();

	/**
	 * ******************** Constructor ***********************
	 */
    public Role() {
	}

	/**
	 * ******************** Pre-Remove ***********************
	 */
	@PreRemove
	void preRemove() 
	{
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (!user.getRoles().isEmpty()) {
				user.removeRole(this);
				iterator.remove();
			}
		}
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	/**
	 * ******************** toString ***********************
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Role [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		return builder.toString();
	}
}