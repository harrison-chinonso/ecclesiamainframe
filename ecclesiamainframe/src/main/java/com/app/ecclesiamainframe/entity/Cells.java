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
@Table(name="cells_tb")
@ApiModel(description = "All details about Cells. ")
@Data
public class Cells implements Serializable {
	
	/**
 * 
 */
public Cells() {}

private static final long serialVersionUID = 1L;

@Id
@Column(name="cellId")
@GeneratedValue(strategy = GenerationType.AUTO)
@ApiModelProperty(notes = "The database generated Cell ID")
private Long memberId;

@Column(name="areaId")
@ApiModelProperty(notes = "The cell's area's id")
private Long areaId;

@Column(name="address")
@ApiModelProperty(notes = "The address of cell venue")
private String address;

@Column(name="jurisdiction")
@ApiModelProperty(notes = "The cell's jurisdication")
private String jurisdiction;

@Column(name="environ")
@ApiModelProperty(notes = "The cell's environ")
private String environ;

@Column(name="leader")
@ApiModelProperty(notes = "The cell leader's name")
private String leader;

public Cells(Long cellId, Long areaId, String address, String jurisdiction, String environ, String leader) {

	this.memberId = cellId;
	this.areaId = areaId;
	this.address = address;
	this.jurisdiction = jurisdiction;
	this.environ = environ;
	this.leader = leader;
}

}



