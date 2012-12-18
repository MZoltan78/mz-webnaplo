package com.mz.webnaplo.repository.implementations;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mz.webnaplo.domains.Gallery;
import com.mz.webnaplo.repository.base.AbstractGenericDao;

@Component
public class GalleryRepository extends AbstractGenericDao<Gallery> {

	public GalleryRepository() {
		super(Gallery.class);
	}

	public List<Gallery> getAllGalleries() {
		return super.runCustomQuery(entityManager.createQuery("SELECT o FROM gallery o", Gallery.class));
	}
}
