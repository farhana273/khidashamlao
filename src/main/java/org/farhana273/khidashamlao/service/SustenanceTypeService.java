package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.SustenanceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SustenanceTypeService {

	/**
	 * Finds one sustenanceType
	 * 
	 * @param id is the id of the object that is to be found
	 * @return the sustenanceType object
	 */
	SustenanceType findSustenanceType(Long id);

	/**
	 * Shows all sustenanceTypes data from the database
	 * @param pageable 
	 * 
	 * @return an iterable collection
	 */
	Page<SustenanceType> showAllSustenanceTypes(Pageable pageable);

	/**
	 * Saves the new object in the database
	 * 
	 * @param sustenanceType is the object that is to be saved
	 * @return null
	 */
	void saveSustenanceType(SustenanceType sustenanceType);

	/**
	 * Deletes the sustenanceType entity from the database
	 * 
	 * @param id the id of the sustenanceType to be deleted
	 * @return null
	 */
	void deleteSustenanceType(Long id);

}
