package com.demo.ServiceInf;

import java.util.List;

import com.demo.Commander.EditCommander;
import com.demo.Commander.LoginCommander;
import com.demo.Commander.SignupCommander;
import com.demo.Commander.UserDetailsEditCommander;
import com.demo.Commander.VerifyPasswordCommander;
import com.demo.Entity.User;
import com.demo.Entity.UserDTO;
import com.demo.Entity.UserDTO2;

public interface UserService {

	boolean signupProcess(SignupCommander user);

	boolean loginProcess(LoginCommander user);

	User getUserDetails(LoginCommander user);

	String getUserPhone(String phone);

	String getUserEmail(String email);

	UserDTO getUserDetailsById(long id);

	//User getUserDetailsByIdRM(long id);

	List<UserDTO2> getAllUserDetailsRM();

	User getUserDetailsToEdit(long id);

	Long getUserByEmailId(String email);

	boolean updateUserProcess(EditCommander user);

	boolean verifyUserEmail(String email);

	void saveGeneratedID(String generatedString, String email);

	boolean verifyOTP(String otp, String email);

	boolean savePassword(VerifyPasswordCommander vObj);

	boolean editUserProcess(UserDetailsEditCommander e);


}
