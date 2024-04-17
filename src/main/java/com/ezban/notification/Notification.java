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
	private Integer notificationNo;
	@Column(name = "member_no")
	private Integer memberNo;
	@Column(name = "host_no")
	private Integer hostNo;
	@Column(name = "admin_no")
	private Integer adminNo;
	@Column(name = "notification_content")
	private String notificationContent;
	@Column(name = "read_status")
	private Byte readStatus;
	@Temporal(TemporalType.DATE)
	@Column(name = "notification_time")
	private Date notificationTime;
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(Integer notificationNo, Integer memberNo, Integer hostNo, Integer adminNo,
			String notificationContent, Byte readStatus, Date notificationTime) {
		super();
		this.notificationNo = notificationNo;
		this.memberNo = memberNo;
		this.hostNo = hostNo;
		this.adminNo = adminNo;
		this.notificationContent = notificationContent;
		this.readStatus = readStatus;
		this.notificationTime = notificationTime;
	}

	public Integer getNotificationNo() {
		return notificationNo;
	}

	public void setNotificationNo(Integer notificationNo) {
		this.notificationNo = notificationNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getHostNo() {
		return hostNo;
	}

	public void setHostNo(Integer hostNo) {
		this.hostNo = hostNo;
	}

	public Integer getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(Integer adminNo) {
		this.adminNo = adminNo;
	}

	public String getNotificationContent() {
		return notificationContent;
	}

	public void setNotificationContent(String notificationContent) {
		this.notificationContent = notificationContent;
	}

	public Byte getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(Byte readStatus) {
		this.readStatus = readStatus;
	}

	public Date getNotificationTime() {
		return notificationTime;
	}

	public void setNotificationTime(Date notificationTime) {
		this.notificationTime = notificationTime;
	}
	
	
}
