package org.farhana273.khidashamlao.web.controller;

import java.util.List;

import org.farhana273.khidashamlao.domain.*;
import org.farhana273.khidashamlao.service.CuisineServiceImpl;
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
@RequestMapping(path = "/cuisine")
public class CuisineController {
	private final CuisineServiceImpl cuisineService;

	@Autowired
	public CuisineController(CuisineServiceImpl cuisineService) {
		this.cuisineService = cuisineService;

	}

	/**
	 *GET/cuisine/welcome: Displays a welcome message
	 *
	 * @return A success message
	 */
	@RequestMapping(path = "/welcome")
	public String welcome() {
		return "Welcome to the cuisine panel";
	}

	/**
	 * POST /cuisine : Create a new cuisine to be inserted into the database
	 *
	 * @param cuisine is the object that is initiated with the information from the input JSON
	 * @return the ResponseEntity with status 200 (OK) and with cuisine in the body, or with status 404 (Not Found)
	 */
	@PostMapping(path = "")
	public ResponseEntity<Cuisine> addNewCuisine(@RequestBody Cuisine cuisine) {
		cuisineService.saveCuisine(cuisine);
		return new ResponseEntity<Cuisine>(cuisine, HttpStatus.OK);
	}

	/**
	 * DELETE /cuisine/delete/:id : Deletes a cuisine.
	 *
	 * @param id is the id of the object that is to be deleted
	 * @return A success message
	 */
	@DeleteMapping(path = "/delete/{id}")
	public String deleteCuisine(@PathVariable long id) {

		cuisineService.deleteCuisine(id);
		return "Cuisine deleted";
	}

	/**
	 * GET /cuisine/:id : Get a Cuisine from the database with the given id
	 *
	 *@param id specifies the id of the object of the cuisine that is to be shown from the database
	 *@return the ResponseEntity with status 200 (OK) and with cuisine in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<Cuisine> showCuisine(@PathVariable long id) {
		Cuisine cuisine = cuisineService.findCuisine(id);
		return new ResponseEntity<Cuisine>(cuisine, HttpStatus.OK);
	}

	/**
	 * GET /cuisine: Get all cuisines from the database 
	 *
	 *@param pageable the pagination information
	 *@return the ResponseEntity with status 200 (OK) and with cuisine in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "")
	public ResponseEntity<List<Cuisine>> getAllCuisines(Pageable pageable) {
		Page<Cuisine> page = cuisineService.showAllCuisines(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/cuisine");
		return new ResponseEntity<List<Cuisine>>(page.getContent(), HttpStatus.OK);
	}

}


