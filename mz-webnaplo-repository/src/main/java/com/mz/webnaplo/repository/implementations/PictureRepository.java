package com.mz.webnaplo.repository.implementations;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mz.webnaplo.domains.Picture;
import com.mz.webnaplo.repository.base.AbstractGenericDao;

@Component
public class PictureRepository extends AbstractGenericDao<Picture> {

	public PictureRepository() {
		super(Picture.class);
	}

	public List<Picture> getAllPictures() {
		return super.runCustomQuery(entityManager.createQuery("SELECT o FROM picture o", Picture.class));
	}
}
