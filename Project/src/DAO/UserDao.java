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

			String sql = "SELECT id , login_id , name , birth_date , password , create_date , update_date FROM UserList WHERE id>1";
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

			String sql = "SELECT password FROM UserList WHERE login_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);

			ResultSet rs = pStmt.executeQuery();

			String password = "";
			while(rs.next()) {
				password = rs.getString("password");
			}

			pass = UtilLogic.convertMd5(pass);
			System.out.println(pass);
			System.out.println(password);

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

			String sql = "SELECT name FROM UserList WHERE login_id=?";
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

			String sql = "SELECT * FROM UserList WHERE id=?";
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

				user = new UserBeans (id,login_id,name,birth_date,password,create_date,update_date);

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

	public boolean findCheckLoginId(String Login_id){
		boolean result = false;


		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT login_id FROM UserList WHERE login_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Login_id);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {
				result = true;
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
	public boolean insertUser(String login_id,String name,String birth_date,String password){
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO UserList (login_id,name,birth_date,password,create_date,update_date) VALUES(?,?,?,?,NOW(),NOW())";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			pStmt.setString(2, name);
			pStmt.setString(3, birth_date);

			password = UtilLogic.convertMd5(password);
			pStmt.setString(4, password);

			pStmt.executeUpdate();



		}catch(SQLException e) {
			e.printStackTrace();
			return false;

		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	public boolean upDateUser(String id,String name,String birth_date,String password){
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE UserList SET name=?, birth_date=?, password=?, update_date=now() WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birth_date);

			password = UtilLogic.convertMd5(password);
			pStmt.setString(3, password);
			pStmt.setString(4, id);

			pStmt.executeUpdate();



		}catch(SQLException e) {
			e.printStackTrace();
			return false;

		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	public boolean noPassUpDateUser(String id,String name,String birth_date){
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE UserList SET name=?, birth_date=?, update_date=now() WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birth_date);
			pStmt.setString(3, id);

			pStmt.executeUpdate();



		}catch(SQLException e) {
			e.printStackTrace();
			return false;

		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	public boolean deleteUser(String id){
		Connection conn = null;

		try {
			conn = DBManager.getConnection();

			String sql = "DELETE FROM UserList WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);

			pStmt.executeUpdate();



		}catch(SQLException e) {
			e.printStackTrace();
			return false;

		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	public List<UserBeans>findSelect(String login_id,String name,String birth_date1,String birth_date2){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id , login_id , name , birth_date FROM UserList WHERE login_id=? AND name LIKE ? AND birth_date>=? AND birth_date<=? AND id>1";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login_id);
			pStmt.setString(2,"%"+name+"%");
			pStmt.setString(3,birth_date1);
			pStmt.setString(4,birth_date2);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id, login_id1,name1,birth_date);

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
	public List<UserBeans>findSelectBirth2(String birth_date2){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT  id, login_id , name , birth_date FROM UserList WHERE birth_date<=? AND id>1";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,birth_date2);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectBirth1(String birth_date1){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT  id, login_id , name , birth_date FROM UserList WHERE birth_date>=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,birth_date1);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectBirth1Birth2(String birth_date1, String birth_date2){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id,login_id , name , birth_date FROM UserList WHERE birth_date>=? AND birth_date<=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,birth_date1);
			pStmt.setString(2,birth_date2);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectName(String name){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT  id , login_id , name , birth_date FROM UserList WHERE name LIKE ? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,"%"+name+"%");

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				System.out.println(id);
				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectNameBirth2(String name,String birth_date2){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id, login_id , name , birth_date FROM UserList WHERE name LIKE ? AND birth_date<=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,"%"+name+"%");
			pStmt.setString(2, birth_date2);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectNameBirth1(String name,String birth_date1){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id, login_id , name , birth_date FROM UserList WHERE name LIKE ? AND birth_date>=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,"%"+name+"%");
			pStmt.setString(2, birth_date1);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectNameBirth1Birth2(String name,String birth_date1,String birth_date2){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id, login_id , name , birth_date FROM UserList WHERE name LIKE ? AND birth_date>=? AND birth_date<=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,"%"+name+"%");
			pStmt.setString(2, birth_date1);
			pStmt.setString(3, birth_date2);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectLogin(String login_id){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id, login_id , name , birth_date FROM UserList WHERE login_id=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login_id);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");
				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectLoginBirth2(String login_id,String birth_date2){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id, login_id , name , birth_date FROM UserList WHERE login_id=? AND birth_date<=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login_id);
			pStmt.setString(2, birth_date2);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectLoginBirth1(String login_id,String birth_date1){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id,login_id , name , birth_date FROM UserList WHERE login_id=? AND birth_date>=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login_id);
			pStmt.setString(2, birth_date1);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectLoginBirth1Birth2(String login_id,String birth_date1,String birth_date2){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id,login_id , name , birth_date FROM UserList WHERE login_id=? AND birth_date>=? birth_date<=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login_id);
			pStmt.setString(2, birth_date1);
			pStmt.setString(3, birth_date2);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectLoginName(String login_id,String name){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id,login_id , name , birth_date FROM UserList WHERE login_id=? AND name LIKE ? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login_id);
			pStmt.setString(2, "%"+name+"%");

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectLoginNameBirth2(String login_id,String name,String birth_date2){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id,login_id , name , birth_date FROM UserList WHERE login_id=? AND name LIKE ? AND birth_date<=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login_id);
			pStmt.setString(2, "%"+name+"%");
			pStmt.setString(3, birth_date2);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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

	public List<UserBeans>findSelectLoginNameBirth1(String login_id,String name,String birth_date1){
		Connection conn = null;

		List<UserBeans>userList = new ArrayList<UserBeans>();

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id,login_id , name , birth_date FROM UserList WHERE login_id=? AND name LIKE ? AND birth_date>=? AND id>1 ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,login_id);
			pStmt.setString(2, "%"+name+"%");
			pStmt.setString(3, birth_date1);

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String login_id1 = rs.getString("login_id");
				String name1 = rs.getString("name");
				String birth_date = rs.getString("birth_date");

				UserBeans user = new UserBeans (id,login_id1,name1,birth_date);

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