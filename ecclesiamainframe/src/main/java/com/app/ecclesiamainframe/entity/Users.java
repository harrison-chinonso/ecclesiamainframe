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

//import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
//import org.springframework.security.authentication.encoding.PasswordEncoder;

import lombok.Data;

/**
 * @author Harry
 *
 */
@Entity
@Table(name="users_tb")
@Data

@SqlResultSetMapping(
	name = "UserMapping",
classes = @ConstructorResult(
    targetClass = Users.class,
    columns = {
        @ColumnResult(name = "userId", type = Long.class),
        @ColumnResult(name = "username"),
        @ColumnResult(name = "password"),
        @ColumnResult(name = "name"),
        @ColumnResult(name = "areaId", type = Long.class),
        @ColumnResult(name = "permission")
	}))
public class Users implements Serializable {
	
	/**
 * 
 */
 public Users() {}

 private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="areaId")
	private Long areaId;
	
	@Column(name="permission")
	private String permission;
	
	
//	public String getPassword() {
//		return password;
//	}
	
//	public void setPassword(String password) {
//		PasswordEncoder crypto = new Md5PasswordEncoder();
//		this.password = crypto.encodePassword(password, null);
//	}
	
	public Users(Long userId, String username,String password, String name, Long areaId, String permission) {
	
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.areaId = areaId;
		this.permission = permission;
    }
	
}



