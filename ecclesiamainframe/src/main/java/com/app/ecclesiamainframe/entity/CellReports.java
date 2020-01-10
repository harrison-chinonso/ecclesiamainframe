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
@Table(name="cellreports_tb")
@Data

//@SqlResultSetMapping(
//	name = "CellMapping",
//classes = @ConstructorResult(
//    targetClass = CellReports.class,
//    columns = {
//    	@ColumnResult(name = "cellReportId", type = Long.class),
//        @ColumnResult(name = "cellId", type = Long.class),
//        @ColumnResult(name = "date"),
//        @ColumnResult(name = "time"),
//        @ColumnResult(name = "population", type = Long.class),
//        @ColumnResult(name = "churchAttendance", type = Long.class),
//        @ColumnResult(name = "churchMVP", type = Long.class),
//        @ColumnResult(name = "cellMVP", type = Long.class),
//        @ColumnResult(name = "offering", type = Long.class),
//        @ColumnResult(name = "secondTimer", type = Long.class),
//        @ColumnResult(name = "currentlyInDCA", type = Long.class),
//        @ColumnResult(name = "currentlyInMaturity", type = Long.class),
//        @ColumnResult(name = "encounter", type = Long.class),
//        @ColumnResult(name = "dli", type = Long.class),
//        @ColumnResult(name = "calls", type = Long.class),
//        @ColumnResult(name = "outreach", type = Long.class),
//        @ColumnResult(name = "visitation", type = Long.class)           
//	}))
public class CellReports implements Serializable {
	
	/**
 * 
 */
public CellReports() {}

private static final long serialVersionUID = 1L;

@Id
@Column(name="cellReportId")
@GeneratedValue(strategy = GenerationType.AUTO)
private Long cellReportId;

@Column(name="cellId")
private Long cellId;

@Column(name="date")
private String date;

@Column(name="time")
private String time;

@Column(name="population")
private Long population;

@Column(name="churchAttendance")
private Long churchAttendance;

@Column(name="churchMVP")
private Long churchMVP;

@Column(name="offering")
private Long offering;

@Column(name="secondTimer")
private Long secondTimer;

@Column(name="currentlyInDCA")
private Long currentlyInDCA;

@Column(name="currentlyInMaturity")
private Long currentlyInMaturity;

@Column(name="encounter")
private Long encounter;

@Column(name="dli")
private Long dli;

@Column(name="calls")
private Long calls;

@Column(name="outreach")
private Long outreach;

@Column(name="visitation")
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



