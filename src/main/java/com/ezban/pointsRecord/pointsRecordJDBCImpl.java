package com.ezban.pointsRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ezban.member.JDBCUtil;

public class pointsRecordJDBCImpl implements pointsRecordDAO {

	private static final String Insert_STMT = "INSERT INTO points_record(points_record_no, member_no, points_changed, transaction_time)"
			+ "VALUES (?, ?, ?, ?)";
	private static final String Update_STMT = "UPDATE product_comment SET member_no = ?, points_changed = ?, transaction_time = ? WHERE points_record_no = ?";
	private static final String Delete_STMT = "DELETE FROM points_record WHERE points_record_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM points_record WHERE points_record_no = ?";
	private static final String GET_ALL = "SELECT * FROM points_record";

	static {
		try {
			Class.forName(JDBCUtil.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public int add(Points_record poRecord) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Insert_STMT);

			pstmt.setInt(1, poRecord.getPointsRecordNo());
			pstmt.setInt(2, poRecord.getMemberNo());
			pstmt.setInt(3, poRecord.getPointsChanged());
			pstmt.setDate(4, new java.sql.Date(poRecord.getTransactionTime().getTime()));

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
	
	public int update(Points_record poRecord) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Update_STMT);

			pstmt.setInt(1, poRecord.getPointsRecordNo());
			pstmt.setInt(2, poRecord.getMemberNo());
			pstmt.setInt(3, poRecord.getPointsChanged());
			pstmt.setDate(4, new java.sql.Date(poRecord.getTransactionTime().getTime()));

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
	
	public int delete(Integer points_record_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Delete_STMT);

			pstmt.setInt(1, points_record_no);

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
	
	public Points_record findByPK(Integer points_record_no) {

		Points_record poRecord = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, points_record_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				poRecord = new Points_record();
				poRecord.setPointsRecordNo(rs.getInt("points_record_no"));
				poRecord.setMemberNo(rs.getInt("member_no"));
				poRecord.setPointsChanged(rs.getInt("points_changed"));
				poRecord.setTransactionTime(new java.sql.Date(rs.getDate("transaction_time").getTime()));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return poRecord;
	}
	
	public List<Points_record> getAll() {

		List<Points_record> poRecordList = new ArrayList<>();
		Points_record poRecord = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				poRecord = new Points_record();
				poRecord.setPointsRecordNo(rs.getInt("points_record_no"));
				poRecord.setMemberNo(rs.getInt("member_no"));
				poRecord.setPointsChanged(rs.getInt("points_changed"));
				poRecord.setTransactionTime(new java.sql.Date(rs.getDate("transaction_time").getTime()));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return poRecordList;
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
