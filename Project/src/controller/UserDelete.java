package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import beans.UserBeans;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		UserBeans userBeans = (UserBeans)session.getAttribute("UserLoginidName");


		if(userBeans.getName() == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}

		String id = request.getParameter("id");
		UserDao userDao = new UserDao();
		UserBeans userInfo = userDao.findInfo(id);

		request.setAttribute("userInfo", userInfo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDelete.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UserDao userDao = new UserDao();
		boolean result = userDao.deleteUser(id);
		if(result) {
			request.setAttribute("msg", "ユーザ情報の削除に成功しました。");
			response.sendRedirect("UserList");
		}else {
			request.setAttribute("errorMsg", "ユーザ情報の削除に失敗しました。");
			request.setAttribute("id", id);
			doGet(request, response);
		}
	}

}
