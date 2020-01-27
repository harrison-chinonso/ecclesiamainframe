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

import com.app.ecclesiamainframe.dao.AreaReportsDao;
import com.app.ecclesiamainframe.entity.AreaReports;
import com.app.ecclesiamainframe.service.AreaReportsService;

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
@RequestMapping("/api/area/report") 
@Api(value="Religious Organisation Management REST API", description="Operations pertaining to Reports on Members residing in a particular Residential Areas")
public class AreaReportsController {
	AreaReports report = new AreaReports();
	
	@Autowired
	private AreaReportsService areaReportsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private AreaReportsDao areaReportsDao;
	
	@ApiOperation(value = "Add an area report")
	@PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public AreaReports save(@ApiParam(value = "Area Report object store in database table", required = true) @Valid @RequestBody AreaReports AreaReport) {
		return areaReportsService.saveAreaReport(AreaReport);
	}
	
	@ApiOperation(value = "Update an area report")
	@PutMapping(path= "/update")
	public AreaReports update(@RequestBody AreaReports AreaReport) {
		return areaReportsService.updateAreaReport(AreaReport);
	}
	
	@ApiOperation(value = "View a list of available reports", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	 @GetMapping(path="/list")
	 @ResponseBody
	public List<AreaReports> getAreaReports(){
		return areaReportsService.getAreaReports();
	}
	
	@ApiOperation(value = "View an available report by Id", response = Optional.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/{AreaReportId}", produces = "application/json")
	public Optional<AreaReports> getAreaReport(@PathVariable(name = "AreaReportId") Long AreaReportId) {
		return areaReportsService.getAreaReport(AreaReportId);
	}
	
	@ApiOperation(value = "Delete an available report by Id")
	@DeleteMapping("/delete/{AreaReportId}")
	public void deleteAreaReport(@PathVariable(name = "AreaReportId") Long AreaReportId) {
		areaReportsService.deleteAreaReport(AreaReportId);
	}
	
}
