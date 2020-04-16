<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%-- <%
if(session.getAttribute("isUserLoggedIn") == null){
 response.sendRedirect("/DemoSpring_Prac/login");
 <%=session.getAttribute("name")%>
}
%> --%>

<%
 if(session.getAttribute("isUserLoggedIn") != null 
 	&& session.getAttribute("isUserLoggedIn").equals(new Boolean(true))
 	&& session.getAttribute("role") != null 
 	&& session.getAttribute("role").equals("Admin") 
 	&& session.getAttribute("active").equals(new Boolean(true))){
	 //Do nothing
 } else {
	 if(session.getAttribute("role") == null 
			 	|| !session.getAttribute("role").equals("Admin")){
	 session.setAttribute("UserRole", "Administrator Access needed!");
	 }
	response.sendRedirect("/DemoSpring_Prac/loginPage");
 }
%>
<html>
   <head>
      <title>Admin Dashboard</title>
      <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css"/>
      <script src="https://code.jquery.com/jquery-3.4.1.min.js"
  				integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	   
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>  
   </head>
   
   <body>
	   <div class="wrapper">
	   	<div class="container">
	   		<div id="successMsg">
	   		<%-- <p>${sessionScope.role}</p> --%>
	   			<p>${Message}</p>
	   		</div>
		   	
		   	<div id="header">
		   		<p id="welcomeUser">Welcome,${name}</p>
				<a id="logoutLink" href="${pageContext.request.contextPath}/logout">Logout</a>
		   	</div>
		   	
		   	<div id="userDatatable">
				<table id="myTable" class="display" style="width:100%">
				        <thead>
				            <tr>
				                <th>Id</th>
				                <th>Name</th>
				                <th>Email</th>
				                <th>Phone</th>
				                <th>Active</th>
				                <th>Gender</th>
				                <th>Role</th>
				                <th>Edit</th>
				            </tr>
				        </thead>
				        <tbody style="color:black"></tbody>
				  </table>
			  </div>
		    
		</div>
	   </div>
   </body>
   <script type="text/javascript">
	
	$(document).ready(function() {
	   var table = $('#myTable').DataTable( {
	    	"ajax": {
            "url": "http://localhost:8080/DemoSpring_Prac/getallUsers",
            "dataSrc": ""
        },
        "pageLength": 5,
        	"columns": [
                { "data": 'id' },
                { "data": 'name' },
                { "data": 'email' },
                { "data": 'phone' },
                { "data": 'active' },
                { "data": 'gender' },
                { "data": 'role' },
                {"defaultContent": "<button>Edit</button>"}
            ]
	    } );
	    
	    $('#myTable tbody').on( 'click', 'button', function () {
	        var data = table.row( $(this).parents('tr') ).data();
	        //alert( data['id'] );
	        window.location.href = "http://localhost:8080/DemoSpring_Prac/editUserCont/"+data['id'];
	    } );
	    
	} );
	
	
   </script>
</html>