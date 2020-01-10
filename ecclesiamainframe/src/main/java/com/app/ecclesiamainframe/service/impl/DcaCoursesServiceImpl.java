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

import com.app.ecclesiamainframe.dao.DcaCoursesDao;
import com.app.ecclesiamainframe.entity.DcaCourses;
import com.app.ecclesiamainframe.service.DcaCoursesService;
import com.app.ecclesiamainframe.util.HibernateUtil;
/**
 * @author Harry
 *
 */
@Service
public class DcaCoursesServiceImpl implements DcaCoursesService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private DcaCoursesDao dcaCoursesDao;
	
	public DcaCoursesServiceImpl() {
		super();
	}   


	@Transactional
	public DcaCourses saveDcaCourse(DcaCourses dcaCourse) {
		return dcaCoursesDao.save(dcaCourse);
	}

	@Transactional
	public DcaCourses updateDcaCourses(DcaCourses dcaCourse) {
		return dcaCoursesDao.saveAndFlush(dcaCourse);
	}

	@Transactional
	public List<DcaCourses> getDcaCourses() {
		return dcaCoursesDao.findAll();
	}

	@Transactional
	public Optional<DcaCourses> getDcaCourse(Long courseId) {
		return dcaCoursesDao.findById(courseId);
	}

	@Transactional
	public void deleteDcaCourse(Long courseId) {
		dcaCoursesDao.deleteById(courseId);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<DcaCourses> findByCoursename(String courseName) {
	 List<DcaCourses> dcaCourses = null;
		try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	       
	      // Native query selecting all columns
	         Query query = session.createNativeQuery("SELECT * FROM dcaCourses_tb where courseName like :CourseName","DcaCoursesMapping")
	        		 .setParameter("CourseName","%"+courseName+"%"); //named parameter binding 
	         dcaCourses = query.getResultList();
	         transaction.commit(); 
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }
	     // HibernateUtil.shutdown();
	     return dcaCourses;
	}


	@Override
	public DcaCourses updateDcaCourse(DcaCourses dcaCourse) {
		return dcaCoursesDao.saveAndFlush(dcaCourse);
	}

}
