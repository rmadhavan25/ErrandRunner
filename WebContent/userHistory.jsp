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
  <a class="active" href="#Order History">Userhome</a>
  <a href="#Services">Services</a>
  <a href="#Deliveries">Deliveries</a>
  <a href="#Food">Food Orders</a>
</div>

<h1 class ="side-headings" style="text-align:left;">Services:</h1><hr>

<section id="Services">
<%
List<UserServiceRequestModel> serviceList = new UserRequestDao().getUserServices("9655569935") ;
for(UserServiceRequestModel sl: serviceList ){
	short slstatus = sl.getStatus();
	//System.out.println(status);
	String slcurrentStatus;
	switch(slstatus){
	case 0:
		slcurrentStatus = "Service Requested";
		break;
	case 1:
		slcurrentStatus = "Service Accepted";
		break;
	case 2:
		slcurrentStatus = "Service Completed Successfully";
		break;
	default:
		slcurrentStatus = "Oops Error!";
		break;
	}
	pageContext.setAttribute("slstatus", slcurrentStatus);
	%>
	<div class="card">
  <h1><%= sl.getJobType() %></h1>
  <p class="price"><b>cost:</b> $19.99</p>
  <p><b>Status: </b>"${slstatus}"</p>
  <p><b>##<%=sl.getOrderid() %>: </b><%= sl.getDescription() %></p>
  <p><button>More</button></p>
</div>
<%} %>
</section>

<section id="Deliveries">
<h1 class ="side-headings" style="text-align:left;">Deliveries:</h1><hr>

<%
List<UserDeliveryRequestModel> deliveryList = new UserRequestDao().getUserDeliveries("9655569935") ;
for(UserDeliveryRequestModel dl : deliveryList ){
	short status = dl.getStatus();
	//System.out.println(status);
	String currentStatus;
	switch(status){
	case 0:
		currentStatus = "Order Placed";
		break;
	case 1:
		currentStatus = "Order accepted and in process";
		break;
	case 2:
		currentStatus = "Order Delivered Successfully";
		break;
	default:
		currentStatus = "Oops Error!";
		break;
	}
	pageContext.setAttribute("status", currentStatus);
	%>
	<div class="card">
  <h1>Delivery</h1>
  <p class="price"><b>cost:</b> $19.99</p>
  <p><b>Status: </b>"${status}"</p>
  <p><b>##<%=dl.getDeliveryid() %>: </b><%=dl.getItems() %></p>
  <p><b>From: </b><%=dl.getPickupAddress() %></p>
  <p><button>More</button></p>
</div>
<%} %>
</section>

<section id="Food">
<h1 class ="side-headings" style="text-align:left;">Food Orders:</h1><hr>


<div class="card">
  <h1>Food</h1>
  <p class="price"><b>cost:</b> $19.99</p>
  <p><b>Festive Preparation</b> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat</p>
  <p><button>More</button></p>
</div>
<div class="card">
  <h1>Food</h1>
  <p class="price"><b>cost:</b> $19.99</p>
  <p><b>Festive Preparation</b> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat</p>
  <p><button>More</button></p>
</div>
</section>

</body>
</html>