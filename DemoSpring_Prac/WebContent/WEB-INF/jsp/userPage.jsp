<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%
if(session.getAttribute("isUserLoggedIn") != null 
	&& session.getAttribute("isUserLoggedIn").equals(new Boolean(true)) 
	&& session.getAttribute("role") != null 
	&& session.getAttribute("active").equals(new Boolean(true))){
	} else {
		response.sendRedirect("/DemoSpring_Prac/loginPage");
}
%>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>User Page</title>

    <!-- Icons font CSS-->
    <link href="${pageContext.request.contextPath}/resources/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="${pageContext.request.contextPath}/resources/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" media="all">
    
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
  				integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script> 
</head>

<body>
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
    	<div id="header">
		   		<p id="welcomeUser">Welcome,${name}</p>
				<a id="logoutLink" href="${pageContext.request.contextPath}/logout">Logout</a>
		</div>
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">User Details</h2>
                    <label> ${sessionScope.UserRole} </label>
					<label id="successMsg"> ${Message} </label>
					<br/>
                    <form:form action="${pageContext.request.contextPath}/editDetailsValidator" modelAttribute="userDetailsEditCommand" method="POST">
                        <form:hidden path="id" placeholder="Full Name" cssClass="input" />
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Full Name</label>
                                    <form:input path="name" placeholder="Full Name" cssClass="input--style-4"/>   
									<form:errors path="name" cssClass="error"/>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                	<label class="label">Email</label>
                                	<form:input path="email" placeholder="Email" cssClass="input--style-4"/>    
									<form:errors path="email" cssClass="error"/>
									<span>${EmailError}</span>
									<br>
									${EmailError == null ? "" : "<br>"}
                                </div>
                            </div>
                        </div>
                        
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                	<label class="label">Phone</label>
                                	<form:input path="phone" placeholder="Phone" cssClass="input--style-4"/>     
									<form:errors path="phone" cssClass="error"/>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Gender</label>
                                    <div class="p-t-10">
                                        <label class="radio-container m-r-45">Male
                                            <form:radiobutton path="gender" value="Male"/>   
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="radio-container">Female
                                            <form:radiobutton path="gender" value="Female"/>
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Interest</label>
                                    <div class="p-t-10">
                                        <label class="radio-container m-r-45">Books
                                            <form:checkbox path="interest" value="Books"/>  				            
                                            <span class="checkmarkCheckbox"></span>
                                        </label>
                                        <label class="radio-container">Electronics
                                            <form:checkbox path="interest" value="Electronics"/>
                                            <span class="checkmarkCheckbox"></span>
                                        </label>
                                         <label class="radio-container">Home
                                            <form:checkbox path="interest" value="Home"/>
                                            <span class="checkmarkCheckbox"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                	<label class="label">Address</label>
                                	<form:input path="address" placeholder="Address" cssClass="input--style-4"/>     
									<form:errors path="address" cssClass="error"/>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">City</label>
                                	<form:input path="city" placeholder="City" cssClass="input--style-4"/>     
									<form:errors path="city" cssClass="error"/>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                	<label class="label">Pincode</label>
                                	<form:input path="pincode" placeholder="Pincode" cssClass="input--style-4"/>     
									<form:errors path="pincode" cssClass="error"/>
                                </div>
                            </div>
                        </div>
                        
                        <div class="p-t-15">
                        	<input type="submit" value="Submit" class="btn btn--radius-2 btn--blue" id="loginButton"/> 
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/datepicker/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="${pageContext.request.contextPath}/resources/js/global.js"></script>

</body>

</html>