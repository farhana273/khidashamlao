package org.farhana273.khidashamlao.service;

import org.farhana273.khidashamlao.domain.User;
import org.farhana273.khidashamlao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
     * @inheritDoc
     */
	public User findUser(Long id) {
		User user = userRepository.findOne(id);
		return user;
	}

	/**
     * @inheritDoc
     */
	public Page<User> showAllUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	/**
     * @inheritDoc
     */
	public void saveUser(User user) {
		userRepository.save(user);
	}

	/**
     * @inheritDoc
     */
	public void deleteUser(Long id) {
		
		userRepository.delete(id);
	}

	/**
     * @inheritDoc
     */
	public void updatePassword(Long id,String password){
		
     userRepository.updatePassword(id, password);
	}
	
	/**
     * @inheritDoc
     */
	 public User save(User user) {
	        return userRepository.save(user);
	    }
}