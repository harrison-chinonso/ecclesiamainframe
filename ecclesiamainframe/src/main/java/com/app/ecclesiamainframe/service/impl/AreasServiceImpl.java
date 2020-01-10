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

import com.app.ecclesiamainframe.dao.AreasDao;
import com.app.ecclesiamainframe.entity.Areas;
import com.app.ecclesiamainframe.service.AreasService;
import com.app.ecclesiamainframe.util.HibernateUtil;
/**
 * @author Harry
 *
 */
@Service
public class AreasServiceImpl implements AreasService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private AreasDao areasDao;
	
	public AreasServiceImpl() {
		super();
	}

	@Transactional
	public Areas saveArea(Areas area) {
		return areasDao.save(area);
	}

	@Transactional
	public Areas updateArea(Areas area) {
		return areasDao.saveAndFlush(area);
	}

	@Transactional
	public List<Areas> getAreas() {
		return areasDao.findAll();
	}

	@Transactional
	public Optional<Areas> getArea(Long areaId) {
		return areasDao.findById(areaId);
	}

	@Transactional
	public void deleteArea(Long areaId) {
		areasDao.deleteById(areaId);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Areas> findByAreaname(String areaName) {
	  List<Areas> areas = null;
		try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	       
	      // Native query selecting all columns
	         Query query = session.createNativeQuery("SELECT * FROM areas_tb where areaName like :areaname","AreaMapping")
	        		 .setParameter("areaname","%"+areaName+"%"); //named parameter binding 
	         areas = query.getResultList();
	         transaction.commit(); 
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }
	     // HibernateUtil.shutdown();
	      return areas;
	}

}
