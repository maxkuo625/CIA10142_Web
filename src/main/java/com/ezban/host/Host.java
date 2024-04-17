package com.ezban.host;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "host")
public class Host {
	
	@Id
	@Column(name = "host_no")
	private Integer hostNo;
	@Column(name = "host_account")
	private String hostAccount;
	@Column(name = "host_pwd")
	private String hostPwd;
	@Column(name = "host_name")
	private String hostName;
	@Column(name = "host_mail")
	private String hostMail;
	@Column(name = "host_phone")
	private String hostPhone;
	@Column(name = "host_status")
	private Byte hostStatus;
	
	public Host() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Host(Integer hostNo, String hostAccount, String hostPwd, String hostName, String hostMail, String hostPhone,
			Byte hostStatus) {
		super();
		this.hostNo = hostNo;
		this.hostAccount = hostAccount;
		this.hostPwd = hostPwd;
		this.hostName = hostName;
		this.hostMail = hostMail;
		this.hostPhone = hostPhone;
		this.hostStatus = hostStatus;
	}

	public Integer getHostNo() {
		return hostNo;
	}

	public void setHostNo(Integer hostNo) {
		this.hostNo = hostNo;
	}

	public String getHostAccount() {
		return hostAccount;
	}

	public void setHostAccount(String hostAccount) {
		this.hostAccount = hostAccount;
	}

	public String getHostPwd() {
		return hostPwd;
	}

	public void setHostPwd(String hostPwd) {
		this.hostPwd = hostPwd;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostMail() {
		return hostMail;
	}

	public void setHostMail(String hostMail) {
		this.hostMail = hostMail;
	}

	public String getHostPhone() {
		return hostPhone;
	}

	public void setHostPhone(String hostPhone) {
		this.hostPhone = hostPhone;
	}

	public Byte getHostStatus() {
		return hostStatus;
	}

	public void setHostStatus(Byte hostStatus) {
		this.hostStatus = hostStatus;
	}
	
	

}
