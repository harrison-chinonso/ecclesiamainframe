/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.DcaLevels;

/**
 * @author Harry
 *
 */
@Service
public interface DcaLevelsService {
	
	DcaLevels saveDcaLevel(DcaLevels dcaLevel);
	
	DcaLevels updateDcaLevels(DcaLevels dcaLevel);
	
	List<DcaLevels> getDcaLevels();
	
	Optional<DcaLevels> getDcaLevel(Long levelId);
	
	void deleteDcaLevel(Long levelId);

	List<DcaLevels> findByDcaLevelname(String dcaName);
}
