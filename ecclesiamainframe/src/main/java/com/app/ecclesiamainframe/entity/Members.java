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

import lombok.Data;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="members_tb")
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
private Long memberId;

@Column(name="dcaRegno")
private Long dcaRegno;

@Type(type = "json")
@Column(columnDefinition = "json",name="address")
private String address;

@Column(name="age")
private String age;

@Column(name="areaId")
private Long areaId;

@Column(name="birthday")
private String birthday;

@Column(name="cellId")
private Long cellId;

@Type(type = "json")
@Column(columnDefinition = "json",name="dca")
private String dca;

@Column(name="department")
private String department;

@Column(name="editor")
private String editor;

@Column(name="firstTime")
private String firstTime;

@Column(name="gender")
private String gender;

@Column(name="maritalStatus")
private String maritalStatus;

@Column(name="memberEmail")
private String memberEmail;

@Column(name="memberHomePhoneNum")
private Long memberHomePhoneNum;

@Column(name="memberMobileNum")
private Long memberMobileNum;

@Column(name="memberName")
private String memberName;

@Column(name="note")
private String note;

@Column(name="secondTime")
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



