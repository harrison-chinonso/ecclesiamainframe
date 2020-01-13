/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.Users;

/**
 * @author Harry
 *
 */
@Service
public interface UsersService {
	
	Users saveUser(Users user);
	
	Users updateUser(Users user);
	
	List<Users> getUsers();
	
	Optional<Users> getUser(Long userId);
	
	void deleteUser(Long userId);

	Users findByUsername(String userName);
}

