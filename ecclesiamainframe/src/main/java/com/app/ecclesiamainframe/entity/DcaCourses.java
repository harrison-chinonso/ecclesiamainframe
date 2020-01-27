/**
 * 
 */
package com.app.ecclesiamainframe.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="dcaCourses_tb")
@ApiModel(description = "All details about Dca Courses. ")
@Data
@SqlResultSetMapping(
	name = "DcaCoursesMapping",
classes = @ConstructorResult(
    targetClass = DcaCourses.class,
    columns = {
        @ColumnResult(name = "courseId", type = Long.class),
        @ColumnResult(name = "code"),
        @ColumnResult(name = "courseName"),
        @ColumnResult(name = "levelId", type = Long.class)
	}))
public class DcaCourses implements Serializable {
	
	/**
 * 
 */
public DcaCourses() {}

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="courseId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated Dca Course ID")
	private Long courseId;
	
	@Column(name="code")
	@ApiModelProperty(notes = "The course code")
	private String code;
	
	@Column(name="courseName")
	@ApiModelProperty(notes = "The name of course")
	private String courseName;
	
	@Column(name="levelId")
	@ApiModelProperty(notes = "The level where course fall under")
	private Long levelId;
	
	public DcaCourses(Long courseId, String code, String courseName, Long levelId) {
		this.courseId = courseId;
		this.code = code;
		this.courseName = courseName;
		this.levelId = levelId;
	}
	
}



