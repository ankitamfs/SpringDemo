<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>  
	<head>  
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script> 
	</head>  
	<body>  
		<div class="wrapper">
			<div class="container">
			<h1>Register</h1>
				<form:form action="signupValidator" modelAttribute="signupCommand">  
					<form:input path="name" placeholder="Full Name" cssClass="input"/>   
					<form:errors path="name" cssClass="error"/>
					<br>
					
					<form:input path="email" placeholder="Email" cssClass="input"/>    
					<form:errors path="email" cssClass="error"/>
					<br>  
					
					<form:password path="pass" placeholder="Password" cssClass="input"/>    
					<form:errors path="pass" cssClass="error"/>
					<br>
					
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
				        Books<form:checkbox path="interest" value="Books"/>  
				        Electronics<form:checkbox path="interest" value="Electronics"/>  
				        Home<form:checkbox path="interest" value="Home"/>  
			        	<br/>
			        	<br/> 
			        </div> 
				
					<input type="submit" value="Submit" class="submitButton" id="signupButton">  
				</form:form>
				
				Already Registered? Login<a href="${pageContext.request.contextPath}/loginPage">Click Here!</a>
			</div>
		</div>  
	</body>  
</html>  