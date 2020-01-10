/**
 * 
 */
package com.app.ecclesiamainframe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.ecclesiamainframe.entity.Members;

/**
 * @author Harry
 *
 */
@Service
public interface MembersService {
	
	Members saveMember(Members member);
	
	Members updateMembers(Members member);
	
	List<Members> getMembers();
	
	Optional<Members> getMember(Long memberId);
	
	void deleteMember(Long memberId);

	List<Members> findByMembername(String memberName);
}
