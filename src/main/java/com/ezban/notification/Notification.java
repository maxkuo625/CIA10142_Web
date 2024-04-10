package com.ezban.notification;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import javax.persistence.Column;

@Entity
@Table(name = "notification")
public class Notification {
	
	@Id
	@Column(name = "notification_no")
	private Integer notification_no;
	@Column(name = "member_no")
	private Integer member_no;
	@Column(name = "host_no")
	private Integer host_no;
	@Column(name = "notification_content")
	private String notification_content;
	@Column(name = "read_status")
	private Integer read_status;
	@Temporal(TemporalType.DATE)
	@Column(name = "notification_time")
	private Date notification_time;
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(Integer notification_no, Integer member_no, Integer host_no, String notification_content,
			Integer read_status, Date notification_time) {
		super();
		this.notification_no = notification_no;
		this.member_no = member_no;
		this.host_no = host_no;
		this.notification_content = notification_content;
		this.read_status = read_status;
		this.notification_time = notification_time;
	}

	public Integer getNotification_no() {
		return notification_no;
	}

	public void setNotification_no(Integer notification_no) {
		this.notification_no = notification_no;
	}

	public Integer getMember_no() {
		return member_no;
	}

	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}

	public Integer getHost_no() {
		return host_no;
	}

	public void setHost_no(Integer host_no) {
		this.host_no = host_no;
	}

	public String getNotification_content() {
		return notification_content;
	}

	public void setNotification_content(String notification_content) {
		this.notification_content = notification_content;
	}

	public Integer getRead_status() {
		return read_status;
	}

	public void setRead_status(Integer read_status) {
		this.read_status = read_status;
	}

	public Date getNotification_time() {
		return notification_time;
	}

	public void setNotification_time(Date notification_time) {
		this.notification_time = notification_time;
	}
	
	
	
	

}
