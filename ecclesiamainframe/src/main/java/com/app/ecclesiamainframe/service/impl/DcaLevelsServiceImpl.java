/**
 * 
 */
package com.app.ecclesiamainframe.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.dao.DcaLevelsDao;
import com.app.ecclesiamainframe.entity.DcaLevels;
import com.app.ecclesiamainframe.service.DcaLevelsService;
import com.app.ecclesiamainframe.util.HibernateUtil;
/**
 * @author Harry
 *
 */
@Service
public class DcaLevelsServiceImpl implements DcaLevelsService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private DcaLevelsDao dcaLevelsDao;
	
	public DcaLevelsServiceImpl() {
		super();
	}   

	@Transactional
	public DcaLevels saveDcaLevel(DcaLevels dcaLevel) {
		return dcaLevelsDao.save(dcaLevel);
	}

	@Transactional
	public DcaLevels updateDcaLevels(DcaLevels dcaLevel) {
		return dcaLevelsDao.saveAndFlush(dcaLevel);
	}

	@Transactional
	public List<DcaLevels> getDcaLevels() {
		return dcaLevelsDao.findAll();
	}

	@Transactional
	public Optional<DcaLevels> getDcaLevel(Long levelId) {
		return dcaLevelsDao.findById(levelId);
	}

	@Transactional
	public void deleteDcaLevel(Long levelId) {
		dcaLevelsDao.deleteById(levelId);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DcaLevels> findByDcaLevelname(String dcaName) {
		 List<DcaLevels> dcaLevels = null;
			try {
		         session = HibernateUtil.getSessionFactory().openSession();
		         transaction = session.beginTransaction();
		       
		      // Native query selecting all columns
		         Query query = session.createNativeQuery("SELECT * FROM dcaLevels_tb where dcaName like :DcaName","DCALevelsMapping")
		        		 .setParameter("DcaName","%"+dcaName+"%"); //named parameter binding 
		         dcaLevels = query.getResultList();
		         transaction.commit(); 
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         if (session != null) {
		            session.close();
		         }
		      }
		     // HibernateUtil.shutdown();
		      return dcaLevels;
	}

}
