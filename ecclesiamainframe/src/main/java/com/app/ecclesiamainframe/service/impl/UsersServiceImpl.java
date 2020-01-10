/**
 * 
 */
package com.app.ecclesiamainframe.service.impl;

//import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Session;
import org.hibernate.Transaction;

//import org.primefaces.component.inputtext.InputText;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsersService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.dao.UsersDao;
import com.app.ecclesiamainframe.entity.Users;
import com.app.ecclesiamainframe.service.UsersService;
import com.app.ecclesiamainframe.util.HibernateUtil;

/**
 * @author Harry
 *
 */
@Service
public class UsersServiceImpl implements UsersService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private UsersDao usersDao;
	
	public UsersServiceImpl() {
		super();
	}

	@Transactional
	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		return usersDao.save(user);
	}

	@Transactional
	public Users updateUser(Users user) {
		// TODO Auto-generated method stub
		return usersDao.saveAndFlush(user);
	}

	@Transactional
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return usersDao.findAll();
	}

	@Transactional
	public Optional<Users> getUser(Long userId) {
		// TODO Auto-generated method stub
		return usersDao.findById(userId);
	}

	@Transactional
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		usersDao.deleteById(userId);
	}

	@Transactional
	//@SuppressWarnings("unchecked")
	public Users findByUsername(String userName) {
		//return usersDao.findByMemberName(memberName);
		 Users users = null;
		try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	      // Native query selecting all columns
	         Query query = session.createNativeQuery("SELECT * FROM users_tb where username like :userName","UserMapping")
	        		 .setParameter("userName","%"+userName+"%"); //named parameter binding 
	         users = (Users) query.getSingleResult();
	         transaction.commit(); 
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }
	     // HibernateUtil.shutdown();
	      return users;
	}
	
	
	/**
	 * Construct UserDetails instance required by spring security
	 */
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		
//		List<Users> user = usersDao.findByUsername(userName);
//		
//		if (user == null) {
//			throw new UsernameNotFoundException(String.format(getMessageBundle().getString("badCredentials"), userName));
//		}
//		
//		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//		
//		User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
//		
//		return userDetails;
//	}

}



