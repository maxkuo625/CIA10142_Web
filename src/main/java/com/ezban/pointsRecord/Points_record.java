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
	private Integer pointsRecordNo;
	@Column(name = "member_no")
	private Integer memberNo;
	@Column(name = "points_changed")
	private Integer pointsChanged;
	@Temporal(TemporalType.DATE)
	@Column(name = "transaction_time")
	private Date transactionTime;
	
	public Points_record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Points_record(Integer pointsRecordNo, Integer memberNo, Integer pointsChanged, Date transactionTime) {
		super();
		this.pointsRecordNo = pointsRecordNo;
		this.memberNo = memberNo;
		this.pointsChanged = pointsChanged;
		this.transactionTime = transactionTime;
	}

	public Integer getPointsRecordNo() {
		return pointsRecordNo;
	}

	public void setPointsRecordNo(Integer pointsRecordNo) {
		this.pointsRecordNo = pointsRecordNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getPointsChanged() {
		return pointsChanged;
	}

	public void setPointsChanged(Integer pointsChanged) {
		this.pointsChanged = pointsChanged;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	
}
