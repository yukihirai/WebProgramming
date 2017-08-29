package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userRegi.jsp");
			dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		String login_id = request.getParameter("login_id");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String name = request.getParameter("name");
		String birth_date = request.getParameter("birth_date");

		if(pass1 != pass2) {
			request.setAttribute("passError", "パスワードの入力しなおしてください。");

		}

	}

}
