package org.farhana273.khidashamlao.web.controller;

import java.util.List;

import org.farhana273.khidashamlao.domain.*;
import org.farhana273.khidashamlao.service.RestaurantServiceImpl;
import org.farhana273.khidashamlao.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {
	
	private final RestaurantServiceImpl restaurantService;

	@Autowired
	public RestaurantController(RestaurantServiceImpl restaurantService) {
		
		this.restaurantService = restaurantService;

	}

	/**
	 * GET /restaurant/welcome: Displays a welcome message
	 *
	 * @return A success message
	 */
	@RequestMapping(path = "/welcome")
	public String welcome() {
		
		return "Welcome to the restaurant panel";
	}

	/**
	 * POST /restaurant : Create a new restaurant to be inserted into the database
	 *
	 * @param restaurant is the object that is initiated with the information from the input JSON
	 * @return the ResponseEntity with status 200 (OK) and with restaurant in the body, or with status 404 (Not Found)
	 */
	@PostMapping(path = "")
	public ResponseEntity<Restaurant> addNewRestaurant(@RequestBody Restaurant restaurant) {
		
		restaurantService.saveRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}
	
	/**
	 * GET /restaurant/:id : Get a restaurant from the database with the given id
	 *
	 *@param id specifies the id of the object of the restaurant that is to be shown from the database
	 *@return the ResponseEntity with status 200 (OK) and with restaurant in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<Restaurant> showRestaurant(@PathVariable long id) {
		
		Restaurant restaurant = restaurantService.findRestaurant(id);
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

	/**
	 * GET /restaurant: Get all restaurants from the database 
	 *
	 *@param pageable the pagination information
	 *@return the ResponseEntity with status 200 (OK) and with restaurant in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "")
	public ResponseEntity<List<Restaurant>> getAllRestaurants(Pageable pageable) {
		
		Page<Restaurant> page = restaurantService.showAllRestaurants(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/restaurant");
		return new ResponseEntity<List<Restaurant>>(page.getContent(), HttpStatus.OK);
	}

	/**
	 * DELETE /restaurant/:id : Deletes a restaurant.
	 *
	 * @param id is the id of the object that is to be deleted
	 * @return A success message
	 */
	
	@DeleteMapping(path = "{id}")
	public String deleteRestaurant(@PathVariable long id) {

		restaurantService.deleteRestaurant(id);
		return "restaurant deleted";
	}
}


