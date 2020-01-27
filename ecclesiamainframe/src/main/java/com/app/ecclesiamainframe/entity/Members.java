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

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="members_tb")
@ApiModel(description = "All details about members. ")
@Data
@TypeDef(
    name = "json", 
    typeClass = JsonStringType.class
)

@SqlResultSetMapping(
	name = "MemberMapping",
classes = @ConstructorResult(
    targetClass = Members.class,
    columns = {
        @ColumnResult(name = "memberId", type = Long.class),
        @ColumnResult(name = "dcaRegno", type = Long.class),
        @ColumnResult(name = "address"),
        @ColumnResult(name = "age"),
        @ColumnResult(name = "areaId", type = Long.class),
        @ColumnResult(name = "birthday"),
        @ColumnResult(name = "cellId", type = Long.class),
        @ColumnResult(name = "dca"),
        @ColumnResult(name = "department"),
        @ColumnResult(name = "editor"),
        @ColumnResult(name = "firstTime"),
        @ColumnResult(name = "gender"),
        @ColumnResult(name = "maritalStatus"),
        @ColumnResult(name = "memberEmail"),
        @ColumnResult(name = "memberHomePhoneNum", type = Long.class),
        @ColumnResult(name = "memberMobileNum", type = Long.class),
        @ColumnResult(name = "memberName"),
        @ColumnResult(name = "note"),
        @ColumnResult(name = "secondTime")
	       
	}))
public class Members implements Serializable {
	
	/**
 * 
 */
public Members() {}

private static final long serialVersionUID = 1L;

@Id
@Column(name="memberId")
@GeneratedValue(strategy = GenerationType.AUTO)
@ApiModelProperty(notes = "The database generated Member ID")
private Long memberId;

@Column(name="dcaRegno")
@ApiModelProperty(notes = "The Member's Dca reg number")
private Long dcaRegno;

@Type(type = "json")
@Column(columnDefinition = "json",name="address")
@ApiModelProperty(notes = "The Member's address")
private String address;

@Column(name="age")
@ApiModelProperty(notes = "The Member's age")
private String age;

@Column(name="areaId")
@ApiModelProperty(notes = "The Member's area's id")
private Long areaId;

@Column(name="birthday")
@ApiModelProperty(notes = "The Member's birthday")
private String birthday;

@Column(name="cellId")
@ApiModelProperty(notes = "The Member's cell's id")
private Long cellId;

@Type(type = "json")
@Column(columnDefinition = "json",name="dca")
@ApiModelProperty(notes = "The Member's dca levels attended with date")
private String dca;

@Column(name="department")
@ApiModelProperty(notes = "The Member's department")
private String department;

@Column(name="editor")
@ApiModelProperty(notes = "The user who registered member on system")
private String editor;

@Column(name="firstTime")
@ApiModelProperty(notes = "The Member's firtst attendance to church")
private String firstTime;

@Column(name="gender")
@ApiModelProperty(notes = "The Member's gender")
private String gender;

@Column(name="maritalStatus")
@ApiModelProperty(notes = "The Member's marital status")
private String maritalStatus;

@Column(name="memberEmail")
@ApiModelProperty(notes = "The Member's email")
private String memberEmail;

@Column(name="memberHomePhoneNum")
@ApiModelProperty(notes = "The Member's home phone numuber")
private Long memberHomePhoneNum;

@Column(name="memberMobileNum")
@ApiModelProperty(notes = "The Member's mobile phone number")
private Long memberMobileNum;

@Column(name="memberName")
@ApiModelProperty(notes = "The Member's name")
private String memberName;

@Column(name="note")
@ApiModelProperty(notes = "Notes on Member")
private String note;

@Column(name="secondTime")
@ApiModelProperty(notes = "The Member's second attendance to church")
private String secondTime;

public Members(Long memberId,String memberName) {
	this.memberId = memberId;
	this.memberName = memberName;
}

public Members(Long memberId, Long dcaRegno, String address, String age, Long areaId, String birthday, Long cellId, String dca,
		String department, String editor, String firstTime, String gender, String maritalStatus, String memberEmail, 
		Long memberHomePhoneNum, Long memberMobileNum, String memberName, String note, String secondTime) {

	this.memberId = memberId;
	this.dcaRegno = dcaRegno;
	this.address = address;
	this.age = age;
	this.areaId = areaId;
	this.birthday = birthday;
	this.cellId = cellId;
	this.dca = dca;
	this.department = department;
	this.editor = editor;
	this.firstTime = firstTime;
	this.gender = gender;
	this.maritalStatus = maritalStatus;
	this.memberEmail = memberEmail;
	this.memberHomePhoneNum = memberHomePhoneNum;
	this.memberMobileNum = memberMobileNum;
	this.memberName = memberName;
	this.note = note;
	this.secondTime = secondTime;
}
	
}



