package com.demo.Controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.Commander.ForgotPasswordCommander;
import com.demo.Commander.LoginCommander;
import com.demo.Commander.SignupCommander;
import com.demo.Commander.UserDetailsEditCommander;
import com.demo.Commander.VerifyPasswordCommander;
import com.demo.Entity.MailObject;
import com.demo.Entity.User;
import com.demo.ServiceImpl.EmailService;
import com.demo.ServiceImpl.MessageServiceImpl;
import com.demo.ServiceImpl.UserServiceImpl;
import com.demo.Utilities.CommonUtils;

@Controller
public class GlobalController {
	
	static Logger log = Logger.getLogger(GlobalController.class.getName());
	
	@Value("${msg:Not Available}")
	private String myVar;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	MessageServiceImpl msgSender;
	
	//return login page
	@RequestMapping(value= {"/","/loginPage"})
	public String loginPage(Model m) {
		m.addAttribute("loginCommand", new LoginCommander());
		return "loginPage";
	}
	
	//return signup page
	@RequestMapping("/signup")
	public String signupPage(Model m) {
		m.addAttribute("signupCommand", new SignupCommander());
		return "signup";
	}
	
	
	//return hello page
		@RequestMapping("/adminPage")
		public String welcomePage(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model m) {
		/*
		 * session = request.getSession(); if(session.getAttribute("isUserLoggedIn")==
		 * null) { m.addAttribute("Message","Please login to view page!");
		 * m.addAttribute("loginCommand", new LoginCommander()); return "login"; }
		 */
		/*
		 * Object principal =
		 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); String
		 * username; if (principal instanceof UserDetails) { username =
		 * ((UserDetails)principal).getUsername(); } else { username =
		 * principal.toString(); } System.out.println(username);
		 * m.addAttribute("name",username); System.out.println(myVar);
		 */
			return "adminPage";
		}
	
	//handle login request : deprecated after introduction of spring security
	@RequestMapping(value="/loginValidator",method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginCommand")LoginCommander e, BindingResult br,HttpServletRequest request, HttpServletResponse response, Model m) {
			System.out.println(e.toString());
			try {
				if(br.hasErrors())  
		        {  
		            return "loginPage";
		            
		        } 
				//Call to service and pass Login Commander
				boolean loginProcess = userService.loginProcess(e);
				if(loginProcess) {
					//get user details
					User user = userService.getUserDetails(e);
					//session handling
					if(user.getActive() == true && user.getRole() != null){
						HttpSession session = request.getSession();
						session.setAttribute("name",user.getName());
						session.setAttribute("id", user.getId());
						session.setAttribute("isUserLoggedIn", true);
						session.setAttribute("role", user.getRole());
						session.setAttribute("active",user.getActive());
						m.addAttribute("Message","Succesfully LoggedIn");
						System.out.println(user.getRole());
						System.out.println("ADmin : "+user.getRole() == "Admin");
						if(user.getRole().equals("Admin")) {
							return "adminPage";
						}else {
							//m.addAttribute("userDetailsEditCommand", new UserDetailsEditCommander());
							//return "redirect:/accessUserPage";
							long userId = (long) session.getAttribute("id");
							UserDetailsEditCommander userObj = null;
							try {
								userObj =setUserCommander(userId);
							} catch(Exception exe) {
								log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
								return "exceptionPage";
							} 
							m.addAttribute("userDetailsEditCommand",userObj);
							return "userPage";
						}
						
					} else if(user.getRole() == null){
						m.addAttribute("Message","User role is not set. Please contact admin!");
						return "loginPage";
					}
					else {
						m.addAttribute("Message","User is not active. Please contact admin!");
						return "loginPage";
					}
					
				}else {
					m.addAttribute("loginError","Invalid Password!");
					return "loginPage";
				}
		        
			}
			catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
				emailService.sendPreConfiguredMail("EXCEPTION!"+ExceptionUtils.getStackTrace(exe));
				return "exceptionPage";
			} 
		}
	
	//Set user commander
	private UserDetailsEditCommander setUserCommander(long userId) {
		UserDetailsEditCommander userObj = new UserDetailsEditCommander();
		User user1 = userService.getUserDetailsToEdit(userId);
		userObj.setId(userId);
		userObj.setName(user1.getName());
		userObj.setEmail(user1.getEmail());
		userObj.setGender(user1.getGender());
		userObj.setPhone(user1.getPhone());
		userObj.setInterest(user1.getInterest());
		userObj.setAddress(user1.getAddress().getAddress());
		userObj.setCity(user1.getAddress().getCity());
		userObj.setPincode(user1.getAddress().getPincode());
		return userObj;
	}
	
	//handle signup request
		@RequestMapping(value="/signupValidator",method=RequestMethod.POST)
		public String signup(@Valid @ModelAttribute("signupCommand")SignupCommander signupCommandObj, BindingResult br,HttpServletRequest request, HttpServletResponse response, Model m) {
				System.out.println(signupCommandObj.toString());
				try {
					if(br.hasErrors())  
			        {  
						System.out.println(br.getFieldValue("email"));
			            return "signup";  
			        }  
					//Call to service and pass SignupCommander				
					boolean signupProcess = userService.signupProcess(signupCommandObj);
					System.out.println("Is signup successful?"+signupProcess);
					if(signupProcess) {
						msgSender.sendMessage(new MailObject( "springdemo96@gmail.com", "Account created Successfully! ", "Hi "+signupCommandObj.getName()+" Account has been created succesfully!"));
						m.addAttribute("Message","Succesfully Registered");
						m.addAttribute("loginCommand", new LoginCommander());
					} else {
						//Route to signup page
						return "signup";
					}
				}
				catch(Exception exe) {
					log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
					return "exceptionPage";
				} 
    			return "loginPage";
		        }  
		
		//handling logout
		@RequestMapping(value="/logout")
		public String logout(HttpServletResponse response, HttpServletRequest request, HttpSession session, Model m) {
			session=request.getSession();  
            session.invalidate();
            m.addAttribute("Message", "You've been succesfully logged out!");
            m.addAttribute("loginCommand", new LoginCommander());
            return "loginPage";
		}
		
		//return forgotPassword page
		@RequestMapping("/forgotPassword")
		public String forgotPassword(Model m) {
			m.addAttribute("forgotPasswordCommand", new ForgotPasswordCommander());
			return "forgotPassword";
		}
		
		//for sending email notification to user for new password
		@RequestMapping(value = "/forgotPassValidator",method=RequestMethod.POST)
		public String verifyEmailForFP(@Valid @ModelAttribute("forgotPasswordCommand")ForgotPasswordCommander fp, BindingResult br,HttpServletRequest request, HttpServletResponse response, Model m) {
			boolean verifyEmail = userService.verifyUserEmail(fp.getEmail());
			try {
				String generatedString = "";
				if(verifyEmail) {
					generatedString = new CommonUtils().generateUUID();
					//skip mail
					log.info(generatedString+ " " + new Date()+ "for" + fp.getEmail());
					userService.saveGeneratedID(generatedString,fp.getEmail());
					m.addAttribute("verifyPasswordCommand",new VerifyPasswordCommander());
					m.addAttribute("OTPVerified", false);
					m.addAttribute("email", fp.getEmail());
					return "newPassword";
					
				}else {
					m.addAttribute("Message","User doesn't exist!");
				}
			} catch (Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
				return "exceptionPage";
			}
			return "forgotPassword";
		}
		
		//Verify OTP backend
		//https://stackoverflow.com/questions/157005/conditionally-set-an-attribute-on-an-element-with-jsp-documents-jspx
		@RequestMapping(value = "/confirmOTP", method = RequestMethod.POST)
		public String verifyOTP(@RequestParam String otp, @RequestParam String email,Model m) {
			//service call
			boolean checkOtp = false;
			try {
				checkOtp = userService.verifyOTP(otp,email);
				System.out.println(checkOtp);
				m.addAttribute("email", email);
				m.addAttribute("verifyPasswordCommand",new VerifyPasswordCommander());
				if(checkOtp) {
					m.addAttribute("OTPVerified", true);
				} else {
					m.addAttribute("Message", "Wrong OPT.");
					m.addAttribute("OTPVerified", false);
				}
			} catch (Exception exe) {
				// TODO Auto-generated catch block
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
				return "exceptionPage";
			}
			return "newPassword";
		}
		
		//Verify new Password & Save
		@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
		public String verifyResetPassword(@Valid @ModelAttribute("verifyPasswordCommand") VerifyPasswordCommander vObj, BindingResult br,HttpServletRequest request, HttpServletResponse response, Model m) {
			boolean updated = false;
			m.addAttribute("OTPVerified", true);
			try {
				if(br.hasErrors()) {
					return "newPassword";
				}
				if(vObj.getNewPassword().equals(vObj.getConfirmPassword())) {
					//Save the password
					updated = userService.savePassword(vObj);
					if(updated) {
						m.addAttribute("Message", "Password has been changed! Please login again.");
					} else {
						m.addAttribute("Message", "Something went wrong! Contact admin.");
					}
					m.addAttribute("loginCommand", new LoginCommander());
					return "loginPage";
				} else {
					m.addAttribute("PasswordValidationMsg", "Password not matching!");
				}
			} catch (Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
				return "exceptionPage";
			}
			
			return "newPassword";
		}
		
		//return forgotPassword page
		@RequestMapping(value = {"/userPage"})
		public String userPage(Model m) {
			m.addAttribute("userDetailsEditCommand", new UserDetailsEditCommander());
			return "userPage";
		}
		
	}
			
		
	

