/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.DcaCourses;

/**
 * @author Harry
 *
 */
@Service
public interface DcaCoursesService {
	
	DcaCourses saveDcaCourse(DcaCourses dcaCourse);
	
	DcaCourses updateDcaCourse(DcaCourses dcaCourse);
	
	List<DcaCourses> getDcaCourses();
	
	Optional<DcaCourses> getDcaCourse(Long courseId);
	
	void deleteDcaCourse(Long courseId);

	List<DcaCourses> findByCoursename(String courseName);
}
