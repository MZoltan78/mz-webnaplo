package com.mz.webnaplo.domains.fileupload;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UploadedFile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private Integer size;
	private String url;
	private String thumbnailUrl;
	private String deleteUrl;
	private String deleteType;

	public UploadedFile() 
	{
	}

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

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getDeleteUrl() {
		return deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}

	public String getDeleteType() {
		return deleteType;
	}

	public void setDeleteType(String deleteType) {
		this.deleteType = deleteType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UploadedFile [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", size=");
		builder.append(size);
		builder.append(", url=");
		builder.append(url);
		builder.append(", thumbnailUrl=");
		builder.append(thumbnailUrl);
		builder.append(", deleteUrl=");
		builder.append(deleteUrl);
		builder.append(", deleteType=");
		builder.append(deleteType);
		builder.append("]");
		return builder.toString();
	}
}
