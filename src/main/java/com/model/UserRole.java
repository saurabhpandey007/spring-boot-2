package com.model;

import javax.persistence.*;

@Entity
@Table(name="User_Roles")
public class UserRole {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="User_Role_Id")
	private Long userroleid;
	
	@Column(name="UserId")
	private Long userid;
	
	@Column(name="Role")
	private String role;	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getUserroleid() {
		return userroleid;
	}

	public void setUserroleid(Long userroleid) {
		this.userroleid = userroleid;
	}

	@Override
	public String toString() {
		return "UserRole [userroleid=" + userroleid + ", userid=" + userid + ", role=" + role + "]";
	}	
	
	
}
