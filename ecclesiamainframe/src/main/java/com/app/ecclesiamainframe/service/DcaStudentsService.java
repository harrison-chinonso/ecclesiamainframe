/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.DcaStudents;

/**
 * @author Harry
 *
 */
@Service
public interface DcaStudentsService {
	
	DcaStudents saveDcaStudent(DcaStudents dcaStudent);
	
	DcaStudents updateDcaStudents(DcaStudents dcaStudent);
	
	List<DcaStudents> getDcaStudents();
	
	Optional<DcaStudents> getDcaStudent(Long studentId);
	
	void deleteDcaStudent(Long studentId);

	//List<DcaStudents> findBydcaStudentname(String dcaStudentName);
}
