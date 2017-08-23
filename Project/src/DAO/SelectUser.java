package DAO;

import java.util.List;

import beans.UserBeans;


public class SelectUser {
	public static void main(String[]args) {
		UserDao uDao = new UserDao();
		List<UserBeans>userList = uDao.findAll() ;
		List<UserBeans>loginPass = uDao.find();
	}




}
