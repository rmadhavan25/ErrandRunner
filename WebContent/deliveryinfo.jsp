<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.errandrunner.models.UserDeliveryRequestModel,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: white;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
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

input[name="jobType"] {
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
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #40E0D0;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
  font-size: 20px;
}

.registerbtn:hover {
  opacity: 1;
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
</style>
</head>
<body>
<%
	UserDeliveryRequestModel deliveryinfo = (UserDeliveryRequestModel)request.getAttribute("delivery");
	String pickup = deliveryinfo.getPickupAddress();
	String drop = deliveryinfo.getDropAddress();
	String items = deliveryinfo.getItems();
	String description = deliveryinfo.getDescription();
	String userPhone = deliveryinfo.getPhone();
	int deliveryId = deliveryinfo.getDeliveryid();
	
	pageContext.setAttribute("pickup", pickup);
	pageContext.setAttribute("drop",drop);
	pageContext.setAttribute("items",items);
	pageContext.setAttribute("description",description);
	pageContext.setAttribute("phone",userPhone);
	pageContext.setAttribute("deliveryId",deliveryId);
%>
<form action="/ErrandRunner/erunner-delivery/accept" method="post">
  <div class="container">
    <h1>Delivery Information</h1>
    <hr>
	
	<label for="deliveryId"><b>Delivery ID: </b></label><br><br>
    <input type="text" value="${deliveryId}" name="deliveryId" id="deliveryId" readonly>
	
    <label for="pickupAddress"><b>Pickup Address/Store Name</b></label><br><br>
    <input type="text" value="${pickup}" name="pickupAddress" id="pickupAddress" readonly>

    <label for="dropAddress"><b>Drop Address</b></label><br><br>
    <input type="text" value="${drop}" name="dropAddress" id="dropAddress" readonly>

    <label for="items"><b>Items</b></label><br><br>
    <input type="text" value="${items}" name="items" id="items" readonly>

    <label for="description"><b>Description/Note</b></label><br><br>
    <textarea name="description" rows="10" cols="70" maxlength="500" value="${description}" readonly></textarea><br><br>


    <label for="phone"><b>Contact No</b></label><br><br>
    <input type="text" value="${phone}" name="phone" id="phone" readonly>


    
    <hr>
    <button type="submit" class="registerbtn">Accept Request</button>
  </div>
  
</form>

</body>
</html>