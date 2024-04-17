package com.ezban.host;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ezban.member.JDBCUtil;
import com.ezban.member.Member;

public class HostDAOJDBCImpl {
	
	private static final String Insert_STMT = "INSERT INTO host"
			+ "(host_no, host_account, host_pwd, host_name, host_mail, host_phone, host_status)"
			+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String Update_STMT = "UPDATE host SET host_account = ?, host_pwd = ?, host_name = ?, host_mail = ?, host_phone = ?, member_status = ?, WHERE member_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM host WHERE host_no = ?";
	private static final String GET_ALL = "SELECT * FROM host";
	
	static {
		try {
			Class.forName(JDBCUtil.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public int add(Host host) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Insert_STMT);

			pstmt.setInt(1, host.getHostNo());
			pstmt.setString(2, host.getHostAccount());
			pstmt.setString(3, host.getHostPwd());
			pstmt.setString(4, host.getHostName());
			pstmt.setString(7, host.getHostMail());
			pstmt.setString(8, host.getHostPhone());
			pstmt.setByte(9, host.getHostStatus());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
		return -1;
	}
	
	public int update(Host host) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Update_STMT);

			pstmt.setInt(1, host.getHostNo());
			pstmt.setString(2, host.getHostAccount());
			pstmt.setString(3, host.getHostPwd());
			pstmt.setString(4, host.getHostName());
			pstmt.setString(7, host.getHostMail());
			pstmt.setString(8, host.getHostPhone());
			pstmt.setByte(9, host.getHostStatus());

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
	
	public Host findByPK(Integer hostNo) {

		Host host = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, hostNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				host = new Host();
				host.setHostNo(rs.getInt("host_no"));
				host.setHostAccount(rs.getString("host_account"));
				host.setHostPwd(rs.getString("host_pwd"));
				host.setHostName(rs.getString("host_name"));
				host.setHostMail(rs.getString("host_mail"));
				host.setHostPhone(rs.getString("host_phone"));
				host.setHostStatus(rs.getByte("host_status"));
				
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return host;
	}
	
	public List<Host> getAll() {

		List<Host> hostList = new ArrayList<>();
		Host host = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				host = new Host();
				host.setHostNo(rs.getInt("host_no"));
				host.setHostAccount(rs.getString("host_account"));
				host.setHostPwd(rs.getString("host_pwd"));
				host.setHostName(rs.getString("host_name"));
				host.setHostMail(rs.getString("host_mail"));
				host.setHostPhone(rs.getString("host_phone"));
				host.setHostStatus(rs.getByte("host_status"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return hostList;
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
