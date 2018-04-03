package org.farhana273.khidashamlao.web.controller;

import java.util.List;

import org.farhana273.khidashamlao.domain.*;
import org.farhana273.khidashamlao.service.SustenanceServiceImpl;
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
@RequestMapping(path = "/sustenance")
public class SustenanceController {
	
	private final SustenanceServiceImpl sustenanceService;

	@Autowired
	public SustenanceController(SustenanceServiceImpl sustenanceService) {
		
		this.sustenanceService = sustenanceService;

	}

	/**
	 *GET /sustenance/welcome: Displays a welcome message
	 *
	 * @return A success message
	 */
	@RequestMapping(path = "/welcome")
	public String welcome() {
		
		return "Welcome to the sustenance panel";
	}

	/**
	 * POST /sustenance : Create a new sustenance to be inserted into the database
	 *
	 * @param sustenance is the object that is initiated with the information from the input JSON
	 * @return the ResponseEntity with status 200 (OK) and with sustenance in the body, or with status 404 (Not Found)
	 */
	@PostMapping(path = "")
	public ResponseEntity<Sustenance> addNewSustenance(@RequestBody Sustenance sustenance) {
		
		sustenanceService.saveSustenance(sustenance);
		return new ResponseEntity<Sustenance>(sustenance, HttpStatus.OK);
	}
	
	/**
	 * GET /sustenance/:id : Get a Sustenance from the database with the given id
	 *
	 * @param id specifies the id of the object of the sustenance that is to be shown from the database
	 * @return the ResponseEntity with status 200 (OK) and with sustenance in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<Sustenance> showSustenance(@PathVariable long id) {
		
		Sustenance sustenance = sustenanceService.findSustenance(id);
		return new ResponseEntity<Sustenance>(sustenance, HttpStatus.OK);
	}

	/**
	 * GET /sustenances: Get all sustenances from the database 
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and with sustenance in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "")
	public ResponseEntity<List<Sustenance>> getAllSustenances(Pageable pageable) {
		
		Page<Sustenance> page = sustenanceService.showAllSustenances(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/sustenance");
		return new ResponseEntity<List<Sustenance>>(page.getContent(), HttpStatus.OK);
	}

	/**
	 * DELETE /sustenance/:id : Deletes a sustenance.
	 *
	 * @param id is the id of the object that is to be deleted
	 * @return A success message
	 */
	@DeleteMapping(path = "{id}")
	public String deleteSustenance(@PathVariable long id) {

		sustenanceService.deleteSustenance(id);
		return "Sustenance deleted";
	}
}


