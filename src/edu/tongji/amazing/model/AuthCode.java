package edu.tongji.amazing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("authcode")
@Scope("prototype")
@Entity
@Table(name="AUTHCODE")
public class AuthCode {
	@Id
	@Column(name = "phonenumber")
	private String phonenumber;
	
	@Column(name = "code")
	private String code;

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
