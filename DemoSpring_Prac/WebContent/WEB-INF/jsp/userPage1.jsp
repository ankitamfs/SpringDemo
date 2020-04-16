<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%
 if(session.getAttribute("isUserLoggedIn") != null 
 	&& session.getAttribute("isUserLoggedIn").equals(new Boolean(true)) 
 	&& session.getAttribute("role") != null 
 	&& session.getAttribute("active").equals(new Boolean(true))){
	 //Do nothing
 } else {
	response.sendRedirect("/DemoSpring_Prac/loginPage");
 }
%>
<html>  
	<head>  
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">	
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"
  				integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script> 
	</head>  
	<body>  
		<div class="wrapper">
			<div class="container">
			
			<div id="successMsg">
	   			<p>${Message}</p>
	   		</div>
	   		<div id="header">
		   		<p id="welcomeUser">Welcome,${name}</p>
				<a id="logoutLink" href="${pageContext.request.contextPath}/logout">Logout</a>
		   	</div>
			<h1>User Details</h1>
				<form:form action="/editDetailsValidator" modelAttribute="userDetailsEditCommand" method="POST">  
					<form:hidden path="id" placeholder="Full Name" cssClass="input" />
					
					<form:input path="name" placeholder="Full Name" cssClass="input"/>   
					<form:errors path="name" cssClass="error"/>
					<br>
					
					<form:input path="email" placeholder="Email" cssClass="input"/>    
					<form:errors path="email" cssClass="error"/>
					<span>${EmailError}</span>
					<br>
					${EmailError == null ? "" : "<br>"}
					
					<form:input path="phone" placeholder="Phone" cssClass="input"/>    
					<form:errors path="phone" cssClass="error"/>
					<br>
					
					<div>
						<span class="boldClass">Gender:</span>   
				        Male <form:radiobutton path="gender" value="Male"/>  
				        Female <form:radiobutton path="gender" value="Female"/> 
				        <br/>
				        <br/>
					</div>
				
			        <div>
				        <span class="boldClass">Interest:</span>  
				        Books <form:checkbox path="interest" value="Books"/>  
				        Electronics <form:checkbox path="interest" value="Electronics"/>  
				        Home <form:checkbox path="interest" value="Home"/>  
			        	<br/>
			        	<br/> 
			        </div> 
				
					<input type="submit" value="Submit" class="submitButton" id="userEditButton">  
				</form:form>

			</div>
		</div>  
	</body>  
</html>  