/**
 * 
 */
package com.app.ecclesiamainframe.dao;



//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.Users;


/**
 * @author Harry
 *
 */
@Repository
public interface UsersDao extends JpaRepository<Users, Long>{
	Users findByUsername(String username);
}
