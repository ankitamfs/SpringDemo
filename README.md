# SpringDemo : User Management Project

Configuration:

Environment Configuration
  * Tomcat Setup - Version 9.0
    - port - 8080
  * Maven - Dependency Management

Database Configuration
  * MySQL
    - URL : jdbc:mysql://localhost:portNumber/DBSchema
    - Port No : 3306
    - Provide DB Credentials
  
Configuration - ActiveMQ & JMS
  * Start ActiveMQ -> D:\apache-activemq-5.15.12\bin\win64 -> double click activemq
  cd D:\apache-activemq-5.15.12\bin\win64\ -> activemq.bat
  * Default Credentials - admin/admin
  * TCP Listener- localhost:61616
  * Web console- localhost:8161
  * Queue Name- "MailQueue" : MailObject:{
                                           "to" : "mailaddress of rec"
                                           ,"header" : "header of the mail"
                                           ,"body" : "Body of the mail"
                                         }
 
SpringBoot Microservices
 
    1. MailSender - localhost:8787
        * Setup for Java Mail Sender in application.properties
        * Configuration for ActiveMQ
        * Description: This micro service will consitently listen to the ACtiveMQ server for the queue "MailQueue" and upon receiving
                      request(data/object), it will send the mail to the receipient.
  
  # Project Description
  
    1. Sign in/Sing up page validation using Commanders
    2. Users are made to signup and the details are stored in the database with encoded password(with Password Encoder) and email sent          to user using MailSender microservice and  ActiveMQ.
    3. User can Login to view the Dashboard based on Role while user can view/edit own profile. 
    4. The Dashboard displays a datatable showing the details of all the users with edit functionality. 
    5. Made use of restTemplate to call external API's
    6. Implemented custom validator for field value verification
    7. Implemented jdbcTemplate (Provided by Spring)
    8. Project Structure : Spring MVC
    9. Implemented Spring Security & filters : (Taken out due to some filter issues)
    10.Implemented Forgot Password functionality which allows the user to verify email and sends an OTP to the same which on                    confirmation allows password change.
    11.Implemented Http Interceptor for session management
    12.Logging to send exception details to admin
    13.Maven : POM.xml file understanding
    14.Implemented email link activation for new registrations
    

 
