package com.errandrunner.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.errandrunner.dao.CookDao;
import com.errandrunner.dao.UserDao;
import com.errandrunner.dao.UserRequestDao;
import com.errandrunner.models.CookDishModel;
import com.errandrunner.models.UserDeliveryRequestModel;
import com.errandrunner.models.UserModel;
import com.errandrunner.models.UserServiceRequestModel;

/**
 * Servlet implementation class UserHomeServlet
 */
@WebServlet(urlPatterns = {"/user-request","/user-request/service","/user-request/deliveries","/user-request/home-food"})
public class UserRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hi - 1");
		try {
			String path = request.getServletPath();
			
			if(path.equals("/user-request/home-food") ) {
				System.out.println("hi");
				HomeFood.requestDish(request, response);
				response.sendRedirect("/ErrandRunner/userDishPage.jsp");
			}
		}
		catch(Exception e) {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	try {
		String action = request.getServletPath().split("/")[2];
        
  	  switch(action) {
  	  	case "service": 
  	  		Service.doPostNewServiceRequest(request, response);
  	  		break;
  	  	case "deliveries": 
  	  		Delivery.doPostNewDeliveryRequest(request, response);
  	  		break;
  	  	default:
  	  		HelperFunctions.notFound(request, response);
  	  }
  	response.sendRedirect("/ErrandRunner/userHome.jsp");
	}
	catch (Exception ex) {
		
	}

}
	
}

class Service{
	
	static UserServiceRequestModel doPostNewServiceRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException {
		
		String jobType = request.getParameter("jobType");
        String description = request.getParameter("description");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        
        UserModel user = new UserDao().getUserByPhone(phone);
        
        UserServiceRequestModel newService = new UserServiceRequestModel(jobType,description,address,phone,user);
        new UserRequestDao().saveService(newService);
        return newService;
	}
	
static UserDeliveryRequestModel doPostNewDeliveryRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException {
		
		String pickupAddress = request.getParameter("pickupAddress");
		String dropAddress = request.getParameter("dropAddress");
        String items = request.getParameter("items");
        String description = request.getParameter("description");
        String phone = request.getParameter("phone");
        
        UserModel user = new UserDao().getUserByPhone(phone);
        
        UserDeliveryRequestModel newDelivery = new UserDeliveryRequestModel(pickupAddress,dropAddress,items,description,phone,user);
        new UserRequestDao().saveDelivery(newDelivery);
        return newDelivery;
	}
}

class Delivery{
	
	static UserDeliveryRequestModel doPostNewDeliveryRequest(HttpServletRequest request, HttpServletResponse response)throws SQLException, IOException, ServletException {
		
		String pickupAddress = request.getParameter("pickupAddress");
		String dropAddress = request.getParameter("dropAddress");
        String items = request.getParameter("items");
        String description = request.getParameter("description");
        String phone = request.getParameter("phone");
        
        UserModel user = new UserDao().getUserByPhone(phone);
        
        UserDeliveryRequestModel newDelivery = new UserDeliveryRequestModel(pickupAddress,dropAddress,items,description,phone,user);
        new UserRequestDao().saveDelivery(newDelivery);
        return newDelivery;
	}
}

class HomeFood{
	static void requestDish(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie userCookie = null;
		Cookie[] cookies = null;

		cookies = request.getCookies();
		String userid = null;
		for(int i = 0;i<cookies.length;i++){
			userCookie = cookies[i];
			if(userCookie.getName().equals("user")){
				//System.out.println("count");
				userid = userCookie.getValue();
			}
			System.out.println(userCookie.getName()+": "+userCookie.getValue());	
		}
		
		UserModel user = new UserDao().getUser(Integer.parseInt(userid));
		
		System.out.println("test 1");
		int id = Integer.parseInt(request.getParameter("dishId"));
		CookDishModel dish = new CookDao().getDishById(id);
		System.out.println("test 2");
		CookDishModel updatedDish = new CookDishModel(dish.getId(),dish.getName(),dish.getPrice(),dish.getDate(),dish.getBreakfast(),dish.getLunch(),dish.getDinner(),(short)1,dish.getCook(),user.getName(),user.getUserAddress(),user.getPhone());
		new CookDao().updateDish(updatedDish);
	}
}


