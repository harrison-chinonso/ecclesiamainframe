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

import lombok.Data;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="areas_tb")
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
private Long areaId;

@Column(name="areaName")
private String areaName;

@Column(name="jurisdiction")
private String jurisdiction;

@Column(name="environ")
private String environ;

	public Areas(Long areaId, String areaName, String jurisdiction, String environ) {
		this.areaId = areaId;
		this.areaName = areaName;
		this.jurisdiction = jurisdiction;
		this.environ = environ;
	}

	
}



