/**
 * 
 */
package com.app.ecclesiamainframe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.ecclesiamainframe.dao.DcaStudentsDao;
import com.app.ecclesiamainframe.entity.DcaStudents;
import com.app.ecclesiamainframe.service.DcaStudentsService;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/dca/student")
public class DcaStudentsController {
	DcaStudents dca = new DcaStudents();
	
	@Autowired
	private DcaStudentsService DcaStudentsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private DcaStudentsDao DcaStudentsDao;
	
	 @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public DcaStudents save(@RequestBody DcaStudents DcaStudent) {
		return DcaStudentsService.saveDcaStudent(DcaStudent);
	}
	
	 @PutMapping(path= "/update")
	public DcaStudents update(@RequestBody DcaStudents DcaStudent) {
		return DcaStudentsService.updateDcaStudents(DcaStudent);
	}
	
	 @GetMapping(path="/list")
	 @ResponseBody
	public List<DcaStudents> getDcaStudents(){
		return DcaStudentsService.getDcaStudents();
	}
	
	@GetMapping(path="/{DcaStudentId}", produces = "application/json")
	public Optional<DcaStudents> getDcaStudent(@PathVariable(name = "DcaStudentId") Long DcaStudentId) {
		return DcaStudentsService.getDcaStudent(DcaStudentId);
	}
	
	@DeleteMapping("/delete/{DcaStudentId}")
	public void deleteDcaStudent(@PathVariable(name = "DcaStudentId") Long DcaStudentId) {
		DcaStudentsService.deleteDcaStudent(DcaStudentId);
	}
	
}
