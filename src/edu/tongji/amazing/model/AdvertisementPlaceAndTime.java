package edu.tongji.amazing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("placeandtime")
@Scope("prototype")
@Entity
@Table(name = "placeandtime")
public class AdvertisementPlaceAndTime {

	@Id
	@SequenceGenerator(name = "generator",sequenceName="addads")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
	private long id;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "longitude")
	private String longtitude;
	
	@Column(name = "begin")
	private String begin_time;
	
	@Column(name = "end")
	private String end_time; 
	
	@Column(name = "place")
	private String place;
	
	private String adid;
	
	public AdvertisementPlaceAndTime() {
		// TODO Auto-generated constructor stub
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



	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	
	
	
}
