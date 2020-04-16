<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
				<h1>Forgot Password?</h1>
				<form:form action="forgotPassValidator" modelAttribute="forgotPasswordCommand">  
					<label>Enter your registered Email Address</label>
					<br/><br/>
					<form:input path="email" placeholder="Email" cssClass="input"/>    
					<form:errors path="email" cssClass="error"/>
					<br/>
					<label> ${Message} </label>
					<br/>
					<input type="submit" value="Verify" class="submitButton" id="verifyEmailButton"/>  
				</form:form>
			</div>
	
			
		</div>		  
	</body>  
</html>  