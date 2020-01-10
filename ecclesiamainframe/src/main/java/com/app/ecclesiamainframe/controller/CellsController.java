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

import com.app.ecclesiamainframe.dao.CellsDao;
import com.app.ecclesiamainframe.entity.Cells;
import com.app.ecclesiamainframe.service.CellsService;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/cell")
public class CellsController {
	Cells cell = new Cells();
	
	@Autowired
	private CellsService CellsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private CellsDao CellsDao;
	
	 @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public Cells save(@RequestBody Cells cell) {
		return CellsService.saveCell(cell);
	}
	
	 @PutMapping(path= "/update")
	public Cells update(@RequestBody Cells cell) {
		return CellsService.updateCells(cell);
	}
	
	 @GetMapping(path="/list")
	 @ResponseBody
	public List<Cells> getCells(){
		return CellsService.getCells();
	}
	
	@GetMapping(path="/{CellId}", produces = "application/json")
	public Optional<Cells> getCell(@PathVariable(name = "CellId") Long CellId) {
		return CellsService.getCell(CellId);
	}
	
	@DeleteMapping("/delete/{CellId}")
	public void deleteCell(@PathVariable(name = "CellId") Long CellId) {
		CellsService.deleteCells(CellId);
	}
	
}
