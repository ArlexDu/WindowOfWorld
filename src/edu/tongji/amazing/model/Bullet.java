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
	private String phone;
	
	@Id
	@GeneratedValue(generator="system_uuid")
    @GenericGenerator(name="system_uuid",strategy="uuid")
	@Column(name = "id")
	private String id;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "key")
	private String key;
	
	@Column(name = "fcolor")
	private String color = "#000000";
	
	@Column(name = "fsize")
	private String size = "18";

	@Column(name = "title")
	private String title;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
}
