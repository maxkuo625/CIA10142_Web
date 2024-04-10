package com.ezban.eventComment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ezban.member.JDBCUtil;
import com.ezban.productComment.Product_comment;

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

			pstmt.setInt(1, ecomment.getEvent_comment_no());
			pstmt.setInt(2, ecomment.getEvent_no());
			pstmt.setInt(3, ecomment.getMember_no());
			pstmt.setString(4, ecomment.getEvent_comment_content());
			pstmt.setInt(5, ecomment.getEvent_comment_rate());
			pstmt.setDate(6, new java.sql.Date(ecomment.getEvent_comment_time().getTime()));
			pstmt.setInt(7, ecomment.getEvent_comment_status());

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

	public int update(Event_comment ecomment) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Update_STMT);

			pstmt.setInt(1, ecomment.getEvent_comment_no());
			pstmt.setInt(2, ecomment.getEvent_no());
			pstmt.setInt(3, ecomment.getMember_no());
			pstmt.setString(4, ecomment.getEvent_comment_content());
			pstmt.setInt(5, ecomment.getEvent_comment_rate());
			pstmt.setDate(6, new java.sql.Date(ecomment.getEvent_comment_time().getTime()));
			pstmt.setInt(7, ecomment.getEvent_comment_status());

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

			while (rs.next()) {
				ecomment = new Event_comment();
				ecomment.setEvent_comment_no(rs.getInt("event_comment_no"));
				ecomment.setEvent_no(rs.getInt("event_no"));
				ecomment.setMember_no(rs.getInt("member_no"));
				ecomment.setEvent_comment_content(rs.getString("event_comment_content"));
				ecomment.setEvent_comment_rate(rs.getInt("event_comment_rate"));
				ecomment.setEvent_comment_time(new java.sql.Date(rs.getDate("event_comment_time").getTime()));
				ecomment.setEvent_comment_status(rs.getInt("event_comment_status"));
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
				ecomment = new Event_comment();
				ecomment.setEvent_comment_no(rs.getInt("event_comment_no"));
				ecomment.setEvent_no(rs.getInt("event_no"));
				ecomment.setMember_no(rs.getInt("member_no"));
				ecomment.setEvent_comment_content(rs.getString("event_comment_content"));
				ecomment.setEvent_comment_rate(rs.getInt("event_comment_rate"));
				ecomment.setEvent_comment_time(new java.sql.Date(rs.getDate("event_comment_time").getTime()));
				ecomment.setEvent_comment_status(rs.getInt("event_comment_status"));
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
