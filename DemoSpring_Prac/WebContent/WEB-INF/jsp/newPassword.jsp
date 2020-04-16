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
		  <div class="container" id="passwordResetContainer">
			<div id="otpForm" style="display:${OTPVerified == false ? 'block' : 'none'}">
				<h1>Confirm OTP</h1>
				<form action="confirmOTP" method="POST">  
					<input name="otp" type="password" placeholder="Enter OTP" class="input"/>    
					<input name="email" type="hidden" value="${email}" class="input"/>
					<span>${Message}</span>
					<br/>
					<br/>
					<input type="submit" value="Verify OTP" class="submitButton" id="verifyButton"/>  
				</form>
			</div>
			
			<div id="passwordForm" style="display:${OTPVerified == true ? 'block' : 'none'}">
				<h1>Enter Password</h1>
				<form:form action="changePassword" method="POST" modelAttribute="verifyPasswordCommand">  
					<form:password path="newPassword" placeholder="New Password" cssClass="input"/>    
					<form:errors path="newPassword" cssClass="error"/>
					
					<form:input path="email" type="hidden" value="${email}" class="input"/>
					
					<form:password path="confirmPassword" placeholder="Confirm Password" cssClass="input"/>    
					<form:errors path="confirmPassword" cssClass="error"/>
					<span>${PasswordValidationMsg}</span>
					<br/><br/> 
					<input type="submit" value="Save Password" class="submitButton" id="savePasswordButton"/>  
				</form:form>
			</div>
		</div>	
			
			
	
			
		</div>		  
	</body>  
</html>  