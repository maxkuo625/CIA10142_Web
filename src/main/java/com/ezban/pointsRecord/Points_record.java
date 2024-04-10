package com.ezban.pointsRecord;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import javax.persistence.Column;


@Entity
@Table(name = "points_record")
public class Points_record {
	
	@Id
	@Column(name = "points_record_no")
	private Integer points_record_no;
	@Column(name = "member_no")
	private Integer member_no;
	@Column(name = "points_changed")
	private Integer points_changed;
	@Temporal(TemporalType.DATE)
	@Column(name = "transaction_time")
	private Date transaction_time;
	
	public Points_record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Points_record(Integer points_record_no, Integer member_no, Integer points_changed, Date transaction_time) {
		super();
		this.points_record_no = points_record_no;
		this.member_no = member_no;
		this.points_changed = points_changed;
		this.transaction_time = transaction_time;
	}

	public Integer getPoints_record_no() {
		return points_record_no;
	}

	public void setPoints_record_no(Integer points_record_no) {
		this.points_record_no = points_record_no;
	}

	public Integer getMember_no() {
		return member_no;
	}

	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}

	public Integer getPoints_changed() {
		return points_changed;
	}

	public void setPoints_changed(Integer points_changed) {
		this.points_changed = points_changed;
	}

	public Date getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(Date transaction_time) {
		this.transaction_time = transaction_time;
	}
	
	

}
