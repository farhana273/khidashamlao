package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

	/**
	 * Finds one user
	 * 
	 * @param id is the id of the object that is to be found
	 * @return the user object
	 */
	User findUser(Long id);

	/**
	 * Shows all user data from the database
	 * 
	 * @return an iterable collection
	 */
	Page<User> showAllUsers(Pageable pageable);

	/**
	 * Deletes the user entity from the database
	 * 
	 * @param id is the id object that is to be deleted
	 * @return null
	 */
	void deleteUser(Long id);
	
	/**
	 * Updates the password of a user
	 * 
	 * @param id is the id object whose password will be updated and @param password is the new password
	 * @return null
	 */
	void updatePassword(Long id,String password);
	
	 /**
     * Saves a user.
     *
     * @param user is the id of the object that is to be saved
     * @return null
     */
    User save(User user);

}
