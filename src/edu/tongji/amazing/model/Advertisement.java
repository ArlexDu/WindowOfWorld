package edu.tongji.amazing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
	@Column(name = "id")
	private String id;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "begin_time")
	private String begin_time;
	
	@Column(name = "end_time")
	private String end_time;
	
	@Column(name = "place")
	private String place;
	
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
	
	@Column(name = "picturepath")
	private String picturepath;
	
	public String getAd_id() {
		return id;
	}

	public void setAd_id(String ad_id) {
		this.id = ad_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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

	public String getPicturepath() {
		return picturepath;
	}

	public void setPicturepath(String picturepath) {
		this.picturepath = picturepath;
	}
    
	
	
}
