/**
 * 
 */
package com.app.ecclesiamainframe.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/dca/course")
@Api(value="Religious Organisation Management REST API", description="Operations pertaining to available Courses in Religious Organisation's Institution")
public class DcaCoursesController {
	DcaCourses dca = new DcaCourses();
	
	@Autowired
	private DcaCoursesService DcaCoursesService;
	
	@SuppressWarnings("unused")
	@Autowired
	private DcaCoursesDao DcaCoursesDao;
	
	@ApiOperation(value = "Add a Dca Course")
	@PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public DcaCourses save(@ApiParam(value = "Dca Course object store in database table", required = true) @Valid @RequestBody DcaCourses DcaCourse) {
		return DcaCoursesService.saveDcaCourse(DcaCourse);
	}
	
	@ApiOperation(value = "Update a Dca Course information")
	@PutMapping(path= "/update")
	public DcaCourses update(@RequestBody DcaCourses DcaCourse) {
		return DcaCoursesService.updateDcaCourse(DcaCourse);
	}
	
	@ApiOperation(value = "View a list of available Dca Courses", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/list")
	@ResponseBody
	public List<DcaCourses> getDcaCourses(){
		return DcaCoursesService.getDcaCourses();
	}
	
	@ApiOperation(value = "View an available Dca Course by Id", response = Optional.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/{DcaCourseId}", produces = "application/json")
	public Optional<DcaCourses> getDcaCourse(@PathVariable(name = "DcaCourseId") Long DcaCourseId) {
		return DcaCoursesService.getDcaCourse(DcaCourseId);
	}
	
	@ApiOperation(value = "View an available Dca Course by name", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="name/{DcaCourseName}", produces = "application/json")
	public List<DcaCourses> getDcaCourse(@PathVariable(name = "DcaCourseName") String DcaCourseName) {	
		return DcaCoursesService.findByCoursename(DcaCourseName);
	}
	
	@ApiOperation(value = "Delete an available Dca Course by Id")
	@DeleteMapping("/delete/{DcaCourseId}")
	public void deleteDcaCourse(@PathVariable(name = "DcaCourseId") Long DcaCourseId) {
		DcaCoursesService.deleteDcaCourse(DcaCourseId);
	}
	
}
