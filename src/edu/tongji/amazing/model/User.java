package edu.tongji.amazing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("user")
@Scope("prototype")
@Entity
@Table(name = "wowuser")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4136775472696389375L;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "identity")
	private String identity;
	
	@Id
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "balance")
	private float balace;
	
	@Column(name = "credit")
	private float credit;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "realname")
	private String realname;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "class")
	private String userclass;
	
	@Column(name = "identitycard")
	private String identityCard;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getBalace() {
		return balace;
	}

	public void setBalace(float balace) {
		this.balace = balace;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserclass() {
		return userclass;
	}

	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	
	
	
	

}
