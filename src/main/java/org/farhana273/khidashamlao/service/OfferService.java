package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfferService {

	/**
	 * Finds one offer
	 * 
	 * @param id is the id of the object that is to be found
	 * @return the offer object
	 */
	Offer findOffer(Long id);

	/**
	 * Shows all offers data from the database
	 * @param pageable 
	 * 
	 * @return an iterable collection
	 */
	Page<Offer> showAllOffers(Pageable pageable);

	/**
	 * Saves the new object in the database
	 * 
	 * @param offer is the object that is to be saved
	 * @return null
	 */
	void saveOffer(Offer offer);

	/**
	 * Deletes the offer entity from the database
	 * 
	 * @param id the id of the offer to be deleted
	 * @return null
	 */
	void deleteOffer(Long id);

}
