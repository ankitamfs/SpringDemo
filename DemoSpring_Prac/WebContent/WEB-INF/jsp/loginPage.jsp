<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%
 if(session.getAttribute("isUserLoggedIn") != null 
 	&& session.getAttribute("isUserLoggedIn").equals(new Boolean(true))
 	&& session.getAttribute("role") != null 
 	&& session.getAttribute("role").equals("Admin")){
	 response.sendRedirect("/DemoSpring_Prac/adminPage");
 } else{
	 if( session.getAttribute("role") != null && session.getAttribute("role").equals("User")){
		 response.sendRedirect("/DemoSpring_Prac/userPage");
	 }
 }

//check if user is loggedin

%>
<html>  
	<head>  
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"
  				integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script> 
	</head>  
	<body>  
		<div class="wrapper">
			<div class="container" id="loginForm">
				<h1>Welcome</h1>   
				<label> ${sessionScope.UserRole} </label>
				
				<label> ${Message} </label>
				
				<form:form action="loginValidator" modelAttribute="loginCommand">  
					<form:input path="email" placeholder="Email" cssClass="input"/>    
					<form:errors path="email" cssClass="error"/>
					
					<div>
					<form:password path="pass" placeholder="Password" cssClass="input"/> 
					<span class="fa fa-fw fa-eye toggle-password" onClick="showPassword()"></span> 
					</div>   
					<form:errors path="pass" cssClass="error"/>
					<a id="forgotPassword" href="${pageContext.request.contextPath}/forgotPassword">Forgot Password?</a>
					<br>
					<label id="passwordError"> ${loginError} </label>			
					<br><br> 
				
					<input type="submit" value="Submit" class="submitButton" id="loginButton"/>  
				</form:form>
				
				Not Registered? <a href="${pageContext.request.contextPath}/signup">Click Here!</a>
			</div>
	
			
		</div>		  
	</body>  
</html>  