/**
 * 
 */
package com.app.ecclesiamainframe.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.dao.AreaReportsDao;
import com.app.ecclesiamainframe.entity.AreaReports;
import com.app.ecclesiamainframe.service.AreaReportsService;
/**
 * @author Harry
 *
 */
@Service
public class AreaReportsServiceImpl implements AreaReportsService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private AreaReportsDao areaReportsDao;
	
	public AreaReportsServiceImpl() {
		super();
	}

	@Transactional
	public AreaReports saveAreaReport(AreaReports areaReport) {
		return areaReportsDao.save(areaReport);
	}

	@Transactional
	public AreaReports updateAreaReport(AreaReports areaReport) {
		// TODO Auto-generated method stub
		return areaReportsDao.saveAndFlush(areaReport);
	}

	@Transactional
	public List<AreaReports> getAreaReports() {
		return areaReportsDao.findAll();
	}

	@Transactional
	public Optional<AreaReports> getAreaReport(Long areaReportId) {
		return areaReportsDao.findById(areaReportId);
	}

	@Transactional
	public void deleteAreaReport(Long areaReportId) {
		areaReportsDao.deleteById(areaReportId);
	}

}
