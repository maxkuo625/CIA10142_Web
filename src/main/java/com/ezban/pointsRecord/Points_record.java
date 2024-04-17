package com.ezban.pointsRecord;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
	private LocalDateTime transactionTime;
	
	public Points_record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Points_record(Integer pointsRecordNo, Integer memberNo, Integer pointsChanged,
			LocalDateTime transactionTime) {
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

	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}

	
	
	
}
