package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.UserBeans;
import controller.UtilLogic;



public class UserDao {


	public List<UserBeans>findAll(){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id , login_id , name , birth_date , password , create_date , update_date FROM user";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id = rs.getString("login_id");
				String name = rs.getString("name");
				String birth_date = rs.getString("birth_date");
				String password = rs.getString("password");
				String create_date = rs.getString("create_date");
				String update_date = rs.getString("update_date");

				UserBeans user = new UserBeans (id,login_id,name,birth_date,password,create_date,update_date);

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

	public boolean findCheckLogin(String login_id , String pass){
		boolean result = false;


		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT password FROM user WHERE login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);

			ResultSet rs = pStmt.executeQuery();

			String password = "";
			while(rs.next()) {
				password = rs.getString("password");
			}

			pass = UtilLogic.convertMd5(pass);


			if(password.equals(pass)) {
				result =  true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}
	public List<UserBeans>findName(String login_id){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT name FROM user WHERE login_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {


				String name = rs.getString("name");


				UserBeans user = new UserBeans (name);

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
	public UserBeans findInfo(String id){
		Connection conn = null;

		UserBeans user = new UserBeans();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT login_id , name , birth_date , password , create_date , update_date FROM user WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,id);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String login_id = rs.getString("login_id");
				String name = rs.getString("name");
				String birth_date = rs.getString("birth_date");
				String password = rs.getString("password");
				String create_date = rs.getString("create_date");
				String update_date = rs.getString("update_date");

				user = new UserBeans (login_id,name,birth_date,password,create_date,update_date);


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
		return user;
	}




}
