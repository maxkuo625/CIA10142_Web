package com.ezban.productComment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.sql.Timestamp;
import java.time.LocalDateTime; 

import javax.persistence.Column;

@Entity
@Table(name = "product_comment")
public class Product_comment {
	
	@Id
	@Column(name = "product_comment_no")
	private Integer productCommentNo;
	@Column(name = "product_no")
	private Integer productNo;
	@Column(name = "member_no")
	private Integer memberNo;
	@Column(name = "product_rate")
	private Integer productRate;
	@Column(name = "product_comment_content")
	private String productCommentContent;
	@Column(name = "product_comment_date")
	private LocalDateTime productCommentDate;
	@Column(name = "product_comment_status")
	private Byte productCommentStatus;
	
	public Product_comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product_comment(Integer productCommentNo, Integer productNo, Integer memberNo, Integer productRate,
			String productCommentContent, LocalDateTime productCommentDate, Byte productCommentStatus) {
		super();
		this.productCommentNo = productCommentNo;
		this.productNo = productNo;
		this.memberNo = memberNo;
		this.productRate = productRate;
		this.productCommentContent = productCommentContent;
		this.productCommentDate = productCommentDate;
		this.productCommentStatus = productCommentStatus;
	}

	public Integer getProductCommentNo() {
		return productCommentNo;
	}

	public void setProductCommentNo(Integer productCommentNo) {
		this.productCommentNo = productCommentNo;
	}

	public Integer getProductNo() {
		return productNo;
	}

	public void setProductNo(Integer productNo) {
		this.productNo = productNo;
	}

	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getProductRate() {
		return productRate;
	}

	public void setProductRate(Integer productRate) {
		this.productRate = productRate;
	}

	public String getProductCommentContent() {
		return productCommentContent;
	}

	public void setProductCommentContent(String productCommentContent) {
		this.productCommentContent = productCommentContent;
	}

	public LocalDateTime getProductCommentDate() {
		return productCommentDate;
	}

	public void setProductCommentDate(LocalDateTime productCommentDate) {
		this.productCommentDate = productCommentDate;
	}

	public Byte getProductCommentStatus() {
		return productCommentStatus;
	}

	public void setProductCommentStatus(Byte productCommentStatus) {
		this.productCommentStatus = productCommentStatus;
	}

	
	
	
}
