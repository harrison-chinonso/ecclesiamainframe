/**
 * 
 */
package com.app.ecclesiamainframe.dao;



//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.DcaStudents;


/**
 * @author Harry
 *
 */
@Repository
public interface DcaStudentsDao extends JpaRepository<DcaStudents, Long>{
	//List<DcaStudents> findByMemberName(String memberName);
}
