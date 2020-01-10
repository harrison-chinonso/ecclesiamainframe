/**
 * 
 */
package com.app.ecclesiamainframe.entity;

import java.io.Serializable;

import javax.persistence.Column;
//import javax.persistence.ColumnResult;
//import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="userLogin_tb")
@Data

//@SqlResultSetMapping(
//	name = "UserLoginMapping",
//classes = @ConstructorResult(
//    targetClass = UsersLogin.class,
//    columns = {
//        @ColumnResult(name = "userId", type = Long.class),
//        @ColumnResult(name = "password")
//	}))
public class UsersLogin implements Serializable {
	
		/**
	 * 
	 */
	public UsersLogin() {}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="userId")
	private Long userId;
	
	@Column(name="password")
	private String password;
	
	public UsersLogin(Long userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
}



