package com.errandrunner.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.errandrunner.dao.ErunnerDao;
import com.errandrunner.dao.UserDao;
import com.errandrunner.dao.UserRequestDao;
import com.errandrunner.models.ErunnerModel;
import com.errandrunner.models.UserDeliveryRequestModel;
import com.errandrunner.models.UserModel;
import com.errandrunner.models.UserServiceRequestModel;

/**
 * Servlet implementation class ErunnerServlet
 */
@WebServlet(urlPatterns = {"/erunner","/erunner-request/service","/erunner-request/delivery","/erunner-service/accept","/erunner-delivery/accept"})
public class ErunnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErunnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String action = request.getServletPath().split("/")[1];
	        if(action.equals("erunner")) {
	        	Errand.doGetResults(request, response);
	        	response.sendRedirect("/ErrandRunner/erunnerHome.jsp");
	        }
	        else if(action.equals("erunner-request")) {
	        	//System.out.println("tracked the address");
	        	Errand.doGetParticular(request,response);
	        }
	        	
		}
		catch (Exception ex) {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			String action = request.getServletPath().split("/")[2];
	        
	  	  switch(action) {
	  	  	case "accept":
		  		Transaction.assignNewErunner(request,response);
	  	  	default:
	  	  		HelperFunctions.notFound(request, response);
	  	  }
	  	response.sendRedirect("/ErrandRunner/erunnerHome.jsp");
		}
		catch (Exception ex) {
			
		}
	}

}

class Errand{
	
	static void doGetResults(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(request.getParameter("filter").equals("Service")) {
			//System.out.println("about to call servlet");
			Errand.doGetServices(request,response);
		}
		else if(request.getParameter("filter").equals("Delivery")){
			Errand.doGetDeliveries(request, response);
		}
		else
			Errand.doGetServicesAndDeliveries(request, response);
	}
	
	static void doGetParticular(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		if(request.getParameter("sid")!=null)
			Errand.doGetParticularService(request,response);
		else if(request.getParameter("did")!=null)
			Errand.doGetParticularDelivery(request, response);
	}
	
	static void doGetParticularService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("sid"));
		UserServiceRequestModel service = new ErunnerDao().getAService(id) ;
		//System.out.println("about to call servlet");
		request.setAttribute("service", service);
		//response.sendRedirect("/ErrandRunner/");
		request.getRequestDispatcher("/serviceinfo.jsp").forward(request, response);
	}
	static void doGetParticularDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("did"));
		UserDeliveryRequestModel delivery = new ErunnerDao().getADelivery(id) ;
		//System.out.println("about to call servlet");
		request.setAttribute("delivery", delivery);
		//response.sendRedirect("/ErrandRunner/");
		request.getRequestDispatcher("/deliveryinfo.jsp").forward(request, response);
	}
	static void doGetServices(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//System.out.println("inside servlet");
		List<UserServiceRequestModel> serviceList = new ErunnerDao().getAllServices() ;
		//System.out.println("about to call servlet");
		request.getSession().setAttribute("serviceList", serviceList);
		request.getSession().setAttribute("deliveryList", null);
		response.sendRedirect(request.getHeader("Referer"));
	}
	
	static void doGetDeliveries(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<UserDeliveryRequestModel> deliveryList = new ErunnerDao().getAllDeliveries() ;
		//System.out.println("test1");
		request.getSession().setAttribute("serviceList", null);
		request.getSession().setAttribute("deliveryList", deliveryList);
		//System.out.println("test2");
		response.sendRedirect(request.getHeader("Referer"));
	}
	
	static void doGetServicesAndDeliveries(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<UserServiceRequestModel> serviceList = new ErunnerDao().getAllServices() ;
		List<UserDeliveryRequestModel> deliveryList = new ErunnerDao().getAllDeliveries() ;
		request.getSession().setAttribute("serviceList", serviceList);
		request.getSession().setAttribute("deliveryList", deliveryList);
		response.sendRedirect(request.getHeader("Referer"));
	}
}


class Transaction{
	static void assignNewErunner(HttpServletRequest request, HttpServletResponse response) {
		try {
			String action = request.getServletPath().split("/")[1];
			
			switch(action) {
			case "erunner-service":
				Transaction.newServiceErunner(request,response);
				response.sendRedirect("/ErrandRunner/erunnerHome.jsp");
				break;
			case "erunner-delivery":
				Transaction.newDeliveryErunner(request,response);
				response.sendRedirect("/ErrandRunner/erunnerHome.jsp");
				break;
			default:
				HelperFunctions.notFound(request, response);
				break;
			}
		}
		catch(Exception e) {
			
		}
	
	}
	
	static void newServiceErunner(HttpServletRequest request, HttpServletResponse response) {
		
		int serviceid = Integer.parseInt(request.getParameter("serviceId"));
		UserModel userid = new UserDao().getUserByPhone(request.getParameter("phone"));
		Cookie userCookie = null;
		Cookie[] cookies = null;

		cookies = request.getCookies();
		String userid1 = null;
		for(int i = 0;i<cookies.length;i++){
			userCookie = cookies[i];
			if(userCookie.getName().equals("erunner")){
				//System.out.println("count");
				userid1 = userCookie.getValue();
			}
			System.out.println(userCookie.getName()+": "+userCookie.getValue());	
		}
		ErunnerModel erunnerid = new ErunnerDao().getByMainUserId(userid1);
		//UserServiceRequestModel tableUpdate;
		//tableUpdate.set
		//System.out.println("inside the required block 1");
		String jobType = request.getParameter("jobType");
        String description = request.getParameter("description");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        //System.out.println("inside the required block 2");
        //String erunnerid = request.getParameter("erunnerid");
        UserServiceRequestModel updatedErunner = new UserServiceRequestModel(serviceid,jobType,description,address,phone,(short)1,userid,erunnerid);
        //System.out.println("inside the required block 3");
        new UserRequestDao().updateService(updatedErunner);
        
	}
	
	static void newDeliveryErunner(HttpServletRequest request, HttpServletResponse response) {
		int deliveryid = Integer.parseInt(request.getParameter("deliveryId"));
		UserModel userid = new UserDao().getUserByPhone(request.getParameter("phone"));
		Cookie userCookie = null;
		Cookie[] cookies = null;

		cookies = request.getCookies();
		String userid1 = null;
		for(int i = 0;i<cookies.length;i++){
			userCookie = cookies[i];
			if(userCookie.getName().equals("erunner")){
				//System.out.println("count");
				userid1 = userCookie.getValue();
			}
			System.out.println(userCookie.getName()+": "+userCookie.getValue());	
		}
		ErunnerModel erunnerid = new ErunnerDao().getByMainUserId(userid1);
		//UserServiceRequestModel tableUpdate;
		//tableUpdate.set
		//System.out.println("inside the required block 1");
		String pickupAddress = request.getParameter("pickupAddress");
		String dropAddress = request.getParameter("dropAddress");
        String items = request.getParameter("items");
        String description = request.getParameter("description");
        String phone = request.getParameter("phone");
        //System.out.println("inside the required block 2");
        //String erunnerid = request.getParameter("erunnerid");
        UserDeliveryRequestModel updatedErunner = new UserDeliveryRequestModel(deliveryid,pickupAddress,dropAddress,items,description,phone,(short)1,userid,erunnerid);
        //System.out.println("inside the required block 3");
        new UserRequestDao().updateDelivery(updatedErunner);
	}
}