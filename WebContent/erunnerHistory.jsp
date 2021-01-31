<%@page import="com.errandrunner.dao.ErunnerDao"%>
<%@page import="com.errandrunner.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.errandrunner.models.UserServiceRequestModel,com.errandrunner.models.UserDeliveryRequestModel,com.errandrunner.dao.UserRequestDao,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
  body {
  margin: 0px;
}
.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #40E0D0;
  color: white;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.8);
  width:70%;
  margin: auto;
  margin-bottom: 20px;
  text-align: center;
  font-family: arial;
  background-color: lightgrey;
  padding: 10px;
}

.price {
  color: grey;
  font-size: 22px;
}

.headings {
  color: #F08080;
  font-size: 40px;
  text-shadow: 2px 2px 4px #333;
}

.side-headings{
  color:#F08080;
  text-shadow: 2px 2px 4px #000000;
}

a.cardButton:link, a.cardButton:visited {
  background-color: #E9967A;
  color: white;
  padding: 8px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius: 20%;
}



a.cardButton:hover, a.cardButton:active {
  background-color: #FFA07A;
}

.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #F08080;
  text-align: center;
  cursor: pointer;
  width: 20%;
  font-size: 18px;
  border-radius: 25px;
}

.card button:hover {
  opacity: 0.7;
}
</style>
</head>
<body>

<!-- <h1 class ="headings" style="text-align:center">Order History</h1><br><br> -->
<div class="topnav">
  <a class="active" href="#Order History">Erunnerhome</a>
  <a href="#Services">Services</a>
  <a href="#Deliveries">Deliveries</a>
  <a href="#Food">Food Orders</a>
</div>

<h1 class ="side-headings" style="text-align:left;">Current Errand:</h1><hr>

<%
Cookie userCookie = null;
Cookie[] cookies = null;

cookies = request.getCookies();
String userid = null;
for(int i = 0;i<cookies.length;i++){
	userCookie = cookies[i];
	if(userCookie.getName().equals("erunner")){
		//System.out.println("count");
		userid = userCookie.getValue();
	}
	System.out.println(userCookie.getName()+": "+userCookie.getValue());	
}

List<UserServiceRequestModel> serviceList = new UserRequestDao().getUserServicesByErunnerId(new ErunnerDao().getByMainUserId(Integer.parseInt(userid)).getId()) ;
List<UserDeliveryRequestModel> deliveryList = new UserRequestDao().getUserDeliveriesByErunnerId(new ErunnerDao().getByMainUserId(Integer.parseInt(userid)).getId());
%>
<section id="current order">
<%

for(UserServiceRequestModel sl: serviceList ){
	short slstatus = sl.getStatus();
	//System.out.println(status);
	String slcurrentStatus;
	switch(slstatus){
	case 1:
		slcurrentStatus = "Service Accepted";
		pageContext.setAttribute("slstatus", slcurrentStatus);
		%>
		<div class="card">
  		<h1><%= sl.getJobType() %></h1>
  		<p class="price"><b>cost:</b> $19.99</p>
  		<p><b>Status: </b>"${slstatus}"</p>
 	 	<p><b>##<%=sl.getOrderid() %>: </b><%= sl.getDescription() %></p>
 	 	<p><b>Address: </b><%=sl.getAddress() %></p>
		<p><b>Contact: </b><%=sl.getPhone() %></p>
 		<a class="cardButton" href="/ErrandRunner/erunner-complete/service?serviceId=<%=sl.getOrderid() %>">Click to complete service</a>
		</div>
		<%break;
	case 2:
		slcurrentStatus = "Service Completed Successfully";
		break;
	default:
		slcurrentStatus = "Oops Error!";
		break;
	}
	
}
for(UserDeliveryRequestModel dl: deliveryList ){
	short dlstatus = dl.getStatus();
	//System.out.println(status);
	String dlcurrentStatus;
	switch(dlstatus){
	case 1:
		dlcurrentStatus = "Delivery Accepted";
		pageContext.setAttribute("dlstatus", dlcurrentStatus);
		%>
		<div class="card">
  		<h1><%= dl.getItems() %></h1>
  		<p class="price"><b>cost:</b> $19.99</p>
  		<p><b>Status: </b>"${dlstatus}"</p>
 	 	<p><b>##<%=dl.getDeliveryid() %>: </b><%= dl.getDescription() %></p>
 	 	<p><b>PickUp Address: </b><%=dl.getPickupAddress() %></p>
		<p><b>Drop Address: </b><%=dl.getDropAddress() %></p>
		<p><b>Contact: </b><%=dl.getPhone() %></p>
 		<a class="cardButton" href="/ErrandRunner/erunner-complete/delivery?deliveryId=<%=dl.getDeliveryid() %>">Click to complete delivery</a>
		</div>
		<%break;
	case 2:
		dlcurrentStatus = "Service Completed Successfully";
		break;
	default:
		dlcurrentStatus = "Oops Error!";
		break;
	}
	
	%>
	
<%} %>
</section>

<h1 class ="side-headings" style="text-align:left;">Completed Errands:</h1><hr>
<section id="previous errands">
<%

for(UserServiceRequestModel sl: serviceList ){
	short slstatus = sl.getStatus();
	//System.out.println(status);
	String slcurrentStatus;
	switch(slstatus){
	case 2:
		slcurrentStatus = "Service Completed Successfully";
		pageContext.setAttribute("slstatus", slcurrentStatus);
		%>
		<div class="card">
		  <h1><%= sl.getJobType() %></h1>
		  <p class="price"><b>cost:</b> $19.99</p>
		  <p><b>Status: </b>"${slstatus}"</p>
		  <p><b>##<%=sl.getOrderid() %>: </b><%= sl.getDescription() %></p>
		  <p><b>Address: </b><%=sl.getAddress() %></p>
		</div>
		<%break;
	default:
		slcurrentStatus = "Oops Error!";
		break;
	}
	
}
for(UserDeliveryRequestModel dl: deliveryList ){
	short dlstatus = dl.getStatus();
	//System.out.println(status);
	String dlcurrentStatus;
	switch(dlstatus){
	case 2:
		dlcurrentStatus = "Service Completed Successfully";
		pageContext.setAttribute("dlstatus", dlcurrentStatus);
		%>
		<div class="card">
  		<h1><%= dl.getItems() %></h1>
  		<p class="price"><b>cost:</b> $19.99</p>
  		<p><b>Status: </b>"${dlstatus}"</p>
 	 	<p><b>##<%=dl.getDeliveryid() %>: </b><%= dl.getDescription() %></p>
 	 	<p><b>PickUp Address: </b><%=dl.getPickupAddress() %></p>
		<p><b>Drop Address: </b><%=dl.getDropAddress() %></p>
		</div>
		<%break;
	default:
		dlcurrentStatus = "Oops Error!";
		break;
	}
	
	%>
	
<%} %>
</section>
</body>
</html>