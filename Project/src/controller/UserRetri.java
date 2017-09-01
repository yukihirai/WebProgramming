package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import beans.UserBeans;

/**
 * Servlet implementation class UserRetri
 */
@WebServlet("/UserRetri")
public class UserRetri extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRetri() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login_id = request.getParameter("login_id");
		String name = request.getParameter("name");
		String birth_date1 = request.getParameter("birth_date1");
		String birth_date2 = request.getParameter("birth_date2");


		UserDao userDao = new UserDao();
		List<UserBeans>userList = userDao.findSelect(login_id,name,birth_date1,birth_date2);

		request.setAttribute("userList",userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);


	}

}
