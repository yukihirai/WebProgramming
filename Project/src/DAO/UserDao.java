package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UserBeans;



public class UserDao {


	public List<UserBeans>findAll(){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT ID , LOGIN_ID , BIRTH_DATE , PASSWORD , CREATE_DATE , UPDATE_DATE";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String login_id = rs.getString("LOGIN_ID");
				String birth_date = rs.getString("BIRTH_DATE");
				String password = rs.getString("PASSWORD");
				String create_date = rs.getString("CREATE_DATE");
				String update_date = rs.getString("UPDATE_DATE");

				UserBeans user = new UserBeans (id,login_id,birth_date,password,create_date,update_date);

				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;

		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public List<UserBeans>find(){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "LOGIN_ID , PASSWORD";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String login_id = rs.getString("LOGIN_ID");
				String password = rs.getString("PASSWORD");

				UserBeans user = new UserBeans (login_id,password);

				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;

		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}


}
