package edu.tongji.amazing.model;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("bullet")
@Scope("prototype")
@Entity
@Table(name = "bullet")
public class Bullet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6870802072864834681L;

	@Column(name = "phone")
	private String userId;
	
	@Id
	@GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
	@Column(name = "id")
	private String bulletId;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "key")
	private String key;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBulletId() {
		return bulletId;
	}

	public void setBulletId(String bulletId) {
		this.bulletId = bulletId;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
