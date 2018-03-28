package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Cuisine;
import org.farhana273.khidashamlao.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CuisineServiceImpl implements CuisineService {

	private final CuisineRepository cuisineRepository;

	@Autowired
	public CuisineServiceImpl(CuisineRepository cuisineRepository) {
		this.cuisineRepository = cuisineRepository;
	}

	/**
     * @inheritDoc
     */
	public Cuisine findCuisine(Long id) {
		Cuisine cuisine = cuisineRepository.findOne(id);
		return cuisine;
	}
	
	/**
     * @inheritDoc
     */
	public Page<Cuisine> showAllCuisines(Pageable pageable) {
		return cuisineRepository.findAll(pageable);
	}

	/**
     * @inheritDoc
     */
	public void saveCuisine(Cuisine cuisine) {
		cuisineRepository.save(cuisine);
	}

	/**
     * @inheritDoc
     */
	public void deleteCuisine(Long id) {
		cuisineRepository.delete(id);
	}

}
