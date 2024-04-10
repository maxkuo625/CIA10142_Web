package com.ezban.admin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@Column(name = "admin_no")
	private Integer admin_no;
	@Column(name = "admin_account")
	private String admin_account;
	@Column(name = "admin_pwd")
	private String admin_pwd;
	@Column(name = "admin_name")
	private String admin_name;
	@Column(name = "admin_mail")
	private String admin_mail;
	@Column(name = "admin_phone")
	private String admin_phone;
	@Column(name = "admin_status")
	private Integer admin_status;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer admin_no, String admin_account, String admin_pwd, String admin_name, String admin_mail,
			String admin_phone, Integer admin_status) {
		super();
		this.admin_no = admin_no;
		this.admin_account = admin_account;
		this.admin_pwd = admin_pwd;
		this.admin_name = admin_name;
		this.admin_mail = admin_mail;
		this.admin_phone = admin_phone;
		this.admin_status = admin_status;
	}

	public Integer getAdmin_no() {
		return admin_no;
	}

	public void setAdmin_no(Integer admin_no) {
		this.admin_no = admin_no;
	}

	public String getAdmin_account() {
		return admin_account;
	}

	public void setAdmin_account(String admin_account) {
		this.admin_account = admin_account;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_mail() {
		return admin_mail;
	}

	public void setAdmin_mail(String admin_mail) {
		this.admin_mail = admin_mail;
	}

	public String getAdmin_phone() {
		return admin_phone;
	}

	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}

	public Integer getAdmin_status() {
		return admin_status;
	}

	public void setAdmin_status(Integer admin_status) {
		this.admin_status = admin_status;
	}
	
	
	
	
	

}
