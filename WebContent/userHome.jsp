<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

* {
  box-sizing:border-box;
}
body {
  margin: 0px;
  font-family: Arial, Helvetica, sans-serif;
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
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  margin-top: 100px;
  text-align: center;
  font-family: arial;
  flex: 50%;
  padding: 5px;
}

.title {
  color: grey;
  font-size: 18px;
}

h1 {
  color: #CD853F;
}


a {
  text-decoration: none;
  font-size: 22px;
  color: black;
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

.row {
  display: flex;
}



a.cardButton:hover, a.cardButton:active {
  background-color: #FFA07A;
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


</style>
</head>

<body>

  <!---nav bar*-->
<div class="topnav">
  <a class="active" href="#home">Userhome</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
  <div class="myprofile">
    <button class="myprofile-button">Myprofile</button>
    <div class="myprofile-content">
      <a href="userProfile.jsp">My Profile</a>
      <a href="userHistory.jsp">Orders</a>
      <a href="/ErrandRunner/logout">Logout</a>
    </div>
  </div> 
</div>

<!---user home cards-->
<div class="row">

<!---service card-->
<div class="card">
  <img src="https://image.shutterstock.com/image-vector/phone-whis-voice-assistantthere-many-600w-1471139045.jpg" alt="service" style="width:80%">
  <h1>Services</h1>
  <!--<a  class="cardButton" href="default.asp" target="_blank">Register</a>-->
  <p class="title">Get wide variety<br> of services done</p>
  <a class="cardButton" href="userServiceForm.jsp">Go</a>
</div>

<!---deliveries card-->
<div class="card">
  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9N4Fvsiuv8ma-kvMXRFEJowWANI1JdLe4Gg&usqp=CAU" alt="deliveries" style="width:100%">
  <h1>Deliveries</h1>
  <p class="title">Get anything<br> delivered from<br> anywhere</p>
  <a class="cardButton" href="userDeliveryRequestForm.jsp">Go</a>
  <!--<a  class="cardButton" href="default.asp" target="_blank">Register</a>-->
</div>

<!---home food card-->
<div class="card">
  <img src="https://previews.123rf.com/images/moloko88/moloko881809/moloko88180900003/109815610-hand-drawn-typography-poster-inspirational-vector-typography-homemade-food-.jpg" alt="homefood" style="width:75%">
  <h1>Home Food</h1>
  <p class="title">Delicious Food<br> From any<br> home around you</p>
  <a class="cardButton" href="userDishPage.jsp">Go</a>
  <!--<a  class="cardButton" href="default.asp" target="_blank">Register</a>-->
</div>

</div>



</body>

</html>