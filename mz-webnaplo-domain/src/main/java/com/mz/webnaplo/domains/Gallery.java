package com.mz.webnaplo.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Gallery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@ManyToOne
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Picture> pictures = new ArrayList<Picture>(0);

	/**
	 * ******************** Constructor ***********************
	 */
	public Gallery() {
		creationDate = new Date();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void addPicture(Picture picture) 
	{
		if (picture.getGallery() != null) {
			throw new IllegalArgumentException();
		}
		pictures.add(picture);
		picture.setGallery(this);
	}

	public void removePicture(Picture picture)
	{
		pictures.remove(pictures);
	}

	/**
	 * ******************** toString ***********************
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Gallery [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		return builder.toString();
	}
}
