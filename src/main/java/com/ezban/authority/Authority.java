package com.ezban.authority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "authority")
public class Authority {
	
	@Id
	@Column(name = "admin_no")
	private Integer admin_no;
	@Column(name = "func_no")
	private Integer func_no;
	
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authority(Integer admin_no, Integer func_no) {
		super();
		this.admin_no = admin_no;
		this.func_no = func_no;
	}

	public Integer getAdmin_no() {
		return admin_no;
	}

	public void setAdmin_no(Integer admin_no) {
		this.admin_no = admin_no;
	}

	public Integer getFunc_no() {
		return func_no;
	}

	public void setFunc_no(Integer func_no) {
		this.func_no = func_no;
	}
	
	
	
	

}
