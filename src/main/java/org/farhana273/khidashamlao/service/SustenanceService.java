package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Sustenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SustenanceService {
	
	/**
	 * Finds one sustenance
	 * 
	 * @param id is the id of the object that is to be found
	 * @return the sustenance object
	 */
	Sustenance findSustenance(Long id);
	
	/**
	 * Shows all sustenance data from the database
	 * @param pageable 
	 * 
	 * @return an iterable collection
	 */
    Page<Sustenance> showAllSustenances(Pageable page);

    /**
	 * Saves the new object in the database
	 * 
	 * @param sustenance is the object that is to be saved
	 * @return null
	 */
	void saveSustenance(Sustenance sustenance);

	/**
	 * Deletes the sustenance entity from the database
	 * 
	 * @param id the id of the sustenance to be deleted
	 * @return null
	 */
	void deleteSustenance(Long id);

}
