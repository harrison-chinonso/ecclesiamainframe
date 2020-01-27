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

import com.app.ecclesiamainframe.dao.CellsDao;
import com.app.ecclesiamainframe.entity.Cells;
import com.app.ecclesiamainframe.service.CellsService;

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
@RequestMapping("/api/cell")
@Api(value="Religious Organisation Management REST API", description="Operations pertaining to Cells in a particular Residential Areas")
public class CellsController {
	Cells cell = new Cells();
	
	@Autowired
	private CellsService CellsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private CellsDao CellsDao;
	
	@ApiOperation(value = "Add an cell")
	@PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public Cells save(@ApiParam(value = "Cell object store in database table", required = true) @Valid @RequestBody Cells cell) {
		return CellsService.saveCell(cell);
	}
	
	@ApiOperation(value = "Update a cell's information")
	@PutMapping(path= "/update")
	public Cells update(@RequestBody Cells cell) {
		return CellsService.updateCells(cell);
	}
	
	@ApiOperation(value = "View a list of available cells", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/list")
	@ResponseBody
	public List<Cells> getCells(){
		return CellsService.getCells();
	}
	
	@ApiOperation(value = "View an available cell by Id", response = Optional.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/{CellId}", produces = "application/json")
	public Optional<Cells> getCell(@PathVariable(name = "CellId") Long CellId) {
		return CellsService.getCell(CellId);
	}
	
	@ApiOperation(value = "Delete an available cell by Id")
	@DeleteMapping("/delete/{CellId}")
	public void deleteCell(@PathVariable(name = "CellId") Long CellId) {
		CellsService.deleteCells(CellId);
	}
	
}
