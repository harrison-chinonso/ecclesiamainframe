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
@Table(name="dcaLevels_tb")
@Data
@ApiModel(description = "All details about Dca Levels. ")
@SqlResultSetMapping(
	name = "DCALevelsMapping",
classes = @ConstructorResult(
    targetClass = DcaLevels.class,
    columns = {
        @ColumnResult(name = "levelId", type = Long.class),
        @ColumnResult(name = "dcaName")
	}))
public class DcaLevels implements Serializable {
	
	/**
 * 
 */
public DcaLevels() {}

private static final long serialVersionUID = 1L;

	@Id
	@Column(name="levelId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated level ID")
	private Long levelId;
	
	@Column(name="dcaName")
	@ApiModelProperty(notes = "The name of level")
	private String dcaName;
	
	public DcaLevels(Long levelId, String dcaName) {
	
		this.levelId = levelId;
		this.dcaName = dcaName;
	}
	
}



