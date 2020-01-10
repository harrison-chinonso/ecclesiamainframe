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

import com.app.ecclesiamainframe.dao.DcaCoursesDao;
import com.app.ecclesiamainframe.entity.DcaCourses;
import com.app.ecclesiamainframe.service.DcaCoursesService;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/dca/course")
public class DcaCoursesController {
	DcaCourses dca = new DcaCourses();
	
	@Autowired
	private DcaCoursesService DcaCoursesService;
	
	@SuppressWarnings("unused")
	@Autowired
	private DcaCoursesDao DcaCoursesDao;
	
	 @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public DcaCourses save(@RequestBody DcaCourses DcaCourse) {
		return DcaCoursesService.saveDcaCourse(DcaCourse);
	}
	
	 @PutMapping(path= "/update")
	public DcaCourses update(@RequestBody DcaCourses DcaCourse) {
		return DcaCoursesService.updateDcaCourse(DcaCourse);
	}
	
	 @GetMapping(path="/list")
	 @ResponseBody
	public List<DcaCourses> getDcaCourses(){
		return DcaCoursesService.getDcaCourses();
	}
	
	@GetMapping(path="/{DcaCourseId}", produces = "application/json")
	public Optional<DcaCourses> getDcaCourse(@PathVariable(name = "DcaCourseId") Long DcaCourseId) {
		return DcaCoursesService.getDcaCourse(DcaCourseId);
	}
	
	@GetMapping(path="name/{DcaCourseName}", produces = "application/json")
	public List<DcaCourses> getDcaCourse(@PathVariable(name = "DcaCourseName") String DcaCourseName) {	
		return DcaCoursesService.findByCoursename(DcaCourseName);
	}
	
	@DeleteMapping("/delete/{DcaCourseId}")
	public void deleteDcaCourse(@PathVariable(name = "DcaCourseId") Long DcaCourseId) {
		DcaCoursesService.deleteDcaCourse(DcaCourseId);
	}
	
}
