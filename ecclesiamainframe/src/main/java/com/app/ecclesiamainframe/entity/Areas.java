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
@Table(name="areas_tb")
@ApiModel(description = "All details about Areas. ")
@Data
@SqlResultSetMapping(
	name = "AreaMapping",
classes = @ConstructorResult(
    targetClass = Areas.class,
    columns = {
        @ColumnResult(name = "areaId", type = Long.class),
        @ColumnResult(name = "areaName"),
        @ColumnResult(name = "jurisdiction"),
        @ColumnResult(name = "environ"),
        @ColumnResult(name = "leader")
	}))
public class Areas implements Serializable {
	
	/**
 * 
 */
public Areas() {}

private static final long serialVersionUID = 1L;

@Id
@Column(name="areaId")
@GeneratedValue(strategy = GenerationType.AUTO)
@ApiModelProperty(notes = "The database generated Area ID")
private Long areaId;

@Column(name="areaName")
@ApiModelProperty(notes = "The name of area")
private String areaName;

@Column(name="jurisdiction")
@ApiModelProperty(notes = "The area's jurisdiction")
private String jurisdiction;

@Column(name="environ")
@ApiModelProperty(notes = "The area's environs ")
private String environ;

	public Areas(Long areaId, String areaName, String jurisdiction, String environ) {
		this.areaId = areaId;
		this.areaName = areaName;
		this.jurisdiction = jurisdiction;
		this.environ = environ;
	}

	
}



