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

import com.app.ecclesiamainframe.dao.DcaLevelsDao;
import com.app.ecclesiamainframe.entity.DcaLevels;
import com.app.ecclesiamainframe.service.DcaLevelsService;

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
@RequestMapping("/api/dca/level")
@Api(value="Religious Organisation Management REST API", description="Operations pertaining to Levels attainable in Religious Organisations Institution")
public class DcaLevelsController {
	DcaLevels dca = new DcaLevels();
	
	@Autowired
	private DcaLevelsService DcaLevelsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private DcaLevelsDao DcaLevelsDao;
	
	@ApiOperation(value = "Add a Dca Level")
	@PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public DcaLevels save(@ApiParam(value = "Dca Level object store in database table", required = true) @Valid @RequestBody DcaLevels DcaLevel) {
		return DcaLevelsService.saveDcaLevel(DcaLevel);
	}
	
	@ApiOperation(value = "Update a Dca Level")
	@PutMapping(path= "/update")
	public DcaLevels update(@RequestBody DcaLevels DcaLevel) {
		return DcaLevelsService.updateDcaLevels(DcaLevel);
	}
	
	@ApiOperation(value = "View a list of available Dca Levels", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/list")
	@ResponseBody
	public List<DcaLevels> getDcaLevels(){
		return DcaLevelsService.getDcaLevels();
	}
	
	@ApiOperation(value = "View an available Dca Level by Id", response = Optional.class)
		@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
		})
	@GetMapping(path="/{DcaLevelId}", produces = "application/json")
	public Optional<DcaLevels> getDcaLevel(@PathVariable(name = "DcaLevelId") Long DcaLevelId) {
		return DcaLevelsService.getDcaLevel(DcaLevelId);
	}
	
	@ApiOperation(value = "View an available Dca Level by name", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="name/{DcaLevelName}", produces = "application/json")
	public List<DcaLevels> getDcaLevel(@PathVariable(name = "DcaLevelName") String DcaLevelName) {	
		return DcaLevelsService.findByDcaLevelname(DcaLevelName);
	}
	
	@ApiOperation(value = "Delete an available Dca Level by Id")
	@DeleteMapping("/delete/{DcaLevelId}")
	public void deleteDcaLevel(@PathVariable(name = "DcaLevelId") Long DcaLevelId) {
		DcaLevelsService.deleteDcaLevel(DcaLevelId);
	}
	
}
