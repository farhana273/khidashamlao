package org.farhana273.khidashamlao.web.controller;

import java.util.List;

import org.farhana273.khidashamlao.domain.*;
import org.farhana273.khidashamlao.service.SustenanceTypeServiceImpl;
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
@RequestMapping(path = "/sustenanceType")
public class SustenanceTypeController {
	
	private final SustenanceTypeServiceImpl sustenanceTypeService;

	@Autowired
	public SustenanceTypeController(SustenanceTypeServiceImpl sustenanceTypeService) {
		
		this.sustenanceTypeService = sustenanceTypeService;
}

	/**
	 * GET/sustenanceType/welcome: Displays a welcome message
	 *
	 * @return A success message
	 */
	@RequestMapping(path = "/welcome")
	public String welcome() {
		
		return "Welcome to the sustenanceType panel";
	}

	/**
	 * POST /sustenanceType : Create a new sustenanceType to be inserted into the database
	 *
	 * @param sustenanceType is the object that is initiated with the information from the input JSON
	 * @return the ResponseEntity with status 200 (OK) and with sustenanceType in the body, or with status 404 (Not Found)
	 */
	@PostMapping(path = "")
	public ResponseEntity<SustenanceType> addNewSustenanceType(@RequestBody SustenanceType sustenanceType) {
		
		sustenanceTypeService.saveSustenanceType(sustenanceType);
		return new ResponseEntity<SustenanceType>(sustenanceType, HttpStatus.OK);
	}
	
	/**
	 * GET /sustenanceType/:id : Get a SustenanceType from the database with the given id
	 *
	 * @param id specifies the id of the object of the sustenanceType that is to be shown from the database
	 * @return the ResponseEntity with status 200 (OK) and with sustenanceType in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<SustenanceType> showSustenanceType(@PathVariable long id) {
		
		SustenanceType sustenanceType = sustenanceTypeService.findSustenanceType(id);
		return new ResponseEntity<SustenanceType>(sustenanceType, HttpStatus.OK);
	}

	/**
	 * GET /sustenanceType: Get all sustenanceTypes from the database 
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and with sustenanceType in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "")
	public ResponseEntity<List<SustenanceType>> getAllSustenanceTypes(Pageable pageable) {
		
		Page<SustenanceType> page = sustenanceTypeService.showAllSustenanceTypes(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/sustenanceType");
		return new ResponseEntity<List<SustenanceType>>(page.getContent(), HttpStatus.OK);
	}

	/**
	 * DELETE /sustenanceType/delete/:id : Deletes a sustenanceType.
	 *
	 * @param id is the id of the object that is to be deleted
	 * @return A success message
	 */
	@DeleteMapping(path = "/delete/{id}")
	public String deleteSustenanceType(@PathVariable long id) {

		sustenanceTypeService.deleteSustenanceType(id);
		return "SustenanceType deleted";
	}
}


