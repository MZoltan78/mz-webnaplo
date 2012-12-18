package com.mz.webnaplo.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	
	@Lob
	@Column(length=4000000)
	private byte[] data;
	
	private String contentType;
	
	@ManyToOne
	private Gallery gallery;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	/**
	 * ******************** Constructor ***********************
	 */
	public Picture() {
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * ******************** toString ***********************
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Picture [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", contentType=");
		builder.append(contentType);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		return builder.toString();
	}
}
