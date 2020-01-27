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

import com.app.ecclesiamainframe.dao.AreasDao;
import com.app.ecclesiamainframe.entity.Areas;
import com.app.ecclesiamainframe.service.AreasService;

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
@RequestMapping("/api/area")
@Api(value="Religious Organisation Management REST API", description="Operations pertaining to Members residing in a particular Residential Areas")

public class AreasController {
	Areas area = new Areas();
	
	@Autowired
	private AreasService areasService;
	
	@SuppressWarnings("unused")
	@Autowired
	private AreasDao areasDao;
	
	@ApiOperation(value = "Add an area")
	@PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public Areas save(@ApiParam(value = "Area object store in database table", required = true) @Valid @RequestBody Areas Area) {
		return areasService.saveArea(Area);
	}
	
	@ApiOperation(value = "Update an area's information")
	@PutMapping(path= "/update")
	public Areas update(@RequestBody Areas Area) {
		return areasService.updateArea(Area);
	}
	
	@ApiOperation(value = "View a list of available areas", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/list")
	@ResponseBody
	public List<Areas> getAreas(){
		return areasService.getAreas();
	}
	
	@ApiOperation(value = "View an available area by Id", response = Optional.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/{AreaId}", produces = "application/json")
	public Optional<Areas> getArea(@PathVariable(name = "AreaId") Long AreaId) {
		return areasService.getArea(AreaId);
	}
	
	@ApiOperation(value = "View an available area by Name", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="name/{AreaName}", produces = "application/json")
	public List<Areas> getArea(@PathVariable(name = "AreaName") String AreaName) {	
		return areasService.findByAreaname(AreaName);
	}
	
	@ApiOperation(value = "Delete an available area by Id")
	@DeleteMapping("/delete/{AreaId}")
	public void deleteArea(@PathVariable(name = "AreaId") Long AreaId) {
		areasService.deleteArea(AreaId);
	}
	
}
