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

import com.app.ecclesiamainframe.dao.DcaLevelsDao;
import com.app.ecclesiamainframe.entity.DcaLevels;
import com.app.ecclesiamainframe.service.DcaLevelsService;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/dca/level")
public class DcaLevelsController {
	DcaLevels dca = new DcaLevels();
	
	@Autowired
	private DcaLevelsService DcaLevelsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private DcaLevelsDao DcaLevelsDao;
	
	 @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public DcaLevels save(@RequestBody DcaLevels DcaLevel) {
		return DcaLevelsService.saveDcaLevel(DcaLevel);
	}
	
	 @PutMapping(path= "/update")
	public DcaLevels update(@RequestBody DcaLevels DcaLevel) {
		return DcaLevelsService.updateDcaLevels(DcaLevel);
	}
	
	 @GetMapping(path="/list")
	 @ResponseBody
	public List<DcaLevels> getDcaLevels(){
		return DcaLevelsService.getDcaLevels();
	}
	
	@GetMapping(path="/{DcaLevelId}", produces = "application/json")
	public Optional<DcaLevels> getDcaLevel(@PathVariable(name = "DcaLevelId") Long DcaLevelId) {
		return DcaLevelsService.getDcaLevel(DcaLevelId);
	}
	
	@GetMapping(path="name/{DcaLevelName}", produces = "application/json")
	public List<DcaLevels> getDcaLevel(@PathVariable(name = "DcaLevelName") String DcaLevelName) {	
		return DcaLevelsService.findByDcaLevelname(DcaLevelName);
	}
	
	
	@DeleteMapping("/delete/{DcaLevelId}")
	public void deleteDcaLevel(@PathVariable(name = "DcaLevelId") Long DcaLevelId) {
		DcaLevelsService.deleteDcaLevel(DcaLevelId);
	}
	
}
