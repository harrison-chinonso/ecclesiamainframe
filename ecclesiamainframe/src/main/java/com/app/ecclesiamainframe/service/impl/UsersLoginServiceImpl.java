/**
 * 
 */
package com.app.ecclesiamainframe.service.impl;

import java.util.List;
import java.util.Optional;

//import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.stereotype.Service;



import com.app.ecclesiamainframe.dao.UsersLoginDao;
import com.app.ecclesiamainframe.entity.UsersLogin;
import com.app.ecclesiamainframe.service.UsersLoginService;
//import com.app.ecclesiamainframe.util.HibernateUtil;
/**
 * @author Harry
 *
 */
@Service
public class UsersLoginServiceImpl implements UsersLoginService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private UsersLoginDao usersLoginDao;
	
	public UsersLoginServiceImpl() {
		super();
	}

	@Transactional
	public UsersLogin saveUsersLogin(UsersLogin user) {
		// TODO Auto-generated method stub
		return usersLoginDao.save(user);
	}

	@Transactional
	public UsersLogin updateUsersLogin(UsersLogin usersLogin) {
		return usersLoginDao.saveAndFlush(usersLogin);
	}

	@Transactional
	public List<UsersLogin> getUsersLogin() {
		return usersLoginDao.findAll();
	}

	@Transactional
	public Optional<UsersLogin> getsersLogin(Long userId) {
		return usersLoginDao.findById(userId);
	}

	@Transactional
	public void deleteUsersLogin(Long userId) {
		usersLoginDao.deleteById(userId);
	}

}
