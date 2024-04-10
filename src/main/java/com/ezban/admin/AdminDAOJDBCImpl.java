package com.ezban.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ezban.member.JDBCUtil;

public class AdminDAOJDBCImpl implements AdminDAO {
	
	private static final String Insert_STMT = "INSERT INTO admin(admin_no, admin_account, admin_pwd, admin_name, admin_mail, admin_phone, admin_status)"
				+"VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String Update_STMT = "UPDATE admin SET admin_account = ?, admin_pwd = ?, admin_name = ?, admin_mail = ?, admin_phone = ?, admin_status = ? WHERE admin_no = ?";
	private static final String Delete_STMT = "DELETE FROM admin WHERE admin_no = ?";
	private static final String FIND_BY_PK = "SELECT * FROM admin WHERE admin_no = ?";
	private static final String GET_ALL = "SELECT * FROM admin";
	
	static {
		try {
			Class.forName(JDBCUtil.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	public int add(Admin admin) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Insert_STMT);

			pstmt.setInt(1, admin.getAdmin_no());
			pstmt.setString(2, admin.getAdmin_account());
			pstmt.setString(3, admin.getAdmin_pwd());
			pstmt.setString(4, admin.getAdmin_name());
			pstmt.setString(5, admin.getAdmin_mail());
			pstmt.setString(6, admin.getAdmin_phone());
			pstmt.setInt(7, admin.getAdmin_status());
			
			
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
	
	public int update(Admin admin) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Update_STMT);

			pstmt.setString(1, admin.getAdmin_account());
			pstmt.setString(2, admin.getAdmin_pwd());
			pstmt.setString(3, admin.getAdmin_name());
			pstmt.setString(4, admin.getAdmin_mail());
			pstmt.setString(5, admin.getAdmin_phone());
			pstmt.setInt(6, admin.getAdmin_status());
			pstmt.setInt(7, admin.getAdmin_no());

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
	
	public int delete(Integer admin_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(Delete_STMT);

			pstmt.setInt(1, admin_no);

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
	
	public Admin findByPK(Integer admin_no) {

		Admin admin = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, admin_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				admin = new Admin();
				admin.setAdmin_no(rs.getInt("admin_no"));
				admin.setAdmin_account(rs.getString("admin_account"));
				admin.setAdmin_pwd(rs.getString("admin_pwd"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_mail(rs.getString("admin_mail"));
				admin.setAdmin_phone(rs.getString("admin_phone"));
				admin.setAdmin_status(rs.getInt("admin_status"));
		
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return admin;
	}
	
	public List<Admin> getAll() {

		List<Admin> adminList = new ArrayList<>();
		Admin admin = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(JDBCUtil.URL, JDBCUtil.USER, JDBCUtil.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				admin = new Admin();
				admin.setAdmin_no(rs.getInt("admin_no"));
				admin.setAdmin_account(rs.getString("admin_account"));
				admin.setAdmin_pwd(rs.getString("admin_pwd"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_mail(rs.getString("admin_mail"));
				admin.setAdmin_phone(rs.getString("admin_phone"));
				admin.setAdmin_status(rs.getInt("admin_status"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return adminList;
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
