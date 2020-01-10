/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.Areas;

/**
 * @author Harry
 *
 */
@Service
public interface AreasService {
	
	Areas saveArea(Areas area);
	
	Areas updateArea(Areas area);
	
	List<Areas> getAreas();
	
	Optional<Areas> getArea(Long areaId);
	
	void deleteArea(Long areaId);

	List<Areas> findByAreaname(String areaName);
}
