package org.farhana273.khidashamlao.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.farhana273.khidashamlao.domain.*;
import org.farhana273.khidashamlao.service.UserServiceImpl;
import org.farhana273.khidashamlao.util.PaginationUtil;
import org.farhana273.khidashamlao.vm.UserVM;
import org.farhana273.khidashamlao.vm.vmutility.UserVMUtility;
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
@RequestMapping(path = "/user")
public class UserController {
	
	private final UserServiceImpl userService;

	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	/**
	 * GET /user/welcome: Displays a welcome message
	 *
	 * @return A success message
	 */
	@RequestMapping(path = "/welcome")
	public String welcome() {
		return "Welcome to the user panel";
	}

	 /**
     * POST /user : Create a new user to be inserted into the database
     *
     * @param userVM is the object that is initiated with the information from the input JSON
     * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
     */
    @PostMapping(value = "")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserVM userVM) {
        User user = userService.save(UserVMUtility.mapToUser(userVM));
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
    /**
	 * GET /user/:id : Get a user from the database with the given id
	 *
	 * @param id specifies the id of the object of the user that is to be shown from the database
	 * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "{id}")
	public ResponseEntity<User> showUser(@PathVariable long id) {
		User user = userService.findUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	/**
	 * GET /user: Get all users from the database 
	 *
	 * @param pageable the pagination information
	 * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
	 */
	@GetMapping(path = "")
	public ResponseEntity<List<User>> getAllUsers(Pageable pageable) {
		Page<User> page = userService.showAllUsers(pageable);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "localhost:8080/user");
		return new ResponseEntity<List<User>>(page.getContent(), HttpStatus.OK);
	}

	/**
	 * PUT /editUserInfo : Edit information of a user 
	 *
	 * @param user is the object initiated  with the information from the JSON input
	 * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
	 *//*
	@PutMapping(path = "/editUserInfo")
	public ResponseEntity<User> editUserInfo(@RequestBody User user) {
		UserMapper userMapper = new UserMapper(userService.findUser(user.getId()), user);
		user = userMapper.updateInfo();
		userService.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}*/

	/**
	 * PUT /user/updatePassword/{id}/{password} : Change password of a user 
	 *
	 * @param id is the id of the object of the user whose password is to be changed and @param password is the new password
	 * @return the ResponseEntity with status 200 (OK) and with user in the body, or with status 404 (Not Found)
	 */

	@PutMapping(value = "updatePassword/{id}/{password}")
	public ResponseEntity<User> updateUserPassword(@PathVariable long id,
			@PathVariable String password) {
		userService.updatePassword(id, password);
		return new ResponseEntity<User>(userService.findUser(id), HttpStatus.OK);
	}

	/**
	 * DELETE /user/:id : Deletes a user.
	 *
	 * @param id is the id of the object that is to be deleted
	 * @return A success message
	 */
	@DeleteMapping(path = "{id}")
	public String deleteUser(@PathVariable long id) {

		userService.deleteUser(id);
		return "user deleted";
	}
}

