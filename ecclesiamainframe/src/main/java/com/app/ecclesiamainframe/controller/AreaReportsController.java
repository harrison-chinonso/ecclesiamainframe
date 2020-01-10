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

import com.app.ecclesiamainframe.dao.AreaReportsDao;
import com.app.ecclesiamainframe.entity.AreaReports;
import com.app.ecclesiamainframe.service.AreaReportsService;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/area/report") 
public class AreaReportsController {
	AreaReports report = new AreaReports();
	
	@Autowired
	private AreaReportsService areaReportsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private AreaReportsDao areaReportsDao;
	
	 @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public AreaReports save(@RequestBody AreaReports AreaReport) {
		return areaReportsService.saveAreaReport(AreaReport);
	}
	
	 @PutMapping(path= "/update")
	public AreaReports update(@RequestBody AreaReports AreaReport) {
		return areaReportsService.updateAreaReport(AreaReport);
	}
	
	 @GetMapping(path="/list")
	 @ResponseBody
	public List<AreaReports> getAreaReports(){
		return areaReportsService.getAreaReports();
	}
	
	@GetMapping(path="/{AreaReportId}", produces = "application/json")
	public Optional<AreaReports> getAreaReport(@PathVariable(name = "AreaReportId") Long AreaReportId) {
		return areaReportsService.getAreaReport(AreaReportId);
	}
	
	@DeleteMapping("/delete/{AreaReportId}")
	public void deleteAreaReport(@PathVariable(name = "AreaReportId") Long AreaReportId) {
		areaReportsService.deleteAreaReport(AreaReportId);
	}
	
}
