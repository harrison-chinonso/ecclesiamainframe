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

import com.app.ecclesiamainframe.dao.DcaStudentsDao;
import com.app.ecclesiamainframe.entity.DcaStudents;
import com.app.ecclesiamainframe.service.DcaStudentsService;
/**
 * @author Harry
 *
 */
@Service
public class DcaStudentsServiceImpl implements DcaStudentsService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private DcaStudentsDao dcaStudentsDao;
	
	public DcaStudentsServiceImpl() {
		super();
	}   

	@Transactional
	public DcaStudents saveDcaStudent(DcaStudents dcaStudent) {
		return dcaStudentsDao.save(dcaStudent);
	}

	@Transactional
	public DcaStudents updateDcaStudents(DcaStudents dcaStudent) {
		return dcaStudentsDao.saveAndFlush(dcaStudent);
	}

	@Transactional
	public List<DcaStudents> getDcaStudents() {
		return dcaStudentsDao.findAll();	
	}

	@Transactional
	public Optional<DcaStudents> getDcaStudent(Long studentId) {
		return dcaStudentsDao.findById(studentId);
	}

	@Transactional
	public void deleteDcaStudent(Long studentId) {
		dcaStudentsDao.deleteById(studentId);
	}

}
