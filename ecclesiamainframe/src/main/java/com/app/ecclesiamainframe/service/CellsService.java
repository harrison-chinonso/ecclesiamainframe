/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.Cells;

/**
 * @author Harry
 *
 */
@Service
public interface CellsService {
	
	Cells saveCell(Cells cell);
	
	Cells updateCells(Cells cell);
	
	List<Cells> getCells();
	
	Optional<Cells> getCell(Long cellId);
	
	void deleteCells(Long cellId);

	//List<Cells> findByMembername(String cell);
}
