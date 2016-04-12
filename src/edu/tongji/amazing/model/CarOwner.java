package edu.tongji.amazing.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("carowner")
@Scope("prototype")
@Entity
@Table(name = "carowner")
public class CarOwner {
	
	@Id
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "productId")
	private int productId;
	
	@Column(name = "drivinglicense")
	private String drivinglicense;
	
	@Column(name = "carnumber")
	private String carnumber;
	
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=User.class)
    @JoinColumn(name="phone")
	private User user;


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getProductId() {
		return productId;
	}

	public void setProduct_id(int productId) {
		this.productId = productId;
	}

	public String getDrivinglicense() {
		return drivinglicense;
	}

	public void setDrivinglicense(String drivinglicense) {
		this.drivinglicense = drivinglicense;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
