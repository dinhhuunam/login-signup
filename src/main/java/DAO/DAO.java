package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DB.DBConnection;
import entity.Account;

public class DAO {
	public Account login(String user,String pass) {
		PreparedStatement ps =null;
		ResultSet rs=null;
		String query = "SELECT * FROM account\r\n"
				+ "where user = ?\r\n"
				+ "and pass = ?";
		try {
			Connection conn = DBConnection.CreatConnection(); //kết nối với mysql
			ps=conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public Account checkAccountExist(String user) {
		PreparedStatement ps =null;
		ResultSet rs=null;
		String query = "SELECT * FROM account\r\n"
				+ "where user = ?\r\n";
		try {
			Connection conn = DBConnection.CreatConnection(); //kết nối với mysql
			ps=conn.prepareStatement(query);
			ps.setString(1, user);
			rs=ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void signup(String user,String email,String pass,String contact) {
		PreparedStatement ps =null;
		ResultSet rs=null;
		String query="insert into account(user,email,pass,contact)"
				+"values(?,?,?,?)";
		try {
			Connection conn = DBConnection.CreatConnection(); //kết nối với mysql
			ps=conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setString(4, contact);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main() {
		
	}
}