<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="com.errandrunner.dao.*,com.errandrunner.models.*,com.errandrunner.servlets.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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

.subcardline{
	font-size:30px;
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
  width:20%;
  padding: 8px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius: 0%;
  margin:20px;
}

a.cardButton1:link, a.cardButton1:visited {
  background-color: #00CED1;
  color: white;
  width:50%;
  padding: 8px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  border-radius: 20%;
  margin:20px;
}

.side-headings{
  color:#00CED1;
  text-shadow: 2px 2px 4px #000000;
}
</style>
</head>
<body>


 

<div class="topnav">
  <a class="active" href="#home">Cookhome</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
  <div class="myprofile">
    <button class="myprofile-button">Myprofile</button>
    <div class="myprofile-content">
      <a style="color:black" href="userHistory.jsp">Orders</a>
      <a style="color:black" href="home.jsp">Logout</a>
    </div>
  </div> 
</div>
<br><br>

<%




%>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/errand_runner?useSSL=false"
     user="root"  password="sudha10"/>
 

<h1 class ="side-headings" style="text-align:left;">Available Dishes:</h1><hr>
<sql:query dataSource="${snapshot}" var="result">
SELECT cookdish.price, concat(cookdish.name,'') as dishname, users.name,  cookdish.id from cookdish, cook, users where cookdish.status = 0 and cook.id=cookdish.cookid and users.id=cook.userid;
</sql:query>
<section>
<c:forEach var="row" items="${result.rows}">
<article class="card">
<h1>${row.dishname}</h1>
<h3 style="margin-top: -20px; margin-bottom: -20px">Cook: ${row.name}</h3>
<p class="subcardline"><b>price: Rs</b>${row.price}</p>
<a class="cardButton1" href="/ErrandRunner/user-request/home-food?dishId=${row.id}">Request</a>
</article>
</c:forEach>
</section>

</body>
</html>