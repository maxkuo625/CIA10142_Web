package com.ezban.eventComment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import javax.persistence.Column;


@Entity
@Table(name = "event_comment")
public class Event_comment {
	
	@Id
	@Column(name = "event_comment_no")
	private Integer event_comment_no;
	@Column(name = "event_no")
	private Integer event_no;
	@Column(name = "member_no")
	private Integer member_no;
	@Column(name = "event_comment_content")
	private String event_comment_content;
	@Column(name = "event_comment_rate")
	private Integer event_comment_rate;
	@Temporal(TemporalType.DATE)
	@Column(name = "event_comment_time")
	private Date event_comment_time;
	@Column(name = "event_comment_status")
	private Integer event_comment_status;
	
	public Event_comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event_comment(Integer event_comment_no, Integer event_no, Integer member_no, String event_comment_content,
			Integer event_comment_rate, Date event_comment_time, Integer event_comment_status) {
		super();
		this.event_comment_no = event_comment_no;
		this.event_no = event_no;
		this.member_no = member_no;
		this.event_comment_content = event_comment_content;
		this.event_comment_rate = event_comment_rate;
		this.event_comment_time = event_comment_time;
		this.event_comment_status = event_comment_status;
	}

	public Integer getEvent_comment_no() {
		return event_comment_no;
	}

	public void setEvent_comment_no(Integer event_comment_no) {
		this.event_comment_no = event_comment_no;
	}

	public Integer getEvent_no() {
		return event_no;
	}

	public void setEvent_no(Integer event_no) {
		this.event_no = event_no;
	}

	public Integer getMember_no() {
		return member_no;
	}

	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}

	public String getEvent_comment_content() {
		return event_comment_content;
	}

	public void setEvent_comment_content(String event_comment_content) {
		this.event_comment_content = event_comment_content;
	}

	public Integer getEvent_comment_rate() {
		return event_comment_rate;
	}

	public void setEvent_comment_rate(Integer event_comment_rate) {
		this.event_comment_rate = event_comment_rate;
	}

	public Date getEvent_comment_time() {
		return event_comment_time;
	}

	public void setEvent_comment_time(Date event_comment_time) {
		this.event_comment_time = event_comment_time;
	}

	public Integer getEvent_comment_status() {
		return event_comment_status;
	}

	public void setEvent_comment_status(Integer event_comment_status) {
		this.event_comment_status = event_comment_status;
	}
	
	
	

}
