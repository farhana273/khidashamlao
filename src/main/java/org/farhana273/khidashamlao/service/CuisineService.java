package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Cuisine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CuisineService {

	/**
	 * Finds one cuisine
	 * 
	 * @param id is the id of the object that is to be found
	 * @return the cuisine object
	 */
	Cuisine findCuisine(Long id);

	/**
	 * Shows all cuisines data from the database
	 * @param pageable 
	 * 
	 * @return an iterable collection
	 */
	Page<Cuisine> showAllCuisines(Pageable pageable);

	/**
	 * Saves the new object in the database
	 * 
	 * @param cuisine is the object that is to be saved
	 * @return null
	 */
	void saveCuisine(Cuisine cuisine);

	/**
	 * Deletes the cuisine entity from the database
	 * 
	 * @param id the id of the cuisine to be deleted
	 * @return null
	 */
	void deleteCuisine(Long id);

}
