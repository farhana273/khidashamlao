package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EnvironmentService {

	/**
	 * Finds one environment
	 * 
	 * @param id is the id of the object that is to be found
	 * @return the environment object
	 */
	Environment findEnvironment(Long id);

	/**
	 * Shows all environments data from the database
	 * @param pageable 
	 * 
	 * @return an iterable collection
	 */
	Page<Environment> showAllEnvironments(Pageable pageable);

	/**
	 * Saves the new object in the database
	 * 
	 * @param environment is the object that is to be saved
	 * @return null
	 */
	void saveEnvironment(Environment environment);

	/**
	 * Deletes the environment entity from the database
	 * 
	 * @param id the id of the environment to be deleted
	 * @return null
	 */
	void deleteEnvironment(Long id);

}
