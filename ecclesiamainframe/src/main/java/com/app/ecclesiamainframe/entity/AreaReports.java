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
@Table(name="areaReports_tb")
@ApiModel(description = "All details about the Area Report.")
@Data
public class AreaReports implements Serializable {
	
	/**
 * 
 */
public AreaReports() {}

private static final long serialVersionUID = 1L;

@Id
@Column(name="areaReportId")
@GeneratedValue(strategy = GenerationType.AUTO)
@ApiModelProperty(notes = "The database generated areaReport ID")
private Long areaReportId;

@Column(name="areaId")
@ApiModelProperty(notes = "The area ID")
private Long areaId;

@Column(name="date")
@ApiModelProperty(notes = "The date of report")
private String date;

@Column(name="targetMembers")
@ApiModelProperty(notes = "The area targetted membership")
private Long targetMembers;

@Column(name="totalMembers")
@ApiModelProperty(notes = "The area total membership")
private Long totalMembers;

@Column(name="newCell")
@ApiModelProperty(notes = "The number of new cells in the area")
private Long newCell;

@Column(name="noOfCell")
@ApiModelProperty(notes = "The number of cells in the area")
private Long noOfCell;

@Column(name="noOfCellHeld")
@ApiModelProperty(notes = "The number of cells that held in the area")
private Long noOfCellHeld;

@Column(name="cellAttendance")
@ApiModelProperty(notes = "The number of members in area that attended various cells meeting")
private Long cellAttendance;

@Column(name="churchAttendance")
@ApiModelProperty(notes = "The number of members that where in church")
private Long churchAttendance;

@Column(name="prevChurchMVP")
@ApiModelProperty(notes = "The number persons that came to church the previous week for the first time from this area")
private Long prevChurchMVP;

@Column(name="newChurchMVP")
@ApiModelProperty(notes = "The number persons that came to church for the first time from this area")
private Long newChurchMVP;

@Column(name="secondTimer")
@ApiModelProperty(notes = "The number persons that came to church for the second time from this area")
private Long secondTimer;

@Column(name="newWorkforce")
@ApiModelProperty(notes = "The number persons that joined the workforce from this area")
private Long newWorkforce;

@Column(name="outreach")
@ApiModelProperty(notes = "The number persons that went for outreach from this area")
private Long outreach;

@Column(name="currentlyInDCA")
@ApiModelProperty(notes = "The number persons that are currently attending dca from this area")
private Long currentlyInDCA;

@Column(name="currentlyInMaturity")
@ApiModelProperty(notes = "The number persons that are currently attending maturity class from this area")
private Long currentlyInMaturity;

@Column(name="encounter")
@ApiModelProperty(notes = "The number persons that joined the encounter from this area")
private Long encounter;

@Column(name="dli")
@ApiModelProperty(notes = "The number persons that currently attending dli from this area")
private Long dli;

public AreaReports(Long areaReportId,Long areaId, String date, Long targetMembers, Long totalMembers, Long newCell, Long noOfCell, Long noOfCellHeld,
		Long cellAttendance, Long churchAttendance, Long prevChurchMVP, Long newChurchMVP, Long secondTimer, Long newWorkforce,Long outreach, 
		Long currentlyInDCA, Long currentlyInMaturity, Long encounter, Long dli) {
	
	this.areaReportId = areaReportId;
	this.areaId = areaId;
	this.date = date;
	this.targetMembers = targetMembers;
	this.totalMembers = totalMembers;
	this.newCell = newCell;
	this.noOfCell = noOfCell;
	this.noOfCellHeld = noOfCellHeld;
	this.cellAttendance = cellAttendance;
	this.churchAttendance = churchAttendance;
	this.prevChurchMVP = prevChurchMVP;
	this.newChurchMVP = newChurchMVP;
	this.secondTimer = secondTimer;
	this.newWorkforce = newWorkforce;
	this.outreach = outreach;
	this.currentlyInDCA = currentlyInDCA;
	this.currentlyInMaturity = currentlyInMaturity;
	this.encounter = encounter;
	this.dli = dli;
}

}



