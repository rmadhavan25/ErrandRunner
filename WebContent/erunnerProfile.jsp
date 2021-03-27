<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.errandrunner.models.UserModel,com.errandrunner.dao.UserDao,java.util.*,com.errandrunner.models.ErunnerModel,com.errandrunner.dao.ErunnerDao"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #E9967A;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #FFA07A;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}

.avatar {
  vertical-align: middle;
  width: 300px;
  height: 300px;
  border-radius: 50%;
}
</style>
</head>
<body>

<img src="https://images2.minutemediacdn.com/image/upload/c_fill,w_360,ar_1:1,f_auto,q_auto,g_auto/shape/cover/entertainment/mm-user-avatar-male-c5a9b6db28d293c7381495271bdda4ad.png" alt="Avatar" class="avatar">
<br><br>
<h1>Welcome User!</h1>
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
	UserModel user = new UserDao().getUser(Integer.parseInt(userid));
	String name = user.getName();
	String email = user.getEmail();
	String phone = user.getPhone();
	int id = user.getId();
	ErunnerModel erunner = new ErunnerDao().getByMainUserId(Integer.parseInt(userid));
	
	String aadhar = erunner.getAadhar();
	String jobs = erunner.getJobs();
	int erunnerId = erunner.getId();
	
	pageContext.setAttribute("name", name);
	pageContext.setAttribute("email",email);
	pageContext.setAttribute("phone",phone);
	pageContext.setAttribute("aadhar",aadhar);
	pageContext.setAttribute("jobs",jobs);
	pageContext.setAttribute("userid",id);
	pageContext.setAttribute("erunnerid",erunnerId);
%>
<div class="container">
  <form action="/ErrandRunner/user/update/erunner" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="name" value="${name}" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="email">E-mail</label>
    </div>
    <div class="col-75">
      <input type="text" id="email" name="email" value="${email}" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="phone">Phone</label>
    </div>
    <div class="col-75">
       <input type="text" id="phone" name="phone" value="${phone}" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="aadhar">Aadhar No</label>
    </div>
    <div class="col-75">
       <input type="text" id="aadhar" name="aadhar" value="${aadhar}" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="jobType">Favourite Jobs</label>
    </div>
    <div class="col-75">
       <input type="text" id="jobType" name="jobType" value="${jobs}" required>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="userid">User ID</label>
    </div>
    <div class="col-75">
      <input type="text" id="id" name="id" value="${userid}" readonly>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="erunnerid">Erunner ID</label>
    </div>
    <div class="col-75">
      <input type="text" id="erunnerid" name="erunnerid" value="${erunnerid}" readonly>
    </div>
  </div>
  <div class="row">
    <input type="submit" value="Submit">
  </div>
  </form>
</div>

</body>
</html>