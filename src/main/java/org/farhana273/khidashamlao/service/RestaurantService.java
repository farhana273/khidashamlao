package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RestaurantService {

	/**
	 * Finds one restaurant
	 * 
	 * @param id is the id of the object that is to be found
	 * @return the restaurant object
	 */
	Restaurant findRestaurant(Long id);

	/**
	 * Shows all restaurant data from the database
	 * @param pageable 
	 * 
	 * @return an iterable collection
	 */
	Page<Restaurant> showAllRestaurants(Pageable pageable);

	/**
	 * Saves the new object in the database
	 * 
	 * @param restaurant is the object that is to be saved
	 * @return null
	 */
	void saveRestaurant(Restaurant restaurant);

	/**
	 * Deletes the restaurant entity from the database
	 * 
	 * @param id is the id of the restaurant to be deleted
	 * @return null
	 */

	void deleteRestaurant(Long id);

}
