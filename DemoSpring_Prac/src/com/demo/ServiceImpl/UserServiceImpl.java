package com.demo.ServiceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.Commander.EditCommander;
import com.demo.Commander.LoginCommander;
import com.demo.Commander.SignupCommander;
import com.demo.Commander.UserDetailsEditCommander;
import com.demo.Commander.VerifyPasswordCommander;
import com.demo.DAOImpl.UserDAOImpl;
import com.demo.Entity.User;
import com.demo.Entity.UserDTO;
import com.demo.Entity.UserDTO2;
import com.demo.ServiceInf.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	static Logger log = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDAOImpl userDAO;
	
	private org.springframework.security.crypto.password.PasswordEncoder encoder;
	
	//https://medium.com/@dmarko484/spring-boot-startup-init-through-postconstruct-765b5a5c1d29
	@PostConstruct
	public void doSetup() {
		encoder = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
	}
	
	//signup process
	@Override
	public boolean signupProcess(SignupCommander user) {
		
		boolean result=false;
		try {	
			System.out.println(user.getPass());
			//set the encoded password
			user.setPass(encoder.encode(user.getPass()));
			System.out.println(user.getPass());
			//call DAO layer for further processing
			int registerUser = userDAO.registerUser(user);
			if(registerUser == 1) {
				result = true;
			}
			
		} catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
		}
		return result;
		
	}
	
	//login process
	@Override
	public boolean loginProcess(LoginCommander user) {
		boolean validate = false;
		try {
			//password validation
			org.springframework.security.crypto.password.PasswordEncoder encoder
			   = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
			//password from DAO
			User userDetails = userDAO.getUser(user);
			String hashedPassword = userDetails.getPass();		
			System.out.println(hashedPassword);
			//password from form
			//user.setPass(encoder.encode(user.getPass()));
			String formPassword = user.getPass(); 
			System.out.println("Form Password"+formPassword);
			
			if(encoder.matches(formPassword,hashedPassword)) {
				validate = true;
				System.out.println(validate);
			}					
		}catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
		} 
		return validate;
	}
	
	//fetch details after login
	@Override
	public User getUserDetails(LoginCommander LoginUser) {
		User user =null;
		try {
			user = userDAO.getUser(LoginUser);
		}catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
		} 
		return user;
	}
	
	//check duplicate user by phone
	@Override
	public String getUserPhone(String phone) {
		String userPhone="";
		try {
			userPhone = userDAO.getPhone(phone);
		}catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
		}
		return userPhone;
	}

	//check duplicate user by email
		@Override
		public String getUserEmail(String email) {
			String userEmail="";
			try {
				userEmail = userDAO.getEmail(email);
			}catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}
			return userEmail;
		}
		
		//get user details by id
		@Override
		public UserDTO getUserDetailsById(long id) {
			UserDTO user = null;
			try {
				user = userDAO.getUserDetailsById(id);
			}catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}
			return user;
		}
		
	/*
	 * //get user details by id
	 * 
	 * @Override public User getUserDetailsByIdRM(long id) { User user = null; try {
	 * user = userDAO.getUserDetailsByIdRM(id); }catch(Exception exe) {
	 * log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe)); }
	 * return user; }
	 */
		
		//get user details by id
		@Override
		public List<UserDTO2> getAllUserDetailsRM() {
			try {
				return userDAO.getAllUserDetailsRM();
			}catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}
			return null;
		}
		
		//get user details by id for edit
		@Override
		public User getUserDetailsToEdit(long id) {
			try {
				return userDAO.getUserDetailsToEdit(id);
			}catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}
			return null;
			
		}
		
		@Override
		public Long getUserByEmailId(String email) {
			Long userByEmailId = null;
			try {
				 userByEmailId = userDAO.getUserByEmailId(email);
			}catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}
			return userByEmailId;
		}
		
		//edit and update process
		@Override
		public boolean updateUserProcess(EditCommander user) {
			boolean result=false;
			try {	
				int updateUser = userDAO.updateUser(user);
				if(updateUser == 1) {
					result = true;
				}
				
			} catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}
			return result;	
		}
		
		//to verify user email for new password
		@Override
		public boolean verifyUserEmail(String email) {
			boolean result = false;
			try {
				int emailCount = userDAO.verifyUserEmail(email);
				if(emailCount == 1) {
					result = true;
				}
			} catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}	
			return result;
		}

		//save UUID for password change
		@Override
		public void saveGeneratedID(String generatedString, String email) {
			try {
				userDAO.saveGeneratedID(generatedString,email);
			}catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}	
			
		}
		
		@Override
		public boolean verifyOTP(String otp, String email) {
			boolean result = false;
			try {
				int otpVerify = userDAO.verifyOTP(otp,email);
				if(otpVerify == 1) {
					result = true;
				}
			} catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}	
			return result;
		}
		
		@Override
		public boolean savePassword(VerifyPasswordCommander vObj) {
			boolean result = false;
			try {
				vObj.setConfirmPassword(encoder.encode(vObj.getConfirmPassword()));
				int saved = userDAO.savePassword(vObj);
				if(saved == 1) {
					result = true;
				}
			} catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}	
			return result;
		}
		
		@Override
		public boolean editUserProcess(UserDetailsEditCommander e) {
			boolean result=false;
			try {	
				int user = userDAO.editUserProcess(e);
				if(user == 1) {
					result = true;
				}
				
			} catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			}
			System.out.println(result);
			return result;	
		}
		

}
