/**
 * 
 */
package com.app.ecclesiamainframe.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ecclesiamainframe.entity.DcaCourses;


/**
 * @author Harry
 *
 */
@Repository
public interface DcaCoursesDao extends JpaRepository<DcaCourses, Long>{
	List<DcaCourses> findByCourseName(String courseName);
}
