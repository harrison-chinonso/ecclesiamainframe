/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.CellReports;

/**
 * @author Harry
 *
 */
@Service
public interface CellReportsService {
	
	CellReports saveCellReport(CellReports cellReport);
	
	CellReports updateCellReports(CellReports cellReport);
	
	List<CellReports> getCellReports();
	
	Optional<CellReports> getCellReport(Long cellReportId);
	
	void deleteCellReport(Long cellReportId);

	//List<Members> findByMembername(String memberName);
}
