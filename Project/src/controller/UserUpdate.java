package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import beans.UserBeans;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getAttribute("id");
		if(id == null) {
			id = request.getParameter("id");
		}
		UserDao userDao = new UserDao();
		UserBeans userInfo = userDao.findInfo(id);

		request.setAttribute("userInfo", userInfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String name = request.getParameter("name");
		String birth_date = request.getParameter("birth_date");


		if(!pass2.equals(pass1)) {
			request.setAttribute("errorMsg", "パスワードを入力しなおしてください。");
			request.setAttribute("id", id);
			doGet(request, response);

		}else {

			if(pass1.equals("")) {
				UserDao userDao = new UserDao();
				boolean result = userDao.noPassUpDateUser(id,name,birth_date);

				if(result) {
					response.sendRedirect("UserList");

				}else {
					request.setAttribute("errorMsg", "入力された内容は正しくありません。");
					request.setAttribute("id", id);
					doGet(request,response);
				}
			}
			else {
				UserDao userDao = new UserDao();
				boolean result = userDao.upDateUser(id,name,birth_date,pass1);

				if(result) {
					response.sendRedirect("UserList");

				}else {
					request.setAttribute("errorMsg", "入力された内容は正しくありません。");
					request.setAttribute("id", id);
					doGet(request,response);
				}


			}

		}

	}
}
