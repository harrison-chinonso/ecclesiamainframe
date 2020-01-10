/**
 * 
 */
package com.app.ecclesiamainframe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.ecclesiamainframe.dao.UsersDao;
import com.app.ecclesiamainframe.entity.Users;
import com.app.ecclesiamainframe.service.UsersService;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {
	Users user = new Users();
	
	@Autowired
	private UsersService UsersService;
	
	@SuppressWarnings("unused")
	@Autowired
	private UsersDao UsersDao;
	
	 @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public Users save(@RequestBody Users User) {
		return UsersService.saveUser(User);
	}
	
	 @PutMapping(path= "/update")
	public Users update(@RequestBody Users User) {
		return UsersService.updateUser(User);
	}
	
	 @GetMapping(path="/list")
	 @ResponseBody
	public List<Users> getUsers(){
		return UsersService.getUsers();
	}
	
	@GetMapping(path="/{UserId}", produces = "application/json")
	public Optional<Users> getUser(@PathVariable(name = "UserId") Long UserId) {
		return UsersService.getUser(UserId);
	}
	
//	@GetMapping(path="/login/{UserId}", produces = "application/json")
//	public Optional<Users> getUser(@PathVariable(name = "UserId") Long UserId) {
//		return UsersService.getUser(UserId);
//	}
	
	@GetMapping(path="name/{UserName}", produces = "application/json")
	public Users getUser(@PathVariable(name = "UserName") String UserName) {	
		return UsersService.findByUsername(UserName);
	}
	
	
	@DeleteMapping("/delete/{UserId}")
	public void deleteUser(@PathVariable(name = "UserId") Long UserId) {
		UsersService.deleteUser(UserId);
	}
	
	
	
}
