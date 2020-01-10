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

import com.app.ecclesiamainframe.dao.MembersDao;
import com.app.ecclesiamainframe.entity.Members;
import com.app.ecclesiamainframe.service.MembersService;
import com.app.ecclesiamainframe.util.HibernateUtil;
/**
 * @author Harry
 *
 */
@Service
public class MembersServiceImpl implements MembersService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private MembersDao membersDao;
	
	public MembersServiceImpl() {
		super();
	}
	
	@Transactional
	public Members saveMember(Members member) {
		// TODO Auto-generated method stub
		return membersDao.save(member);
	}

	@Transactional
	public Members updateMembers(Members member) {
		// TODO Auto-generated method stub
		return membersDao.saveAndFlush(member);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Members> findByMembername(String memberName) 
	{
		//return membersDao.findByMemberName(memberName);
		 List<Members> members = null;
		try {
	         session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.beginTransaction();
	       
	      // Native query selecting all columns
	         Query query = session.createNativeQuery("SELECT * FROM members_tb where memberName like :memberName","MemberMapping")
	        		 .setParameter("memberName","%"+memberName+"%"); //named parameter binding 
	        		members = query.getResultList();
	         transaction.commit(); 
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }
	     // HibernateUtil.shutdown();
	      return members;
	}   

	@Transactional
	public List<Members> getMembers() {
		// TODO Auto-generated method stub
		return membersDao.findAll();
	}

	@Transactional
	public Optional<Members> getMember(Long memberId) {
		// TODO Auto-generated method stub
		return membersDao.findById(memberId);
	}

	@Transactional
	public void deleteMember(Long memberId) {
		// TODO Auto-generated method stub
		membersDao.deleteById(memberId);
	}

}
