/**
 * 
 */
package com.app.ecclesiamainframe.entity;

import java.io.Serializable;

import javax.persistence.Column;
//import javax.persistence.ColumnResult;
//import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="dcaStudents_tb")
@ApiModel(description = "All details about the Dca Stdents.")
@Data
public class DcaStudents implements Serializable {
	
		/**
	 * 
	 */
	public DcaStudents() {}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="studentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated student Id")
	private Long studentId;
	
	@Column(name="memberId")
	@ApiModelProperty(notes = "The student's membership id")
	private Long memberId;
	
	@Column(name="score")
	@ApiModelProperty(notes = "The student's score in a particular dca exams")
	private Long score;
	
	@Column(name="dcaCourseId")
	@ApiModelProperty(notes = "The reference id of course attended by student ")
	private Long dcaCourseId;
	
	@Column(name="levelId")
	@ApiModelProperty(notes = "The reference id of level attended by student")
	private Long levelId;
	
	
	public DcaStudents(Long studentId,Long memberId, Long score, Long dcaCourseId,Long levelId) {
		this.studentId = studentId;
		this.memberId = memberId;
		this.score = score;
		this.dcaCourseId = dcaCourseId;
		this.levelId = levelId;
	}
		
}



