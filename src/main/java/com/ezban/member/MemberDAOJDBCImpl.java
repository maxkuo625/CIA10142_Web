package com.ezban.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberDAOJDBCImpl implements MemberDAO {

	private static final String Insert_STMT = "INSERT INTO member"
			+ "(member_no, member_mail, member_pwd, member_name, birthday, gender, member_phone, address, common_recipient, common_recipient_phone, common_recipient_address, member_status, member_points)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String Update_STMT = "UPDATE member SET member_mail = ?, member_pwd = ?, member_name = ?, birthday = ?, gender = ?, member_phone = ?, address = ?, common_recipient = ?, common_recipient_phone = ?, common_recipient_address = ?, member_status = ?, member_points = ? WHERE member_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM member WHERE member_no = ?";
	private static final String GET_ALL = "SELECT * FROM member";

	static {
		try {
			Class.forName(JDBCUtil.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public int add(Member mem) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Insert_STMT);

			pstmt.setInt(1, mem.getMember_no());
			pstmt.setString(2, mem.getMemeber_mail());
			pstmt.setString(3, mem.getMember_pwd());
			pstmt.setString(4, mem.getMember_name());
			pstmt.setDate(5, new java.sql.Date(mem.getBirthday().getTime()));
			pstmt.setInt(6, mem.getGender());
			pstmt.setString(7, mem.getMember_phone());
			pstmt.setString(8, mem.getAddress());
			pstmt.setString(9, mem.getCommon_recipient());
			pstmt.setString(10, mem.getCommon_recipient_phone());
			pstmt.setString(11, mem.getCommon_recipient_address());
			pstmt.setInt(12, mem.getMember_status());
			pstmt.setInt(13, mem.getMember_points());

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

	public int update(Member mem) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Update_STMT);

			pstmt.setString(1, mem.getMemeber_mail());
			pstmt.setString(2, mem.getMember_pwd());
			pstmt.setString(3, mem.getMember_name());
			pstmt.setDate(4, new java.sql.Date(mem.getBirthday().getTime()));
			pstmt.setInt(5, mem.getGender());
			pstmt.setString(6, mem.getMember_phone());
			pstmt.setString(7, mem.getAddress());
			pstmt.setString(8, mem.getCommon_recipient());
			pstmt.setString(9, mem.getCommon_recipient_phone());
			pstmt.setString(10, mem.getCommon_recipient_address());
			pstmt.setInt(11, mem.getMember_status());
			pstmt.setInt(12, mem.getMember_points());
			pstmt.setInt(13, mem.getMember_no());

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

	public Member findByPK(Integer member_no) {

		Member mem = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, member_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem = new Member();
				mem.setMember_no(rs.getInt("member_no"));
				mem.setMemeber_mail(rs.getString("member_mail"));
				mem.setMember_pwd(rs.getString("member_pwd"));
				mem.setMember_name(rs.getString("member_name"));
				mem.setBirthday(new java.sql.Date(rs.getDate("birthday").getTime()));
				mem.setGender(rs.getInt("gender"));
				mem.setMember_phone(rs.getString("member_phone"));
				mem.setAddress(rs.getString("address"));
				mem.setCommon_recipient(rs.getString("common_recipient"));
				mem.setCommon_recipient_phone(rs.getString("common_recipient_phone"));
				mem.setCommon_recipient_address(rs.getString("common_recipient_address"));
				mem.setMember_status(rs.getInt("member_status"));
				mem.setMember_points(rs.getInt("member_points"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return mem;
	}

	public List<Member> getAll() {

		List<Member> memberList = new ArrayList<>();
		Member mem = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem = new Member();
				mem.setMember_no(rs.getInt("member_no"));
				mem.setMemeber_mail(rs.getString("member_mail"));
				mem.setMember_pwd(rs.getString("member_pwd"));
				mem.setMember_name(rs.getString("member_name"));
				mem.setBirthday(new java.sql.Date(rs.getDate("birthday").getTime()));
				mem.setGender(rs.getInt("gender"));
				mem.setMember_phone(rs.getString("member_phone"));
				mem.setAddress(rs.getString("address"));
				mem.setCommon_recipient(rs.getString("common_recipient"));
				mem.setCommon_recipient_phone(rs.getString("common_recipient_phone"));
				mem.setCommon_recipient_address(rs.getString("common_recipient_address"));
				mem.setMember_status(rs.getInt("member_status"));
				mem.setMember_points(rs.getInt("member_points"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return memberList;
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
