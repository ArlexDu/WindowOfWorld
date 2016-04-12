package edu.tongji.amazing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("credit")
@Entity
@Scope("prototype")
@Table(name = "Credit")
public class Credit {
	
	@Id
	@GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
	@Column(name = "id")
	private String id;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "credit")
	private String credit;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "time")
	private String time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
