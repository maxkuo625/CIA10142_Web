package com.ezban.member;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@Column(name = "member_no")
	private Integer memberNo;
	@Column(name = "member_mail")
	private String memeberMail;
	@Column(name = "member_pwd")
	private String memberPwd;
	@Column(name = "member_name")
	private String memberName;
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "gender")
	private Integer gender;
	@Column(name = "member_phone")
	private String memberPhone;
	@Column(name = "address")
	private String address;
	@Column(name = "common_recipient")
	private String commonRecipient;
	@Column(name = "common_recipient_phone")
	private String commonRecipientPhone;
	@Column(name = "common_recipient_address")
	private String commonRecipientAddress;
	@Column(name = "member_status")
	private Byte memberStatus;
	@Column(name = "member_points")
	private Integer memberPoints;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(Integer memberNo, String memeberMail, String memberPwd, String memberName, Date birthday,
			Integer gender, String memberPhone, String address, String commonRecipient, String commonRecipientPhone,
			String commonRecipientAddress, Byte memberStatus, Integer memberPoints) {
		super();
		this.memberNo = memberNo;
		this.memeberMail = memeberMail;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.birthday = birthday;
		this.gender = gender;
		this.memberPhone = memberPhone;
		this.address = address;
		this.commonRecipient = commonRecipient;
		this.commonRecipientPhone = commonRecipientPhone;
		this.commonRecipientAddress = commonRecipientAddress;
		this.memberStatus = memberStatus;
		this.memberPoints = memberPoints;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemeberMail() {
		return memeberMail;
	}

	public void setMemeberMail(String memeberMail) {
		this.memeberMail = memeberMail;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCommonRecipient() {
		return commonRecipient;
	}

	public void setCommonRecipient(String commonRecipient) {
		this.commonRecipient = commonRecipient;
	}

	public String getCommonRecipientPhone() {
		return commonRecipientPhone;
	}

	public void setCommonRecipientPhone(String commonRecipientPhone) {
		this.commonRecipientPhone = commonRecipientPhone;
	}

	public String getCommonRecipientAddress() {
		return commonRecipientAddress;
	}

	public void setCommonRecipientAddress(String commonRecipientAddress) {
		this.commonRecipientAddress = commonRecipientAddress;
	}

	public Byte getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(Byte memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Integer getMemberPoints() {
		return memberPoints;
	}

	public void setMemberPoints(Integer memberPoints) {
		this.memberPoints = memberPoints;
	}

}
