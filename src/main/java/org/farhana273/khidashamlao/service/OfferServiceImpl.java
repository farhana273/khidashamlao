package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Offer;
import org.farhana273.khidashamlao.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

	private final OfferRepository offerRepository;

	@Autowired
	public OfferServiceImpl(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}

	/**
     * @inheritDoc
     */
	public Offer findOffer(Long id) {
		Offer offer = offerRepository.findOne(id);
		return offer;
	}
	
	/**
     * @inheritDoc
     */
	public Page<Offer> showAllOffers(Pageable pageable) {
		return offerRepository.findAll(pageable);
	}

	/**
     * @inheritDoc
     */
	public void saveOffer(Offer offer) {
		offerRepository.save(offer);
	}

	/**
     * @inheritDoc
     */
	public void deleteOffer(Long id) {
		offerRepository.delete(id);
	}

}
