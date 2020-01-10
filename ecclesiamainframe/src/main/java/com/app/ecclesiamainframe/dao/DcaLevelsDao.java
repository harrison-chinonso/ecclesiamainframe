/**
 * 
 */
package com.app.ecclesiamainframe.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.DcaLevels;


/**
 * @author Harry
 *
 */
@Repository
public interface DcaLevelsDao extends JpaRepository<DcaLevels, Long>{
	List<DcaLevels> findByDcaName(String dcaName);
}
