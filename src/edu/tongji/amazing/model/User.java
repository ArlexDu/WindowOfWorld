package edu.tongji.amazing.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_table")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4136775472696389375L;
	@Id
	private int u_id;
    public int getId() {
		return u_id;
	}
	public void setId(int id) {
		this.u_id = id;
	}
	private String username;
    private String password;
    private String identity_id;
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
   
}
