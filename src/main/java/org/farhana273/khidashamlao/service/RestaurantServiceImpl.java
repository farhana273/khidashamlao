package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Restaurant;
import org.farhana273.khidashamlao.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantRepository restaurantRepository;

	@Autowired
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	/**
	 * @inheritDoc
	 */
	public Restaurant findRestaurant(Long id) {
		Restaurant restaurant = restaurantRepository.findOne(id);
		return restaurant;
	}

	/**
	 * @inheritDoc
	 */
	public Page<Restaurant> showAllRestaurants(Pageable pageable) {
		return restaurantRepository.findAll(pageable);
	}

	/**
	 * @inheritDoc
	 */
	public void saveRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
	}

	/**
	 * @inheritDoc
	 */
	public void deleteRestaurant(Long id) {
		restaurantRepository.delete(id);
	}


}
