package com.ezban.eventComment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ezban.member.JDBCUtil;

public class eventCommentDAOJDBCImpl implements eventCommentDAO {

	private static final String Insert_STMT = "INSERT INTO event_comment(event_comment_no, event_no, member_no, event_comment_content, event_comment_rate, event_comment_time, event_comment_status)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String Update_STMT = "UPDATE event_comment SET event_no = ?, member_no = ?, event_comment_content = ?, event_comment_rate = ?, event_comment_time = ?, event_comment_status = ? WHERE event_comment_no = ?";
	private static final String Delete_STMT = "DELETE FROM event_comment WHERE event_comment_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM event_comment WHERE event_comment_no = ?";
	private static final String GET_ALL = "SELECT * FROM event_comment";

	static {
		try {
			Class.forName(JDBCUtil.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public int add(Event_comment ecomment) {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
	        pstmt = con.prepareStatement(Insert_STMT);

	        pstmt.setInt(1, ecomment.getEventCommentNo());
	        pstmt.setInt(2, ecomment.getEventNo());
	        pstmt.setInt(3, ecomment.getMemberNo());
	        pstmt.setString(4, ecomment.getEventCommentContent());
	        pstmt.setInt(5, ecomment.getEventCommentRate());
	        
	        // 将LocalDateTime对象转换为Timestamp对象
	        LocalDateTime dateTime = ecomment.getEventCommentTime();
	        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(dateTime);
	        pstmt.setTimestamp(6, timestamp);
	        
	        pstmt.setByte(7, ecomment.getEventCommentStatus());

	        // 执行插入操作并返回受影响的行数
	        return pstmt.executeUpdate();
	    } catch (SQLException se) {
	        se.printStackTrace();
	        // Clean up JDBC resources
	    } finally {
	        closeResources(con, pstmt, null);
	    }
	    return -1;
	}

	public int update(Event_comment ecomment) {
	    Connection con = null;
	    PreparedStatement pstmt = null;

	    try {
	        con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
	        pstmt = con.prepareStatement(Update_STMT);

	        pstmt.setInt(1, ecomment.getEventNo());
	        pstmt.setInt(2, ecomment.getMemberNo());
	        pstmt.setString(3, ecomment.getEventCommentContent());
	        pstmt.setInt(4, ecomment.getEventCommentRate());
	        
	        // 使用当前的时间戳来更新时间戳列
	        LocalDateTime dateTime = LocalDateTime.now();
	        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(dateTime);
	        pstmt.setTimestamp(5, timestamp);
	        
	        pstmt.setByte(6, ecomment.getEventCommentStatus());
	        pstmt.setInt(7, ecomment.getEventCommentNo());

	        // 执行更新操作并返回受影响的行数
	        return pstmt.executeUpdate();
	    } catch (SQLException se) {
	        se.printStackTrace();
	        // Clean up JDBC resources
	    } finally {
	        closeResources(con, pstmt, null);
	    }
	    return -1;
	}
	
	public int delete(Integer event_comment_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Delete_STMT);

			pstmt.setInt(1, event_comment_no);

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
	
	public Event_comment findByPK(Integer event_comment_no) {
	    Event_comment ecomment = null;
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
	        pstmt = con.prepareStatement(FIND_BY_PK);
	        pstmt.setInt(1, event_comment_no);
	        rs = pstmt.executeQuery();

	        // 移动结果集指针到第一行
	        if (rs.next()) {
	            // 获取时间戳并转换为LocalDateTime
	            java.sql.Timestamp timestamp = rs.getTimestamp("event_comment_time");
	            LocalDateTime dateTime = timestamp.toLocalDateTime();

	            // 创建Event_comment对象并设置属性
	            ecomment = new Event_comment();
	            ecomment.setEventCommentNo(rs.getInt("event_comment_no"));
	            ecomment.setEventNo(rs.getInt("event_no"));
	            ecomment.setMemberNo(rs.getInt("member_no"));
	            ecomment.setEventCommentContent(rs.getString("event_comment_content"));
	            ecomment.setEventCommentRate(rs.getInt("event_comment_rate"));
	            ecomment.setEventCommentTime(dateTime); // 设置转换后的LocalDateTime
	            ecomment.setEventCommentStatus(rs.getByte("event_comment_status"));
	        }
	    } catch (SQLException se) {
	        se.printStackTrace();
	        // Clean up JDBC resources
	    } finally {
	        closeResources(con, pstmt, rs);
	    }
	    return ecomment;
	}
	
	public List<Event_comment> getAll() {

		List<Event_comment> ecommentList = new ArrayList<>();
		Event_comment ecomment = null;
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

	            // 创建Event_comment对象并设置属性
	            ecomment = new Event_comment();
	            ecomment.setEventCommentNo(rs.getInt("event_comment_no"));
	            ecomment.setEventNo(rs.getInt("event_no"));
	            ecomment.setMemberNo(rs.getInt("member_no"));
	            ecomment.setEventCommentContent(rs.getString("event_comment_content"));
	            ecomment.setEventCommentRate(rs.getInt("event_comment_rate"));
	            ecomment.setEventCommentTime(dateTime); // 设置转换后的LocalDateTime
	            ecomment.setEventCommentStatus(rs.getByte("event_comment_status"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return ecommentList;
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
