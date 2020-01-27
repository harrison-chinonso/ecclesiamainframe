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
@Table(name="cellreports_tb")
@ApiModel(description = "All details about Cell Report. ")
@Data

public class CellReports implements Serializable {
	
	/**
 * 
 */
public CellReports() {}

private static final long serialVersionUID = 1L;

@Id
@Column(name="cellReportId")
@GeneratedValue(strategy = GenerationType.AUTO)
@ApiModelProperty(notes = "The database generated cell report ID")
private Long cellReportId;

@Column(name="cellId")
@ApiModelProperty(notes = "The cell's ID")
private Long cellId;

@Column(name="date")
@ApiModelProperty(notes = "The date of cell report")
private String date;

@Column(name="time")
@ApiModelProperty(notes = "The start and end time of cell meeting")
private String time;

@Column(name="population")
@ApiModelProperty(notes = "The cell's population")
private Long population;

@Column(name="churchAttendance")
@ApiModelProperty(notes = "The number of person's that attended church service for from cell")
private Long churchAttendance;

@Column(name="churchMVP")
@ApiModelProperty(notes = "The number of person's that attended church service for first time from cell")
private Long churchMVP;

@Column(name="offering")
@ApiModelProperty(notes = "The cell's offering")
private Long offering;

@Column(name="secondTimer")
@ApiModelProperty(notes = "The number of person's that attended church service for second time from cell")
private Long secondTimer;

@Column(name="currentlyInDCA")
@ApiModelProperty(notes = "The number of person's cuurently in dca from cell")
private Long currentlyInDCA;

@Column(name="currentlyInMaturity")
@ApiModelProperty(notes = "The number of person's cuurently in maturity class from cell")
private Long currentlyInMaturity;

@Column(name="encounter")
@ApiModelProperty(notes = "The number of person's that attended encounter from cell")
private Long encounter;

@Column(name="dli")
@ApiModelProperty(notes = "The number of person's curently in dli class from cell")
private Long dli;

@Column(name="calls")
@ApiModelProperty(notes = "The number of cell members that where called during the week")
private Long calls;

@Column(name="outreach")
@ApiModelProperty(notes = "The number of cell members that went on outreach during the week")
private Long outreach;

@Column(name="visitation")
@ApiModelProperty(notes = "The number of cell members that where visited during the week")
private Long visitation;

public CellReports(Long cellReportId,Long cellId, String date, String time, Long population, Long churchAttendance, Long churchMVP, Long offering, Long secondTimer,
		Long currentlyInDCA, Long currentlyInMaturity, Long encounter, Long dli, Long calls, Long outreach, 
		Long visitation) {

	this.cellReportId = cellReportId;
	this.cellId = cellId;
	this.date = date;
	this.time = time;
	this.population = population;
	this.churchAttendance = churchAttendance;
	this.churchMVP = churchMVP;
	this.offering = offering;
	this.secondTimer = secondTimer;
	this.currentlyInDCA = currentlyInDCA;
	this.currentlyInMaturity = currentlyInMaturity;
	this.encounter = encounter;
	this.dli = dli;
	this.calls = calls;
	this.outreach = outreach;
}
}



