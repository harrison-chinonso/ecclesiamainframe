/**
 * 
 */
package com.app.ecclesiamainframe.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.ecclesiamainframe.dao.MembersDao;
import com.app.ecclesiamainframe.entity.Members;
import com.app.ecclesiamainframe.service.MembersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Harry
 *
 */
@RestController
@RequestMapping("/api/member")
@Api(value="Religious Organisation Management REST API", description="Operations pertaining to Members Of Religious Organisation")
public class MembersController {
	Members mem = new Members();
	
	@Autowired
	private MembersService membersService;
	
	@SuppressWarnings("unused")
	@Autowired
	private MembersDao membersDao;
	
	@ApiOperation(value = "Add a Member")
	@PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
	public Members save(@ApiParam(value = "Member object store in database table", required = true) @Valid @RequestBody Members member) {
		return membersService.saveMember(member);
	}
	
	@ApiOperation(value = "Update a Member's Information")
	@PutMapping(path= "/update")
	public Members update(@RequestBody Members member) {
		return membersService.updateMembers(member);
	}
	
	@ApiOperation(value = "View a list of available Members", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/list")
	@ResponseBody
	public List<Members> getMembers(){
		 List<Members> resp = membersService.getMembers();
		 return resp;
	}
	
	@ApiOperation(value = "View an available Member by Id", response = Optional.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="/{memberId}", produces = "application/json")
	public Optional<Members> getMember(@PathVariable(name = "memberId") Long memberId) {
		return membersService.getMember(memberId);
	}
	
	@ApiOperation(value = "View an available Member by name", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(path="name/{memberName}", produces = "application/json")
	public List<Members> getMember(@PathVariable(name = "memberName") String memberName) {	
		return membersService.findByMembername(memberName);
	}
	
	@ApiOperation(value = "Delete an available Member by Id")
	@DeleteMapping("/delete/{memberId}")
	public void deleteMember(@PathVariable(name = "memberId") Long memberId) {
		membersService.deleteMember(memberId);
	}
	
}
