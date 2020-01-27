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

import com.app.ecclesiamainframe.dao.DcaStudentsDao;
import com.app.ecclesiamainframe.entity.DcaStudents;
import com.app.ecclesiamainframe.service.DcaStudentsService;

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
@RequestMapping("/api/dca/student")
@Api(value="Religious Organisation Management REST API", description="Operations pertaining to Students Enrolled in Religious Organisation's Institution")
public class DcaStudentsController {
	DcaStudents dca = new DcaStudents();
	
	@Autowired
	private DcaStudentsService DcaStudentsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private DcaStudentsDao DcaStudentsDao;
	
	@ApiOperation(value = "Add a Dca Student")
	@PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public DcaStudents save(@ApiParam(value = "Dca Student object store in database table", required = true) @Valid @RequestBody DcaStudents DcaStudent) {
		return DcaStudentsService.saveDcaStudent(DcaStudent);
	}
	
	@ApiOperation(value = "Update a Dca Student")
	@PutMapping(path= "/update")
	public DcaStudents update(@RequestBody DcaStudents DcaStudent) {
		return DcaStudentsService.updateDcaStudents(DcaStudent);
	}
	
	@ApiOperation(value = "View a list of available Dca Students", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/list")
	@ResponseBody
	public List<DcaStudents> getDcaStudents(){
		return DcaStudentsService.getDcaStudents();
	}
	
	@ApiOperation(value = "View an available Dca Student by Id", response = Optional.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/{DcaStudentId}", produces = "application/json")
	public Optional<DcaStudents> getDcaStudent(@PathVariable(name = "DcaStudentId") Long DcaStudentId) {
		return DcaStudentsService.getDcaStudent(DcaStudentId);
	}
	
	@ApiOperation(value = "Delete an available Dca Student by Id")
	@DeleteMapping("/delete/{DcaStudentId}")
	public void deleteDcaStudent(@PathVariable(name = "DcaStudentId") Long DcaStudentId) {
		DcaStudentsService.deleteDcaStudent(DcaStudentId);
	}
	
}
