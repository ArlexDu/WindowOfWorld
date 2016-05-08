package edu.tongji.amazing.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("advertisement")
@Scope("prototype")
@Entity
@Table(name = "advertisement")
public class Advertisement implements Serializable {

	/*
	 * 
	 */
	private static final long serialVersionUID = 5892217915877750303L;
	
	@Id
	@SequenceGenerator(name = "generator",sequenceName="addads")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	private long id;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "placetype")
	private String placetype;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "content")
	private String content;

	@Column(name = "class")
	private String advertisementclass;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=AdvertisementPlaceAndTime.class)
	@JoinColumns(value={@JoinColumn(name="adid",referencedColumnName="id")})
	private Set<AdvertisementPlaceAndTime> placeandtime = new HashSet<AdvertisementPlaceAndTime>();
	
	
	public Set<AdvertisementPlaceAndTime> getPlaceandtime() {
		return placeandtime;
	}

	public void setPlaceandtime(Set<AdvertisementPlaceAndTime> placeandtime) {
		this.placeandtime = placeandtime;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAdvertisementclass() {
		return advertisementclass;
	}

	public void setAdvertisementclass(String advertisementclass) {
		this.advertisementclass = advertisementclass;
	}

	public String getPlacetype() {
		return placetype;
	}

	public void setPlacetype(String placetype) {
		this.placetype = placetype;
	}
    
	
	
}
