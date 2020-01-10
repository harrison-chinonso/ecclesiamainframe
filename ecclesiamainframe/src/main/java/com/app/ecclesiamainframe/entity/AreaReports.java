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
@Table(name="areaReports_tb")
@Data
//@SqlResultSetMapping(
//	name = "AreaMapping",
//classes = @ConstructorResult(
//    targetClass = AreaReports.class,
//    columns = {
//    		@ColumnResult(name = "areaReportId", type = Long.class),
//    		@ColumnResult(name = "areaId", type = Long.class),
//            @ColumnResult(name = "date"),
//            @ColumnResult(name = "targetMembers", type = Long.class),
//            @ColumnResult(name = "totalMembers", type = Long.class),
//            @ColumnResult(name = "newCell", type = Long.class),
//            @ColumnResult(name = "noOfCell", type = Long.class),
//            @ColumnResult(name = "noOfCellHeld", type = Long.class),
//            @ColumnResult(name = "cellAttendance", type = Long.class),
//            @ColumnResult(name = "churchAttendance", type = Long.class),
//            @ColumnResult(name = "prevChurchMVP", type = Long.class),
//            @ColumnResult(name = "newChurchMVP", type = Long.class),
//            @ColumnResult(name = "secondTimer", type = Long.class),
//            @ColumnResult(name = "newWorkforce", type = Long.class),
//            @ColumnResult(name = "outreach", type = Long.class),
//            @ColumnResult(name = "currentlyInDCA", type = Long.class),
//            @ColumnResult(name = "currentlyInMaturity", type = Long.class),
//            @ColumnResult(name = "encounter", type = Long.class),
//            @ColumnResult(name = "dli", type = Long.class)       
//	}))
public class AreaReports implements Serializable {
	
	/**
 * 
 */
public AreaReports() {}

private static final long serialVersionUID = 1L;

@Id
@Column(name="areaReportId")
@GeneratedValue(strategy = GenerationType.AUTO)
private Long areaReportId;

@Column(name="areaId")
private Long areaId;

@Column(name="date")
private String date;

@Column(name="targetMembers")
private Long targetMembers;

@Column(name="totalMembers")
private Long totalMembers;

@Column(name="newCell")
private Long newCell;

@Column(name="noOfCell")
private Long noOfCell;

@Column(name="noOfCellHeld")
private Long noOfCellHeld;

@Column(name="cellAttendance")
private Long cellAttendance;

@Column(name="churchAttendance")
private Long churchAttendance;

@Column(name="prevChurchMVP")
private Long prevChurchMVP;

@Column(name="newChurchMVP")
private Long newChurchMVP;

@Column(name="secondTimer")
private Long secondTimer;

@Column(name="newWorkforce")
private Long newWorkforce;

@Column(name="outreach")
private Long outreach;

@Column(name="currentlyInDCA")
private Long currentlyInDCA;

@Column(name="currentlyInMaturity")
private Long currentlyInMaturity;

@Column(name="encounter")
private Long encounter;

@Column(name="dli")
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



