package org.farhana273.khidashamlao.web.controller;

import java.util.List;

import org.farhana273.khidashamlao.domain.*;
import org.farhana273.khidashamlao.service.OfferServiceImpl;
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
@RequestMapping(path = "/offer")
public class OfferController {
	private final OfferServiceImpl offerService;

	@Autowired
	public OfferController(OfferServiceImpl offerService) {
		this.offerService = offerService;

	}

	/**
	 *GET/offer/welcome: Displays a welcome message
	 *
	 * @return A success message
	 */
	@RequestMapping(path = "/welcome")
	public String welcome() {
		return "Welcome to the offer panel";
	}

	/**
	 * POST /offer : Create a new offer to be inserted into the database
	 *
	 * @param offer is the object that is initiated with the information from the input JSON
	 * @return the ResponseEntity with status 200 (OK) and with offer in the body, or with status 404 (Not Found)
	 */
	@PostMapping(path = "")
	public ResponseEntity<Offer> addNewOffer(@RequestBody Offer offer) {
		offerService.saveOffer(offer);
		return new ResponseEntity<Offer>(offer, HttpStatus.OK);
	}

	/**
	 * DELETE /offer/delete/:id : Deletes a offer.
	 *
	 * @param id is the id of the object that is to be deleted
	 * @return A success message
	 */
	@DeleteMapping(path = "/delete/{id}")
	public String deleteOffer(@PathVariable long id) {

		offerService.deleteOffer(id);
		return "Offer deleted";
	}

	/**
	 * GET /offer/:id : Get a Offer from the database with the given id
	 *
	 *@param id specifies the id of the object of the offer that is to be shown from the database
	 *@return the ResponseEntity with status 200 (OK) and with offer in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<Offer> showOffer(@PathVariable long id) {
		Offer offer = offerService.findOffer(id);
		return new ResponseEntity<Offer>(offer, HttpStatus.OK);
	}

	/**
	 * GET /offer: Get all offers from the database 
	 *
	 *@param pageable the pagination information
	 *@return the ResponseEntity with status 200 (OK) and with offer in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "")
	public ResponseEntity<List<Offer>> getAllOffers(Pageable pageable) {
		Page<Offer> page = offerService.showAllOffers(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/offer");
		return new ResponseEntity<List<Offer>>(page.getContent(), HttpStatus.OK);
	}

}


