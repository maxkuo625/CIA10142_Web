package com.ezban.notification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ezban.member.JDBCUtil;

public class notificationDAOJDBCImpl implements notificationDAO {
	
	private static final String Insert_STMT = "INSERT INTO notification(notification_no, member_no, host_no, admin_no, notification_content, read_status, notification_time)"
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	private static final String Update_STMT = "UPDATE notification SET member_no = ?, host_no = ?, admin_no = ?, notification_content = ?, read_status = ?, notification_time = ? WHERE notification_no = ?";
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

			pstmt.setInt(1, notify.getNotificationNo());
			pstmt.setInt(2, notify.getMemberNo());
			pstmt.setInt(3, notify.getHostNo());
			pstmt.setInt(4, notify.getAdminNo());
			pstmt.setString(5, notify.getNotificationContent());
			pstmt.setByte(6, notify.getReadStatus());
			LocalDateTime dateTime = notify.getNotificationTime();
	        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(dateTime);
	        pstmt.setTimestamp(7, timestamp);

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

			pstmt.setInt(1, notify.getNotificationNo());
			pstmt.setInt(2, notify.getMemberNo());
			pstmt.setInt(3, notify.getHostNo());
			pstmt.setInt(4, notify.getAdminNo());
			pstmt.setString(5, notify.getNotificationContent());
			pstmt.setByte(6, notify.getReadStatus());
			LocalDateTime dateTime = notify.getNotificationTime();
	        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(dateTime);
	        pstmt.setTimestamp(7, timestamp);


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
				// 获取时间戳并转换为LocalDateTime
	            java.sql.Timestamp timestamp = rs.getTimestamp("event_comment_time");
	            LocalDateTime dateTime = timestamp.toLocalDateTime();

	            notify = new Notification();
	            notify.setNotificationNo(rs.getInt("notification_no"));
	            notify.setMemberNo(rs.getInt("member_no"));
	            notify.setHostNo(rs.getInt("host_no"));
	            notify.setAdminNo(rs.getInt("admin_no"));
	            notify.setNotificationContent(rs.getString("notification_content"));
	            notify.setReadStatus(rs.getByte("read_status"));
	            notify.setNotificationTime(dateTime); // 设置转换后的LocalDateTime
	           
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
				// 获取时间戳并转换为LocalDateTime
	            java.sql.Timestamp timestamp = rs.getTimestamp("event_comment_time");
	            LocalDateTime dateTime = timestamp.toLocalDateTime();

	            notify = new Notification();
	            notify.setNotificationNo(rs.getInt("notification_no"));
	            notify.setMemberNo(rs.getInt("member_no"));
	            notify.setHostNo(rs.getInt("host_no"));
	            notify.setAdminNo(rs.getInt("admin_no"));
	            notify.setNotificationContent(rs.getString("notification_content"));
	            notify.setReadStatus(rs.getByte("read_status"));
	            notify.setNotificationTime(dateTime); // 设置转换后的LocalDateTime
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
