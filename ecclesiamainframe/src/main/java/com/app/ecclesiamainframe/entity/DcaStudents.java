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

import lombok.Data;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="dcaStudents_tb")
@Data
//@SqlResultSetMapping(
//	name = "DcaStudentMapping",
//classes = @ConstructorResult(
//    targetClass = DcaStudents.class,
//    columns = {
//        @ColumnResult(name = "studentId", type = Long.class),
//        @ColumnResult(name = "memberId", type = Long.class),
//        @ColumnResult(name = "score", type = Long.class),
//        @ColumnResult(name = "dcaCourseId", type = Long.class),
//        @ColumnResult(name = "levelId", type = Long.class)
//	}))
public class DcaStudents implements Serializable {
	
		/**
	 * 
	 */
	public DcaStudents() {}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="studentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	
	@Column(name="memberId")
	private Long memberId;
	
	@Column(name="score")
	private Long score;
	
	@Column(name="dcaCourseId")
	private Long dcaCourseId;
	
	@Column(name="levelId")
	private Long levelId;
	
	
	public DcaStudents(Long studentId,Long memberId, Long score, Long dcaCourseId,Long levelId) {
		this.studentId = studentId;
		this.memberId = memberId;
		this.score = score;
		this.dcaCourseId = dcaCourseId;
		this.levelId = levelId;
	}
		
}



