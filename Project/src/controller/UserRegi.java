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
 * Servlet implementation class UserRegi
 */
@WebServlet("/UserRegi")
public class UserRegi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegi() {
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

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegi.jsp");
			dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login_id = request.getParameter("login_id");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String name = request.getParameter("name");
		String birth_date = request.getParameter("birth_date");

		if(!pass2.equals(pass1)) {
			request.setAttribute("errorMsg", "パスワードを入力しなおしてください。");
			request.setAttribute("login_id", login_id);
			request.setAttribute("name", name);
			request.setAttribute("birth_date", birth_date);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegi.jsp");
			dispatcher.forward(request, response);

		}else {

			UserDao userDao = new UserDao();
			boolean result = userDao.findCheckLoginId(login_id);

			if(result) {
				UserDao uDao = new UserDao();
				boolean userRegi = uDao.insertUser(login_id,name,birth_date,pass1);

				if(userRegi) {
					request.setAttribute("infoMsg", "ユーザ情報の登録に成功しました。");

					response.sendRedirect("UserList");

				}else {
					request.setAttribute("errorMsg", "入力された内容は正しくありません。");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegi.jsp");
					dispatcher.forward(request, response);
				}

			}else {
				request.setAttribute("errorMsg", "そのログインIDは、すでに登録されています。");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegi.jsp");
				dispatcher.forward(request, response);
			}

		}

	}
}
