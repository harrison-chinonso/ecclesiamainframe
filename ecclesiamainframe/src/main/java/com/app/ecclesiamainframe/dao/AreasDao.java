/**
 * 
 */
package com.app.ecclesiamainframe.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.Areas;


/**
 * @author Harry
 *
 */
@Repository
public interface AreasDao extends JpaRepository<Areas, Long>{
	List<Areas> findByAreaName(String areaName);
}
