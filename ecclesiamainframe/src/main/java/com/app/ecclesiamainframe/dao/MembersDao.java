/**
 * 
 */
package com.app.ecclesiamainframe.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.Members;


/**
 * @author Harry
 *
 */
@Repository
public interface MembersDao extends JpaRepository<Members, Long>{
	List<Members> findByMemberName(String memberName);
}
