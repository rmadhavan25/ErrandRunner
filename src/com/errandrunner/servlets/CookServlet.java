package com.errandrunner.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletConfig;  
import javax.servlet.http.Part; 
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.errandrunner.dao.CookDao;
//import com.errandrunner.dao.CookDishDao;
//import com.errandrunner.dao.CookOrdersDao;
import com.errandrunner.dao.UserDao;
import com.errandrunner.models.CookDishModel;
import com.errandrunner.models.CookModel;
//import com.errandrunner.models.CookOrdersModel;
import com.errandrunner.models.UserModel;


@WebServlet(urlPatterns = {"/cook", "/cook/add-dish","/cook/delete-food","/cook/accept-food","/cook/complete-food"})
public class CookServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public CookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getServletPath();
			
			switch(path) {
			case "/cook/delete-food":
				Dish.deleteDish(request,response);
        		response.sendRedirect("/ErrandRunner/cook-home.jsp");
        		break;
			case "/cook/accept-food":
				Dish.acceptDish(request,response);
				response.sendRedirect("/ErrandRunner/cook-home.jsp");
				break;
			case "/cook/complete-food":
				Dish.completeDish(request,response);
				response.sendRedirect("/ErrandRunner/cook-home.jsp");
				break;
			}
				
		}
		catch(Exception e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response){
			try {
				String path = request.getServletPath();
	        	if(path.equals("/cook/add-dish")) {
	        		Dish.addDish(request, response);
	        		response.sendRedirect("/ErrandRunner/cook-home.jsp");
	        	}
			}
	        	catch(Exception e) {
	        		
	        	}
        
        //} 
    }
	
	 
	
}

class Dish{
	static void addDish(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie userCookie = null;
		Cookie[] cookies = null;

		cookies = request.getCookies();
		String userid = null;
		for(int i = 0;i<cookies.length;i++){
			userCookie = cookies[i];
			if(userCookie.getName().equals("cook")){
				//System.out.println("count");
				userid = userCookie.getValue();
			}
			System.out.println(userCookie.getName()+": "+userCookie.getValue());	
		}
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		String date = request.getParameter("date");
		
		System.out.println("BF" + request.getParameter("breakfast"));
		System.out.println("BF" + request.getParameter("lunch"));
		System.out.println("BF" + request.getParameter("dinner"));
		
		boolean breakfast = request.getParameter("breakfast") != null;
		boolean lunch = request.getParameter("lunch") != null;
		boolean dinner = request.getParameter("dinner") != null;
		
		
		CookModel cook = new CookDao().getCookFromUser(Integer.parseInt(userid));
		  
		
		CookDishModel dish = new CookDishModel(name, price, date,breakfast, lunch, dinner,(short)0, cook);
		new CookDao().saveDish(dish);
			
	}
	
	static void deleteDish(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("dishId"));
		new CookDao().deleteDish(id);
	}
	
	static void acceptDish(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("test 1");
		int id = Integer.parseInt(request.getParameter("dishId"));
		CookDishModel dish = new CookDao().getDishById(id);
		//System.out.println("test 2");
		CookDishModel updatedDish = new CookDishModel(dish.getId(),dish.getName(),dish.getPrice(),dish.getDate(),dish.getBreakfast(),dish.getLunch(),dish.getDinner(),(short)2,dish.getCook(),dish.getUserName(),dish.getUserAddress(),dish.getUserPhone());
		new CookDao().updateDish(updatedDish);
	}
	
	static void completeDish(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("test 1");
		int id = Integer.parseInt(request.getParameter("dishId"));
		CookDishModel dish = new CookDao().getDishById(id);
		System.out.println("test 2");
		CookDishModel updatedDish = new CookDishModel(dish.getId(),dish.getName(),dish.getPrice(),dish.getDate(),dish.getBreakfast(),dish.getLunch(),dish.getDinner(),(short)3,dish.getCook(),dish.getUserName(),dish.getUserAddress(),dish.getUserPhone());
		new CookDao().updateDish(updatedDish);
	}
}
