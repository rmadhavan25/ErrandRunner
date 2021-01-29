package com.errandrunner.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.errandrunner.dao.UserDao;
import com.errandrunner.dao.UserRequestDao;
import com.errandrunner.models.UserDeliveryRequestModel;
import com.errandrunner.models.UserModel;
import com.errandrunner.models.UserServiceRequestModel;

/**
 * Servlet implementation class UserHomeServlet
 */
@WebServlet(urlPatterns = {"/user-request","/user-request/service","/user-request/deliveries"})
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


