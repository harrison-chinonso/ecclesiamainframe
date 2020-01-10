/**
 * 
 */
package com.app.ecclesiamainframe.dao;



//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.Cells;


/**
 * @author Harry
 *
 */
@Repository
public interface CellsDao extends JpaRepository<Cells, Long>{
	//List<Cells> findByMemberName(String memberName);
}
