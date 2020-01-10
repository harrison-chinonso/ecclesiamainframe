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

import com.app.ecclesiamainframe.dao.CellReportsDao;
import com.app.ecclesiamainframe.entity.CellReports;
import com.app.ecclesiamainframe.service.CellReportsService;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/cell/report")
public class CellReportsController {
	CellReports report = new CellReports();
	
	@Autowired
	private CellReportsService CellReportsService;
	
	@SuppressWarnings("unused")
	@Autowired
	private CellReportsDao CellReportsDao;
	
	 @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public CellReports save(@RequestBody CellReports CellReport) {
		return CellReportsService.saveCellReport(CellReport);
	}
	
	 @PutMapping(path= "/update")
	public CellReports update(@RequestBody CellReports CellReport) {
		return CellReportsService.updateCellReports(CellReport);
	}
	
	 @GetMapping(path="/list")
	 @ResponseBody
	public List<CellReports> getCellReports(){
		return CellReportsService.getCellReports();
	}
	
	@GetMapping(path="/{CellReportId}", produces = "application/json")
	public Optional<CellReports> getCellReport(@PathVariable(name = "CellReportId") Long CellReportId) {
		return CellReportsService.getCellReport(CellReportId);
	}
	
	@DeleteMapping("/delete/{CellReportId}")
	public void deleteCellReport(@PathVariable(name = "CellReportId") Long CellReportId) {
		CellReportsService.deleteCellReport(CellReportId);
	}
	
}
