/**
 * 
 */
package com.app.ecclesiamainframe.dao;



//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.AreaReports;


/**
 * @author Harry
 *
 */
@Repository
public interface AreaReportsDao extends JpaRepository<AreaReports, Long>{
	//List<AreaReports> findByAreaName(String areaName);
}
