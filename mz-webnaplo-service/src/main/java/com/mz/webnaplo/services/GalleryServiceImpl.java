package com.mz.webnaplo.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.webnaplo.domains.Gallery;
import com.mz.webnaplo.interfaces.GalleryService;
import com.mz.webnaplo.repository.implementations.GalleryRepository;

@Service("GalleryService")
public class GalleryServiceImpl implements GalleryService  {

	@Autowired
	private GalleryRepository galleryRepository;

	@Transactional(noRollbackFor={EmptyResultDataAccessException.class,NoResultException.class})
	public List<Gallery> getAllGalleries() {
		return galleryRepository.findAll();
	}

}
