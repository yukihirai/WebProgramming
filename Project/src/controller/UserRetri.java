package controller;

import java.io.IOException;
import java.util.List;

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

		HttpSession session = request.getSession();

		UserBeans userBeans = (UserBeans)session.getAttribute("UserLoginidName");


		if(userBeans.getName() == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}

		String login_id = request.getParameter("login_id");
		String name = request.getParameter("name");
		String birth_date1 = request.getParameter("birth_date1");
		String birth_date2 = request.getParameter("birth_date2");


		if(login_id.length()==0) {
			if(name.length()==0) {
				if(birth_date1.length()==0) {

					if(birth_date2.length()==0) {
						UserDao userDao = new UserDao();
						List<UserBeans>userList = userDao.findAll();

						request.setAttribute("userList",userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}else {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectBirth2(birth_date2);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}

				}else {
					if(birth_date2.length()==0) {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectBirth1(birth_date1);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}else {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectBirth1Birth2(birth_date1,birth_date2);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}
				}
			}else {
				if(birth_date1.length()==0) {

					if(birth_date2.length()==0) {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectName(name);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}else {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectNameBirth2(name,birth_date2);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					if(birth_date2.length()==0) {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectNameBirth1(name,birth_date1);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}else {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectNameBirth1Birth2(name,birth_date1,birth_date2);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}
				}
			}
		}else {
			if(name.length()==0) {
				if(birth_date1.length()==0) {
					if(birth_date2.length()==0) {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectLogin(login_id);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}else {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectLoginBirth2(login_id,birth_date2);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					if(birth_date2.length()==0) {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectLoginBirth1(login_id,birth_date1);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}else {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectLoginBirth1Birth2(login_id,birth_date1,birth_date2);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}
				}
			}else {
				if(birth_date1.length()==0) {
					if(birth_date2.length()==0) {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectLoginName(login_id,name);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}else {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectLoginNameBirth2(login_id,name,birth_date2);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					if(birth_date2.length()==0) {
						UserDao userDao = new UserDao();
						List<UserBeans>userList= userDao.findSelectLoginNameBirth1(login_id,name,birth_date1);

						request.setAttribute("userList", userList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}else {
						UserDao userDao = new UserDao();
						List<UserBeans>userList = userDao.findSelect(login_id,name,birth_date1,birth_date2);

						request.setAttribute("userList",userList);

						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
						dispatcher.forward(request, response);
					}
				}
			}
		}

	}

}
