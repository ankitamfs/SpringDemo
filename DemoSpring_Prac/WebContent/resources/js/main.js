$("#login-button").click(function(event){
		 event.preventDefault();
	 
	 $('form').fadeOut(500);
	 $('.wrapper').addClass('form-success');
});

//for password view
function showPassword(){
	console.log("clicked");
	//$("#pass").attr("type","text");
	$("#loginCommand > div > span").toggleClass("fa-eye fa-eye-slash");
	  var input = $("#pass").attr("type");
	  if (input == "password") {
		  $("#pass").attr("type", "text");
		  /*$('.toggle-password').css('position','absolute');
		  $('.toggle-password').css('margin-left','387');*/
	  } else {
		  $("#pass").attr("type", "password");
		 /* $('.toggle-password').css('position','relative');
		  $('.toggle-password').css('margin-left','216');*/
	  }
}

//timout for success msg on pageload
$(document).ready(function(){
	setTimeout(function(){ $("#successMsg").css('visibility','hidden') }, 5000);
});


/*$("#myTable").dataTable({
	  "aaData":[
	    ["Sitepoint","http://sitepoint.com","Blog","2013-10-15 10:30:00"],
	    ["Flippa","http://flippa.com","Marketplace","null"],
	    ["99designs","http://99designs.com","Marketplace","null"],
	    ["Learnable","http://learnable.com","Online courses","null"],
	    ["Rubysource","http://rubysource.com","Blog","2013-01-10 12:00:00"]
	  ],
	  "aoColumnDefs":[{
	        "sTitle":"Site name"
	      , "aTargets": [ "site_name" ]
	  },{
	        "aTargets": [ 1 ]
	      , "bSortable": false
	      , "mRender": function ( url, type, full )  {
	          return  '<a href="'+url+'">' + url + '</a>';
	      }
	  },{
	        "aTargets":[ 3 ]
	      , "sType": "date"
	      , "mRender": function(date, type, full) {
	          return (full[2] == "Blog") 
	                    ? new Date(date).toDateString()
	                    : "N/A" ;
	      }  
	  }]
	});*/

//$("#toggle-password").click(function() {
//console.log(this);
//	  $(this).toggleClass("fa-eye fa-eye-slash");
//	  var input = $($(this).attr("toggle"));
//	  if (input.attr("type") == "password") {
//	    input.attr("type", "text");
//	  } else {
//	    input.attr("type", "password");
//	  }
//	});