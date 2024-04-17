package com.ezban.productComment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ezban.member.JDBCUtil;


public class productCommentDAOJDBCImpl implements productCommentDAO {

	private static final String Insert_STMT = "INSERT INTO product_comment(product_comment_no, product_no, member_no, product_rate, product_comment_content, product_comment_date, product_comment_status)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String Update_STMT = "UPDATE product_comment SET product_no = ?, member_no = ?, product_rate = ?, product_comment_content = ?, product_comment_date = ?, product_comment_status = ? WHERE product_comment_no = ?";
	private static final String Delete_STMT = "DELETE FROM product_comment WHERE product_comment_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM product_comment WHERE product_comment_no = ?";
	private static final String GET_ALL = "SELECT * FROM product_comment";

	static {
		try {
			Class.forName(JDBCUtil.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public int add(Product_comment pcomment) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Insert_STMT);

			pstmt.setInt(1, pcomment.getProductCommentNo());
			pstmt.setInt(2, pcomment.getProductNo());
			pstmt.setInt(3, pcomment.getMemberNo());
			pstmt.setInt(4, pcomment.getProductRate());
			pstmt.setString(5, pcomment.getProductCommentContent());
			pstmt.setDate(6, new java.sql.Date(pcomment.getProductCommentDate().getTime()));
			pstmt.setByte(7, pcomment.getProductCommentStatus());

			return pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
		return -1;
	}

	public int update(Product_comment pcomment) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Update_STMT);

			pstmt.setInt(1, pcomment.getProductCommentNo());
			pstmt.setInt(2, pcomment.getProductNo());
			pstmt.setInt(3, pcomment.getMemberNo());
			pstmt.setInt(4, pcomment.getProductRate());
			pstmt.setString(5, pcomment.getProductCommentContent());
			pstmt.setDate(6, new java.sql.Date(pcomment.getProductCommentDate().getTime()));
			pstmt.setByte(7, pcomment.getProductCommentStatus());

			return pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
		return -1;
	}
	
	public int delete(Integer product_comment_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Delete_STMT);

			pstmt.setInt(1, product_comment_no);

			return pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
		return -1;
	}
	
	public Product_comment findByPK(Integer product_comment_no) {

		Product_comment pcomment = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, product_comment_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pcomment = new Product_comment();
				pcomment.setProductCommentNo(rs.getInt("product_comment_no"));
				pcomment.setProductNo(rs.getInt("product_no"));
				pcomment.setMemberNo(rs.getInt("member_no"));
				pcomment.setProductRate(rs.getInt("product_rate"));
				pcomment.setProductCommentContent(rs.getString("product_comment_content"));
				pcomment.setProductCommentDate(new java.sql.Date(rs.getDate("product_comment_date").getTime()));
				pcomment.setProductCommentStatus(rs.getByte("product_comment_status"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return pcomment;
	}
	
	public List<Product_comment> getAll() {

		List<Product_comment> pcommentList = new ArrayList<>();
		Product_comment pcomment = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pcomment = new Product_comment();
				pcomment.setProductCommentNo(rs.getInt("product_comment_no"));
				pcomment.setProductNo(rs.getInt("product_no"));
				pcomment.setMemberNo(rs.getInt("member_no"));
				pcomment.setProductRate(rs.getInt("product_rate"));
				pcomment.setProductCommentContent(rs.getString("product_comment_content"));
				pcomment.setProductCommentDate(new java.sql.Date(rs.getDate("product_comment_date").getTime()));
				pcomment.setProductCommentStatus(rs.getByte("product_comment_status"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return pcommentList;
	}
	
	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}


}
