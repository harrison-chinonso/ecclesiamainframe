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

import com.app.ecclesiamainframe.dao.CellReportsDao;
import com.app.ecclesiamainframe.entity.CellReports;
import com.app.ecclesiamainframe.service.CellReportsService;

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
@RequestMapping("/api/cell/report")
@Api(value="Religious Organisation Management REST API", description="Operations pertaining to Reports on Cells holding in a particular Residential Areas")
public class CellReportsController {
	CellReports report = new CellReports();
	
	@Autowired
	private CellReportsService CellReportsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private CellReportsDao CellReportsDao;
	
	@ApiOperation(value = "Add an cell report")
	@PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public CellReports save(@ApiParam(value = "Cell report object store in database table", required = true) @Valid @RequestBody CellReports CellReport) {
		return CellReportsService.saveCellReport(CellReport);
	}
	
	@ApiOperation(value = "Update a cell report information")
	@PutMapping(path= "/update")
	public CellReports update(@RequestBody CellReports CellReport) {
		return CellReportsService.updateCellReports(CellReport);
	}
	
	@ApiOperation(value = "View a list of available cell reports", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/list")
	@ResponseBody
	public List<CellReports> getCellReports(){
		return CellReportsService.getCellReports();
	}
	
	@ApiOperation(value = "View an available cell reports by Id", response = Optional.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/{CellReportId}", produces = "application/json")
	public Optional<CellReports> getCellReport(@PathVariable(name = "CellReportId") Long CellReportId) {
		return CellReportsService.getCellReport(CellReportId);
	}
	
	@ApiOperation(value = "Delete an available cell Report by Id")
	@DeleteMapping("/delete/{CellReportId}")
	public void deleteCellReport(@PathVariable(name = "CellReportId") Long CellReportId) {
		CellReportsService.deleteCellReport(CellReportId);
	}
	
}
