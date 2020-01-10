/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.AreaReports;

/**
 * @author Harry
 *
 */
@Service
public interface AreaReportsService {
	
	AreaReports saveAreaReport(AreaReports areaReport);
	
	AreaReports updateAreaReport(AreaReports areaReport);
	
	List<AreaReports> getAreaReports();
	
	Optional<AreaReports> getAreaReport(Long areaReportId);
	
	void deleteAreaReport(Long areaReportId);

	//List<AreaReports> findByMembername(String memberName);
}
