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

import com.app.ecclesiamainframe.dao.AreasDao;
import com.app.ecclesiamainframe.entity.Areas;
import com.app.ecclesiamainframe.service.AreasService;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/area")
public class AreasController {
	Areas mem = new Areas();
	
	@Autowired
	private AreasService areasService;
	
	@SuppressWarnings("unused")
	@Autowired
	private AreasDao areasDao;
	
	 @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public Areas save(@RequestBody Areas Area) {
		return areasService.saveArea(Area);
	}
	
	 @PutMapping(path= "/update")
	public Areas update(@RequestBody Areas Area) {
		return areasService.updateArea(Area);
	}
	
	 @GetMapping(path="/list")
	 @ResponseBody
	public List<Areas> getAreas(){
		return areasService.getAreas();
	}
	
	@GetMapping(path="/{AreaId}", produces = "application/json")
	public Optional<Areas> getArea(@PathVariable(name = "AreaId") Long AreaId) {
		return areasService.getArea(AreaId);
	}
	
	@GetMapping(path="name/{AreaName}", produces = "application/json")
	public List<Areas> getArea(@PathVariable(name = "AreaName") String AreaName) {	
		return areasService.findByAreaname(AreaName);
	}
	
	
	@DeleteMapping("/delete/{AreaId}")
	public void deleteArea(@PathVariable(name = "AreaId") Long AreaId) {
		areasService.deleteArea(AreaId);
	}
	
}
