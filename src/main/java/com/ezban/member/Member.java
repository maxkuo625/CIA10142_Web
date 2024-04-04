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
	private Integer member_no;
	@Column(name = "member_mail")
	private String memeber_mail;
	@Column(name = "member_pwd")
	private String member_pwd;
	@Column(name = "member_name")
	private String member_name;
	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "gender")
	private Integer gender;
	@Column(name = "member_phone")
	private String member_phone;
	@Column(name = "address")
	private String address;
	@Column(name = "common_recipient")
	private String common_recipient;
	@Column(name = "common_recipient_phone")
	private String common_recipient_phone;
	@Column(name = "common_recipient_address")
	private String common_recipient_address;
	@Column(name = "member_status")
	private Integer member_status;
	@Column(name = "member_points")
	private Integer member_points;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(Integer member_no, String memeber_mail, String member_pwd, String member_name, Date birthday,
			Integer gender, String member_phone, String address, String common_recipient, String common_recipient_phone,
			String common_recipient_address, Integer member_status, Integer member_points) {
		super();
		this.member_no = member_no;
		this.memeber_mail = memeber_mail;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.birthday = birthday;
		this.gender = gender;
		this.member_phone = member_phone;
		this.address = address;
		this.common_recipient = common_recipient;
		this.common_recipient_phone = common_recipient_phone;
		this.common_recipient_address = common_recipient_address;
		this.member_status = member_status;
		this.member_points = member_points;
	}

	public Integer getMember_no() {
		return member_no;
	}

	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}

	public String getMemeber_mail() {
		return memeber_mail;
	}

	public void setMemeber_mail(String memeber_mail) {
		this.memeber_mail = memeber_mail;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
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

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCommon_recipient() {
		return common_recipient;
	}

	public void setCommon_recipient(String common_recipient) {
		this.common_recipient = common_recipient;
	}

	public String getCommon_recipient_phone() {
		return common_recipient_phone;
	}

	public void setCommon_recipient_phone(String common_recipient_phone) {
		this.common_recipient_phone = common_recipient_phone;
	}

	public String getCommon_recipient_address() {
		return common_recipient_address;
	}

	public void setCommon_recipient_address(String common_recipient_address) {
		this.common_recipient_address = common_recipient_address;
	}

	public Integer getMember_status() {
		return member_status;
	}

	public void setMember_status(Integer member_status) {
		this.member_status = member_status;
	}

	public Integer getMember_points() {
		return member_points;
	}

	public void setMember_points(Integer member_points) {
		this.member_points = member_points;
	}
	
	
	

}
