package com.ezban.notification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ezban.member.JDBCUtil;
import com.ezban.productComment.Product_comment;

public class notificationDAOJDBCImpl implements notificationDAO {
	
	private static final String Insert_STMT = "INSERT INTO notification(notification_no, member_no, host_no, notification_content, read_status, notification_time)"
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	private static final String Update_STMT = "UPDATE notification SET member_no = ?, host_no = ?, notification_content = ?, read_status = ?, notification_time = ? WHERE notification_no = ?";
	private static final String Delete_STMT = "DELETE FROM notification WHERE notification_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM notification WHERE notification_no = ?";
	private static final String GET_ALL = "SELECT * FROM notification";
	
	static {
		try {
			Class.forName(JDBCUtil.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public int add(Notification notify) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Insert_STMT);

			pstmt.setInt(1, notify.getNotification_no());
			pstmt.setInt(2, notify.getMember_no());
			pstmt.setInt(3, notify.getHost_no());
			pstmt.setString(4, notify.getNotification_content());
			pstmt.setInt(5, notify.getRead_status());
			pstmt.setDate(6, new java.sql.Date(notify.getNotification_time().getTime()));

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
	
	public int update(Notification notify) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Update_STMT);

			pstmt.setInt(1, notify.getNotification_no());
			pstmt.setInt(2, notify.getMember_no());
			pstmt.setInt(3, notify.getHost_no());
			pstmt.setString(4, notify.getNotification_content());
			pstmt.setInt(5, notify.getRead_status());
			pstmt.setDate(6, new java.sql.Date(notify.getNotification_time().getTime()));

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
	
	public int delete(Integer notification_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Delete_STMT);

			pstmt.setInt(1, notification_no);

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
	
	public Notification findByPK(Integer notification_no) {

		Notification notify = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, notification_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				notify = new Notification();
				notify.setNotification_no(rs.getInt("product_comment_no"));
				notify.setMember_no(rs.getInt("product_no"));
				notify.setHost_no(rs.getInt("member_no"));
				notify.setNotification_content(rs.getString("product_comment_content"));
				notify.setRead_status(rs.getInt("product_rate"));
				notify.setNotification_time(new java.sql.Date(rs.getDate("product_comment_date").getTime()));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return notify;
	}
	
	public List<Notification> getAll() {

		List<Notification> notifyList = new ArrayList<>();
		Notification notify = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				notify = new Notification();
				notify.setNotification_no(rs.getInt("product_comment_no"));
				notify.setMember_no(rs.getInt("product_no"));
				notify.setHost_no(rs.getInt("member_no"));
				notify.setNotification_content(rs.getString("product_comment_content"));
				notify.setRead_status(rs.getInt("product_rate"));
				notify.setNotification_time(new java.sql.Date(rs.getDate("product_comment_date").getTime()));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return notifyList;
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
