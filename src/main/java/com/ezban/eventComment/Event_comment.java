package com.ezban.eventComment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;   

import javax.persistence.Column;


@Entity
@Table(name = "event_comment")
public class Event_comment {
	
	@Id
	@Column(name = "event_comment_no")
	private Integer eventCommentNo;
	@Column(name = "event_no")
	private Integer eventNo;
	@Column(name = "member_no")
	private Integer memberNo;
	@Column(name = "event_comment_content")
	private String eventCommentContent;
	@Column(name = "event_comment_rate")
	private Integer eventCommentRate;
	@Column(name = "event_comment_time")
	private LocalDateTime eventCommentTime;
	@Column(name = "event_comment_status")
	private Byte eventCommentStatus;
	
	public Event_comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event_comment(Integer eventCommentNo, Integer eventNo, Integer memberNo, String eventCommentContent,
			Integer eventCommentRate, LocalDateTime eventCommentTime, Byte eventCommentStatus) {
		super();
		this.eventCommentNo = eventCommentNo;
		this.eventNo = eventNo;
		this.memberNo = memberNo;
		this.eventCommentContent = eventCommentContent;
		this.eventCommentRate = eventCommentRate;
		this.eventCommentTime = eventCommentTime;
		this.eventCommentStatus = eventCommentStatus;
	}

	public Integer getEventCommentNo() {
		return eventCommentNo;
	}

	public void setEventCommentNo(Integer eventCommentNo) {
		this.eventCommentNo = eventCommentNo;
	}

	public Integer getEventNo() {
		return eventNo;
	}

	public void setEventNo(Integer eventNo) {
		this.eventNo = eventNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public String getEventCommentContent() {
		return eventCommentContent;
	}

	public void setEventCommentContent(String eventCommentContent) {
		this.eventCommentContent = eventCommentContent;
	}

	public Integer getEventCommentRate() {
		return eventCommentRate;
	}

	public void setEventCommentRate(Integer eventCommentRate) {
		this.eventCommentRate = eventCommentRate;
	}

	public LocalDateTime getEventCommentTime() {
		return eventCommentTime;
	}

	public void setEventCommentTime(LocalDateTime eventCommentTime) {
		this.eventCommentTime = eventCommentTime;
	}

	public Byte getEventCommentStatus() {
		return eventCommentStatus;
	}

	public void setEventCommentStatus(Byte eventCommentStatus) {
		this.eventCommentStatus = eventCommentStatus;
	}



	
	
}
