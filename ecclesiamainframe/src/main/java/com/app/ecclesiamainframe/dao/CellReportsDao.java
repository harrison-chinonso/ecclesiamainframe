/**
 * 
 */
package com.app.ecclesiamainframe.dao;



//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.CellReports;


/**
 * @author Harry
 *
 */
@Repository
public interface CellReportsDao extends JpaRepository<CellReports, Long>{
	//List<CellReports> findByMemberName(String memberName);
}
