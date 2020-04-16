package com.demo.DAOInf;

import java.util.List;

import com.demo.Commander.EditCommander;
import com.demo.Commander.LoginCommander;
import com.demo.Commander.SignupCommander;
import com.demo.Commander.UserDetailsEditCommander;
import com.demo.Commander.VerifyPasswordCommander;
import com.demo.Entity.User;
import com.demo.Entity.UserDTO;
import com.demo.Entity.UserDTO2;

public interface UserDAO {

	int registerUser(SignupCommander signup);

	//String loginUser(LoginCommander login);

	User getUser(LoginCommander user);

	String getPhone(String phone);

	String getEmail(String email);

	UserDTO getUserDetailsById(long id);

	//User getUserDetailsByIdRM(long id);

	List<UserDTO2> getAllUserDetailsRM();

	User getUserDetailsToEdit(long id);

	Long getUserByEmailId(String email);

	int updateUser(EditCommander e);

	int verifyUserEmail(String email);

	void saveGeneratedID(String generatedString, String email);

	int verifyOTP(String otp, String email);

	int savePassword(VerifyPasswordCommander vObj);

	int editUserProcess(UserDetailsEditCommander e);

}
