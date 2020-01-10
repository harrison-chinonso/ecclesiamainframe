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
@Table(name="cells_tb")
@Data
//@SqlResultSetMapping(
//	name = "CellMapping",
//classes = @ConstructorResult(
//    targetClass = Cells.class,
//    columns = {
//        @ColumnResult(name = "cellId", type = Long.class),
//        @ColumnResult(name = "areaId", type = Long.class),
//        @ColumnResult(name = "address"),
//        @ColumnResult(name = "jurisdiction"),
//        @ColumnResult(name = "environ"),
//        @ColumnResult(name = "leader")
//	}))
public class Cells implements Serializable {
	
	/**
 * 
 */
public Cells() {}

private static final long serialVersionUID = 1L;

@Id
@Column(name="cellId")
@GeneratedValue(strategy = GenerationType.AUTO)
private Long memberId;

@Column(name="areaId")
private Long areaId;

@Column(name="address")
private String address;

@Column(name="jurisdiction")
private String jurisdiction;

@Column(name="environ")
private String environ;

@Column(name="leader")
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



