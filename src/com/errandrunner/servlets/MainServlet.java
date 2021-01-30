package com.errandrunner.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.errandrunner.dao.CookDao;
import com.errandrunner.dao.UserDao;
import com.errandrunner.models.CookModel;
import com.errandrunner.models.ErunnerModel;
import com.errandrunner.models.UserModel;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(urlPatterns = {"/", "/logout"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/logout")) {
			handleLogout(request, response);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			return;
		}
		
		// TODO Auto-generated method stub
		Cookie cookies[] = request.getCookies();
		for(Cookie cookie: cookies) {
			if(cookie.getName().equals("user")) {
				response.sendRedirect("/ErrandRunner/userHome.jsp");
				return;
			}
			else if(cookie.getValue().equals("cook")) {
				response.sendRedirect("/ErrandRunner/cook-home.jsp");
				return;
			}
			else if(cookie.getValue().equals("erunner")) {
				response.sendRedirect("/ErrandRunner/erunnerHome.jsp");
				return;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);

	}
	
	void handleLogout(HttpServletRequest req, HttpServletResponse res) {
		Cookie cookies[] = req.getCookies();
		for(Cookie cookie: cookies) {
			String name = cookie.getName();
			if(name.equals("user") || name.equals("cook") || name.equals("erunner")) {
				cookie.setMaxAge(0);
			}
		}	
	}

}
