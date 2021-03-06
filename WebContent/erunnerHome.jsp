<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.errandrunner.models.UserServiceRequestModel,com.errandrunner.models.UserDeliveryRequestModel,com.errandrunner.servlets.ErunnerServlet,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap');
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0px;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
  width:100%;
  display:flex;
}

.container-1 {
  padding: 64px;
}

.row-1:after {
  content: "";
  display: table;
  clear: both
}
.carousel-inner img {
    width: 100%;
    height: 100%;
  }
  .row1 {
	background-image:url("https://images.unsplash.com/photo-1500822976077-ea303cfdc9b4?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80");
	background-repeat: no-repeat;
  	display: flex;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

input[name="filter"] {
  border: 2px solid grey;
  border-radius: 10px 10px 10px 10px;
  font-size: 18px;
  padding: 5px;
  height: 35px;
  width: 500px;
}
input::-webkit-calendar-picker-indicator {
/*   display: none; */
}
/* Overwrite default styles of hr */
hr {
  border-bottom: 5px solid grey;
  margin-bottom: 25px;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
.searchbtn{
	color:white;
    background-color:#00CED1;
    border-radius:15px;
}

.myprofile {
  float: right;
  overflow: hidden;
}

.myprofile .myprofile-button {
   font-size: 18px;  
   border: none;
   outline: none;
  color: white; 
  background-color: #333;
  padding: 14px 16px;
  font-family: inherit;
  margin: 0;
}

.myprofile-content {
  right: 0;
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.myprofile-content a {

  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.myprofile-content a:hover {
  background-color: #ddd;
}

.myprofile:hover .myprofile-content {
  display: block;
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

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

.verticalhorizontal {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100%;
}

h1 {
	color:	#008B8B;
	font-size: 30px;
}

b{
	color: black;
}

.serviceh1 {
	font-size: 50px;
}


html{
  /*background-image: linear-gradient(to right, #4facfe 0%, #00f2fe 100%);*/
  font-family: 'Roboto', sans-serif;
}

section{
  display: flex;
  width: 100%;
  flex-wrap:wrap;
  justify-content:center;
}

.card {
    margin: 2.5%;
    padding: 2.5%;
    color: #171717;
    border-radius: 16px;
    background-color: #DCDCDC;
    display: flex;
    flex-direction: column;
    justify-content: center;
    width:20em;
    box-shadow: -15px 15px 10px rgba(0, 206, 209,0.2), 0 1px 2px rgba(0,0,0,0.24);
    transition: all 0.5s cubic-bezier(.25,.8,.25,1);
}

.card:hover {
    box-shadow: -15px 15px 28px #00CED1, 0 10px 10px #171717;
    transform: scale(1.05);;
}
a.cardButton:hover, a.cardButton:active {
  background-color: #00CED1;
}
#FFA07A
a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

a.cardButton:link, a.cardButton:visited {
  background-color: #00CED1;
  color: white;
  width:50%;
  padding: 8px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius: 25%;
}

</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="#home">Erunnerhome</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
  <div class="myprofile">
    <button class="myprofile-button">Myprofile</button>
    <div class="myprofile-content">
      <a  style="color:black" href="erunnerProfile.jsp">My Profile</a>
      <a style="color:black" href="erunnerHistory.jsp">Orders</a>
      <a style="color:black" href="/ErrandRunner/logout">Logout</a>
    </div>
  </div> 
</div>

<form method="GET" action="/ErrandRunner/erunner" name="get_results">
  <div class="container">
    <hr>
     <input list="filter" name="filter" placeholder="choose filter">

    <datalist id="filter">
      <option value="Service">
      <option value="Delivery">
    </datalist><br><br>

    <button type="submit" class="searchbtn">Search</button>
  </div>
  
  <hr>
  
</form>

<section>
<%
	List<UserServiceRequestModel> serviceList = (List<UserServiceRequestModel>)request.getSession().getAttribute("serviceList");
	List<UserDeliveryRequestModel> deliveryList = (List<UserDeliveryRequestModel>)request.getSession().getAttribute("deliveryList");
	//if(request.getAttribute("deliverList")!=null)
		//System.out.println("delivery is not null");
	if(serviceList == null && deliveryList == null){%>
			<%--System.out.println("in both"); --%>
			<div class="container-1" style="background-color:#f1f1f1">
  <div class="row-1">
    	<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
			<div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://images.unsplash.com/photo-1505582866941-6788e0205dd2?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80" alt="Los Angeles" width="1100" height="500">
    </div>
    <div class="carousel-item">
      <img src="https://images.unsplash.com/photo-1513430698680-03ff4d6be961?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80" alt="Chicago" width="1100" height="500">
    </div>
    <div class="carousel-item">
      <img src="https://images.unsplash.com/photo-1513267048331-5611cad62e41?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=750&q=80" alt="New York" width="1100" height="500">
    </div>
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
  </div>
  </div>
</div>
	<%}
	else if(serviceList != null){
		//System.out.println("in service 1");
		for(UserServiceRequestModel sl : serviceList){
			if(sl.getStatus()==0){%>
			<%-- System.out.println("in service 2");--%>
			<article class="card">
    		<h1 class="serviceh1"><%=sl.getJobType() %></h1>
    		<p><b>Address: </b><%=sl.getAddress() %></p>
    		<a class="cardButton" href="/ErrandRunner/erunner-request/service?sid=<%=sl.getOrderid()%>">Go</a>
  			</article>
  			<% }
		}
	}
		else{
			//System.out.println("in delivery 1");
			for(UserDeliveryRequestModel dl:deliveryList){
			if(dl.getStatus()==0){%>
			
			<%-- System.out.println("in delivery 2");--%>
			<article class="card">
    		<h1><b>Pick up: </b><%=dl.getPickupAddress() %></h1>
    		<p><b>Drop: </b><%=dl.getDropAddress()%></p>
    		<a class="cardButton" href="/ErrandRunner/erunner-request/delivery?did=<%=dl.getDeliveryid()%>">Go</a>
  			</article>
  			<%}
		}
	}
	
%>

</section>
<script type="text/javascript">
  var main = function () {
    $('.card').on('mouseenter', function() {
      $(this).find('.card-text').slideDown(300);
    });
  
    $('.card').on('mouseleave', function(event) {
       $(this).find('.card-text').css({
         'display': 'none'
       });
     });
};
$(document).ready(main);

</script>
  
 <!--   <article class="card">
    <h1>Card Title</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    <a class="cardButton" href="default.asp">Go</a>
  </article>
  <article class="card">
    <h1>Card Title</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    <a class="cardButton" href="default.asp">Go</a>
  </article>
  <article class="card">
    <h1>Card Title</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
        <a class="cardButton" href="default.asp">Go</a>
  </article>
  <article class="card">
    <h1>Card Title</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    <a class="cardButton" href="default.asp">Go</a>
  </article>
  <article class="card">
    <h1>Card Title</h1>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    <a class="cardButton" href="default.asp">Go</a>
  </article>
</section> -->

<!-- <div class="verticalhorizontal">
    <img src="https://techreviewpro-techreviewpro.netdna-ssl.com/wp-content/uploads//2015/06/404-Error-Funny-HTTP-Not-Found-Page-Design.jpg" alt="centered image" />
</div> -->



</body>
</html>