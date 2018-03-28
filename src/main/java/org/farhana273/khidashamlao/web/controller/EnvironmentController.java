package org.farhana273.khidashamlao.web.controller;

import java.util.List;

import org.farhana273.khidashamlao.domain.*;
import org.farhana273.khidashamlao.service.EnvironmentServiceImpl;
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
@RequestMapping(path = "/environment")
public class EnvironmentController {
	private final EnvironmentServiceImpl environmentService;

	@Autowired
	public EnvironmentController(EnvironmentServiceImpl environmentService) {
		this.environmentService = environmentService;

	}

	/**
	 *GET/environment/welcome: Displays a welcome message
	 *
	 * @return A success message
	 */
	@RequestMapping(path = "/welcome")
	public String welcome() {
		return "Welcome to the environment panel";
	}

	/**
	 * POST /environment : Create a new environment to be inserted into the database
	 *
	 * @param environment is the object that is initiated with the information from the input JSON
	 * @return the ResponseEntity with status 200 (OK) and with environment in the body, or with status 404 (Not Found)
	 */
	@PostMapping(path = "")
	public ResponseEntity<Environment> addNewEnvironment(@RequestBody Environment environment) {
		environmentService.saveEnvironment(environment);
		return new ResponseEntity<Environment>(environment, HttpStatus.OK);
	}

	/**
	 * DELETE /environment/delete/:id : Deletes a environment.
	 *
	 * @param id is the id of the object that is to be deleted
	 * @return A success message
	 */
	@DeleteMapping(path = "/delete/{id}")
	public String deleteEnvironment(@PathVariable long id) {

		environmentService.deleteEnvironment(id);
		return "Environment deleted";
	}

	/**
	 * GET /environment/:id : Get a Environment from the database with the given id
	 *
	 *@param id specifies the id of the object of the environment that is to be shown from the database
	 *@return the ResponseEntity with status 200 (OK) and with environment in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<Environment> showEnvironment(@PathVariable long id) {
		Environment environment = environmentService.findEnvironment(id);
		return new ResponseEntity<Environment>(environment, HttpStatus.OK);
	}

	/**
	 * GET /environment: Get all environments from the database 
	 *
	 *@param pageable the pagination information
	 *@return the ResponseEntity with status 200 (OK) and with environment in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "")
	public ResponseEntity<List<Environment>> getAllEnvironments(Pageable pageable) {
		Page<Environment> page = environmentService.showAllEnvironments(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/environment");
		return new ResponseEntity<List<Environment>>(page.getContent(), HttpStatus.OK);
	}

}


