package edu.bh.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity(name = "USERS")
public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1500328107352239713L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "F_NAME")
	@NotEmpty(message = "First Name is Mandatory")
	private String fName;
	
	@Column(name="L_NAME")
	@NotEmpty(message = "Last Name is Mandatory")
	private String lName;
	
	@Column(name = "USER_ID")
	private String userId;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
