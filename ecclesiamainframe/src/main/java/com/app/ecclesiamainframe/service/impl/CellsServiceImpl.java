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

import com.app.ecclesiamainframe.dao.CellsDao;
import com.app.ecclesiamainframe.entity.Cells;
import com.app.ecclesiamainframe.service.CellsService;
/**
 * @author Harry
 *
 */
@Service
public class CellsServiceImpl implements CellsService {
	Session session = null;
    Transaction transaction = null;
	@Autowired
	private CellsDao cellsDao;
	
	public CellsServiceImpl() {
		super();
	}
	

	@Transactional
	public Optional<Cells> getCell(Long cellId) {
		// TODO Auto-generated method stub
		return cellsDao.findById(cellId);
	}

	@Transactional
	public void deleteCells(Long cellId) {
		// TODO Auto-generated method stub
		cellsDao.deleteById(cellId);
	}

	@Transactional
	public Cells saveCell(Cells cell) {
		return cellsDao.save(cell);
	}

	@Transactional
	public Cells updateCells(Cells cell) {
		return cellsDao.saveAndFlush(cell);
	}

	@Transactional
	public List<Cells> getCells() {
		 return cellsDao.findAll();
	}

}
