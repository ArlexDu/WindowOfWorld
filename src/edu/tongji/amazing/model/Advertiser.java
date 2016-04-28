package edu.tongji.amazing.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("advertiser")
@Entity
@Scope("prototype")
@Table(name = "Advertiser")
public class Advertiser {

	@Id
	@Column(name = "phone")
	public String phone;
	
	@Column(name = "mail")
	public String mail;

	@Column(name = "license")
	public String license;
	
	@Column(name ="licensecard")
	public String licensecard;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = User.class)
	@JoinColumn(name = "phone")
	private User user;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicensecard() {
		return licensecard;
	}

	public void setLicensecard(String licensecard) {
		this.licensecard = licensecard;
	}
	
	

}
