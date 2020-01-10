/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.UsersLogin;

/**
 * @author Harry
 *
 */
@Service
public interface UsersLoginService {
	
	UsersLogin saveUsersLogin(UsersLogin usersLogin);
	
	UsersLogin updateUsersLogin(UsersLogin usersLogin);
	
	List<UsersLogin> getUsersLogin();
	
	Optional<UsersLogin> getsersLogin(Long userId);
	
	void deleteUsersLogin(Long userId);

	//List<UsersLogin> findByUsersLoginname(String loginName);
}
