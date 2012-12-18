package com.mz.webnaplo.services;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.webnaplo.domains.Picture;
import com.mz.webnaplo.interfaces.PictureService;
import com.mz.webnaplo.repository.implementations.PictureRepository;

@Service("PictureService")
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureRepository pictureRepository;

	@Override
	@Transactional(noRollbackFor={EmptyResultDataAccessException.class,NoResultException.class})
	public List<Picture> getAllPictures() {
		return pictureRepository.findAll();
	}

}
