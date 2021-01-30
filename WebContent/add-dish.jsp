<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: white;
 /*background-image: url("https://thumbs.dreamstime.com/b/ingredients-cooking-cast-iron-skillet-old-wooden-table-food-background-concept-copyspace-51773497.jpg");*/
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}
    input:focus, textarea:focus, select:focus{
        outline: none;
    }
/* Full-width input fields */
.dname{
	  width:400px;
	  padding:8px;
	  display:block;
	  background-color:#f1f1f1;
	  border-radius:8px 8px;
}
#dish{
		font-weight:bold;
		font-size:17px;
		outline:none;
		border:none;
		display:inline-block;
		height:30px;
		width:380px;
		background-color:#f1f1f1;
}
.price{
	width:10%;
	font-size:17px;
	font-weight:bold;
	margin:10px 2px;
	padding:7px;
	display:inline-block;
	background:#f1f1f1;
	border-radius:8px 8px;
}
#dprice{
		font-weight:bold;
		font-size:17px;
		outline:none;
		border:none;
		display:inline-block;
		height:30px;
		width:80px;
		background-color:#f1f1f1;
}

.item {
	margin:30px 5px;
}

.labdate input{
	  margin:15px 0px;
	  width:150px;
	  padding:4px;
	  display:block;
	  background-color:#f1f1f1;
	  border-radius:8px 8px;
}

#imageup input{
	margin:0px 0px;
	height:25px;
	width:250px;
	border-radius:8px 8px;
}
#up{
	margin:10px 50px;
}

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

<form action="/ErrandRunner/cook/add-dish" method="POST">
  <div class="container">
    <h1>Dish Description</h1>
    <hr>
    <label>Dish Name</label><br><br>
	<div class="dname">
	    <input type="text" name="name" id="dish" required>
	</div>
	    <br>
	    <label>Price</label><br>
	    <!-- // css example
	span {
	  content: "\20B9";
	  
	} -->
	<div class="price">
	<span>&#8377;</span>
	<input type="number" name="price" id="dprice" maxlength=5 required>
	</div>
	
	<br>
	
   <div class="item">
	  <input type="checkbox" id="breakfast" name="breakfast">
	  <label for="breakfast">Breakfast</label>
	  <input type="checkbox" id="lunch" name="lunch">
	  <label for="lunch">Lunch</label>
	  <input type="checkbox" id="Dinner" name="dinner">
	  <label for="Dinner">Dinner</label>
  </div>
     <div class="labdate">
     	<label>Date</label>
     	<input type="date" id="date" name="date" required>
     </div>
	<!-- <div class="fileupload">
	      <h5>Choose image</h5>
         <input type="file" name="image" size = "20" id="imageup" required/>
      </div> -->
    <hr>
    <br>
    <button type="submit" class="registerbtn">Add Dish</button>
 </div>
 </form>
</body>
</html>