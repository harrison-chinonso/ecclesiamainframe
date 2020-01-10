/**
 * 
 */
package com.app.ecclesiamainframe.dao;



//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.UsersLogin;


/**
 * @author Harry
 *
 */
@Repository
public interface UsersLoginDao extends JpaRepository<UsersLogin, Long>{
	//List<UsersLogin> findByMemberName(String memberName);
}
