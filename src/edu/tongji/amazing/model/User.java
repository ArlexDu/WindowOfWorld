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

	@Id
	@Column(name = "identity")

	private String identity_id;

	@Column(name = "phone")
	private String phone;

	@Column(name = "balance")
	private String balance;

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

	public String getIdentity_id() {
		return identity_id;
	}

	public void setIdentity_id(String identity_id) {
		this.identity_id = identity_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	
}
