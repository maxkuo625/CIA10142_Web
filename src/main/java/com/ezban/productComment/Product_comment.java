package com.ezban.productComment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

import javax.persistence.Column;

@Entity
@Table(name = "product_comment")
public class Product_comment {
	
	@Id
	@Column(name = "product_comment_no")
	private Integer product_comment_no;
	@Column(name = "product_no")
	private Integer product_no;
	@Column(name = "member_no")
	private Integer member_no;
	@Column(name = "product_rate")
	private Integer product_rate;
	@Column(name = "product_comment_content")
	private String product_comment_content;
	@Temporal(TemporalType.DATE)
	@Column(name = "product_comment_date")
	private Date product_comment_date;
	@Column(name = "product_comment_status")
	private Integer product_comment_status;
	
	public Product_comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product_comment(Integer product_comment_no, Integer product_no, Integer member_no, Integer product_rate,
			String product_comment_content, Date product_comment_date, Integer product_comment_status) {
		super();
		this.product_comment_no = product_comment_no;
		this.product_no = product_no;
		this.member_no = member_no;
		this.product_rate = product_rate;
		this.product_comment_content = product_comment_content;
		this.product_comment_date = product_comment_date;
		this.product_comment_status = product_comment_status;
	}

	public Integer getProduct_comment_no() {
		return product_comment_no;
	}

	public void setProduct_comment_no(Integer product_comment_no) {
		this.product_comment_no = product_comment_no;
	}

	public Integer getProduct_no() {
		return product_no;
	}

	public void setProduct_no(Integer product_no) {
		this.product_no = product_no;
	}

	public Integer getMember_no() {
		return member_no;
	}

	public void setMember_no(Integer member_no) {
		this.member_no = member_no;
	}

	public Integer getProduct_rate() {
		return product_rate;
	}

	public void setProduct_rate(Integer product_rate) {
		this.product_rate = product_rate;
	}

	public String getProduct_comment_content() {
		return product_comment_content;
	}

	public void setProduct_comment_content(String product_comment_content) {
		this.product_comment_content = product_comment_content;
	}

	public Date getProduct_comment_date() {
		return product_comment_date;
	}

	public void setProduct_comment_date(Date product_comment_date) {
		this.product_comment_date = product_comment_date;
	}

	public Integer getProduct_comment_status() {
		return product_comment_status;
	}

	public void setProduct_comment_status(Integer product_comment_status) {
		this.product_comment_status = product_comment_status;
	}
	
	
	

}
