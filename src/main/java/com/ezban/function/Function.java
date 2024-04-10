package com.ezban.function;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "function")
public class Function {
	
	@Id
	@Column(name = "func_no")
	private Integer func_no;
	@Column(name = "func_name")
	private String func_name;
	
	public Function() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Function(Integer func_no, String func_name) {
		super();
		this.func_no = func_no;
		this.func_name = func_name;
	}

	public Integer getFunc_no() {
		return func_no;
	}

	public void setFunc_no(Integer func_no) {
		this.func_no = func_no;
	}

	public String getFunc_name() {
		return func_name;
	}

	public void setFunc_name(String func_name) {
		this.func_name = func_name;
	}
	
	

}
