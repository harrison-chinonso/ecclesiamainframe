/**
 * 
 */
package com.app.ecclesiamainframe.service.impl;

import java.util.List;
import java.util.Optional;

//import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.dao.CellReportsDao;
import com.app.ecclesiamainframe.entity.CellReports;
import com.app.ecclesiamainframe.service.CellReportsService;
//import com.app.ecclesiamainframe.util.HibernateUtil;
/**
 * @author Harry
 *
 */
@Service
public class CellReportsServiceImpl implements CellReportsService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private CellReportsDao CellReportsDao;
	
	public CellReportsServiceImpl() {
		super();
	}
	
	@Transactional
	public CellReports saveCellReport(CellReports cellReport) {
		// TODO Auto-generated method stub
		return CellReportsDao.save(cellReport);
	}

	@Transactional
	public CellReports updateCellReports(CellReports cellReport) {
		// TODO Auto-generated method stub
		return CellReportsDao.saveAndFlush(cellReport);
	}
	
//	@Transactional
//	@SuppressWarnings("unchecked")
//	public List<CellReports> findByMembername(String memberName) 
//	{
//		//return CellReportsDao.findByMemberName(memberName);
//		 List<CellReports> CellReports = null;
//		try {
//	         session = HibernateUtil.getSessionFactory().openSession();
//	         transaction = session.beginTransaction();
//	       
//	      // Native query selecting all columns
//	         Query query = session.createNativeQuery("SELECT * FROM CellReports_tb where memberName like :memberName","MemberMapping")
//	        		 .setParameter("memberName","%"+memberName+"%"); //named parameter binding 
//	        		CellReports = query.getResultList();
//	         transaction.commit(); 
//	      } catch (Exception e) {
//	         e.printStackTrace();
//	      } finally {
//	         if (session != null) {
//	            session.close();
//	         }
//	      }
//	     // HibernateUtil.shutdown();
//	      return CellReports;
//	}   

	@Transactional
	public List<CellReports> getCellReports() {
		// TODO Auto-generated method stub
		return CellReportsDao.findAll();
	}

	@Transactional
	public Optional<CellReports> getCellReport(Long cellReportId) {
		// TODO Auto-generated method stub
		return CellReportsDao.findById(cellReportId);
	}

	@Transactional
	public void deleteCellReport(Long cellReportId) {
		// TODO Auto-generated method stub
		CellReportsDao.deleteById(cellReportId);
	}

}
