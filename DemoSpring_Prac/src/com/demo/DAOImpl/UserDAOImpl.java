package com.demo.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.Commander.EditCommander;
import com.demo.Commander.LoginCommander;
import com.demo.Commander.SignupCommander;
import com.demo.Commander.UserDetailsEditCommander;
import com.demo.Commander.VerifyPasswordCommander;
import com.demo.DAOInf.UserDAO;
import com.demo.Entity.User;
import com.demo.Entity.UserDTO;
import com.demo.Entity.UserDTO2;
import com.demo.Entity.UserRowMapper;

//DAO layer
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	static Logger log = Logger.getLogger(UserDAOImpl.class.getName());

	/*
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	 * 
	 * this.jdbcTemplate = jdbcTemplate; }
	 */
	
	@Override
	public int registerUser(SignupCommander signup) {
		int update = 0;
		try {
			String sql = "INSERT INTO USER (NAME,EMAIL,PHONE,GENDER,INTEREST,PASSWORD,ACTIVE) VALUES (?,?,?,?,?,?,?)";
			update = jdbcTemplate.update(sql, new Object[] {
	        	signup.getName(),signup.getEmail(),signup.getPhone(),signup.getGender(),String.join(",", signup.getInterest()),signup.getPass(),true
			});
			System.out.println("Result:"+update);
        } catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			return -1;
		} 
        System.out.println(update);
        return update;
	}
	
	/*
	 * //for login validation
	 * 
	 * @Override public String loginUser(LoginCommander login) { String password =
	 * ""; try { String sql = "SELECT PASSWORD FROM USER WHERE EMAIL = ?"; password
	 * = jdbcTemplate.queryForObject(sql,new Object[]
	 * {login.getEmail()},String.class); System.out.println("Password"+password);
	 * 
	 * }catch(Exception exe) { log.info(exe.getMessage()+ new Date()+
	 * ExceptionUtils.getStackTrace(exe)); } return password; }
	 */
	
	//fetch user details
	@Override
	public User getUser(LoginCommander loginUser) {
		User user = null;
		try {
			String sql = "SELECT U.ID, NAME, EMAIL, PASSWORD, PHONE, GENDER, INTEREST, ACTIVE, ROLE, ROLEID, ADDRESS, CITY, PINCODE FROM USER U LEFT JOIN USERROLE UR ON U.ID = UR.USERID LEFT JOIN ROLE R ON R.ID = UR.ROLEID LEFT JOIN USERADDRESS UA ON UA.USERID = U.ID WHERE EMAIL = ?";
			user = jdbcTemplate.queryForObject(sql,new Object[] {loginUser.getEmail()}, new UserRowMapper());
			
		}catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
		} 
		return user;
	}
	
	//fetch existing phone number
	@Override
	public String getPhone(String phone) {
		String userPhone = "";
		try {
			String sql = "SELECT PHONE FROM USER WHERE PHONE = ?";
			userPhone = jdbcTemplate.queryForObject(sql,new Object[] {phone}, String.class);
			System.out.println(userPhone);
			
		}catch(Exception exe) {
			log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
		} 
		return userPhone;
	}
	
	//fetch existing email address
		@Override
		public String getEmail(String email) {
			String userEmail = "";
			try {
				String sql = "SELECT EMAIL FROM USER WHERE EMAIL = ?";
				userEmail = jdbcTemplate.queryForObject(sql,new Object[] {email}, String.class);
				System.out.println("Constraint:"+userEmail);
				
			}catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			} 
			return userEmail;
		}
		
		@Override
		public UserDTO getUserDetailsById(long id) {
			// TODO Auto-generated method stub
			UserDTO user = null;
			String sql = "SELECT * FROM USER WHERE ID = ?";
			try {
				user = jdbcTemplate.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
				System.out.println(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
		
	/*
	 * @Override public User getUserDetailsByIdRM(long id) { // TODO Auto-generated
	 * method stub User user = null; String sql = "SELECT * FROM USER WHERE ID = ?";
	 * try { user = jdbcTemplate.queryForObject(sql,new Object[] {id},new
	 * UserRowMapper()); System.out.println("Used rowmapper:"+user); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return user; }
	 */

		@Override
		public List<UserDTO2> getAllUserDetailsRM() {
			// TODO Auto-generated method stub
			List<UserDTO2> query = null;
			try {
				query = jdbcTemplate.query("SELECT U.ID, NAME, EMAIL, PHONE, GENDER, ACTIVE, ROLE FROM USER U LEFT JOIN USERROLE UR ON U.ID = UR.USERID LEFT JOIN ROLE R ON R.ID = UR.ROLEID",new BeanPropertyRowMapper<UserDTO2>(UserDTO2.class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return query;
		}
		
		@Override
		public User getUserDetailsToEdit(long id) {
			String sql = "SELECT U.ID, NAME, EMAIL, PHONE, PASSWORD, GENDER, ACTIVE, INTEREST,ROLE, UR.ROLEID, ADDRESS, CITY, PINCODE FROM USER U LEFT JOIN USERROLE UR ON U.ID = UR.USERID LEFT JOIN ROLE R ON R.ID = UR.ROLEID LEFT JOIN USERADDRESS UA ON UA.USERID = U.ID WHERE U.ID=?";
			User queryForObject = null;
			try {
				queryForObject = jdbcTemplate.queryForObject(sql,new Object[] {id},new UserRowMapper());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return queryForObject;
		}
		
		@Override
		public Long getUserByEmailId(String email) {
			List<Long> queryForObject = null;
			try {
				String query = "SELECT ID FROM USER WHERE EMAIL=?";
				queryForObject = jdbcTemplate.query(query,new Object[] {email}, new RowMapper<Long>() {
					@Override
					public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						return rs.getLong(1);
					}
				});
				System.out.println(queryForObject);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(queryForObject.isEmpty()) {
				return 0L;
			} else {
				return queryForObject.get(0);	
			}
		}
		
		@Override
		public int updateUser(EditCommander e) {
			int update = 0, roleExists = 0, roleId=0;
			try {
				String sql = "UPDATE USER SET NAME = ?,EMAIL = ?,PHONE = ?,GENDER = ?,INTEREST = ?,ACTIVE = ? WHERE ID = ?";
				update = jdbcTemplate.update(sql, new Object[] {
		        	e.getName(),e.getEmail(),e.getPhone(),e.getGender(),String.join(",", e.getInterest()),e.isActive(),e.getId()
				});
				String sql1 = "SELECT COUNT(*) FROM USERROLE WHERE USERID = ?";
				roleExists = jdbcTemplate.queryForObject(sql1,new Object[] {e.getId()},Integer.class);
				roleId = jdbcTemplate.queryForObject("SELECT ID FROM ROLE WHERE ROLE = ?",new Object[] {e.getRole()},Integer.class);
				if(roleExists == 1) {
					jdbcTemplate.update("UPDATE USERROLE SET ROLEID = ? WHERE USERID = ?",new Object[] {roleId,e.getId()});
				}else {
					jdbcTemplate.update("INSERT INTO USERROLE (ROLEID,USERID) VALUES(?,?)",new Object[] {roleId,e.getId()});
				}
				System.out.println("Result:"+update);
	        } catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
				return -1;
			} 
	        System.out.println(update);
	        return update;
		}
		
		//to verify email for new password
		@Override
		public int verifyUserEmail(String email) {
			int count = 0;
			try {
				count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USER WHERE EMAIL = ?", new Object[] {email},Integer.class);
			} catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			} 
			return count;
		}
		
		//to save UUID and date for new password
		@Override
		public void saveGeneratedID(String generatedString, String email) {
			try {
				jdbcTemplate.update("UPDATE USER SET UUID = ?,LASTEDITEDPASSWORDTIME = ? WHERE EMAIL = ?",new Object[] {generatedString,new Date(),email});
			}catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			} 
			
		}
		
		@Override
		public int verifyOTP(String otp, String email) {
			int count = 0;
			try {
				count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USER WHERE EMAIL = ? AND UUID = ?", new Object[] {email,otp},Integer.class);
				System.out.println(count);
			} catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			} 
			return count;
		}
		
		@Override
		public int savePassword(VerifyPasswordCommander vObj) {
			// TODO Auto-generated method stub
			int update = 0;
			try {
				update = jdbcTemplate.update("UPDATE USER SET PASSWORD = ? WHERE EMAIL = ?",new Object[] {vObj.getConfirmPassword(),vObj.getEmail()});
			}catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
			} 
			return update;
		}
		
		@Override   
		public int editUserProcess(UserDetailsEditCommander e) {
			int update = 0, addressExists=0;
			try {
				String sql = "UPDATE USER SET NAME = ?,EMAIL = ?,PHONE = ?,GENDER = ?,INTEREST = ? WHERE ID = ?";
				update = jdbcTemplate.update(sql, new Object[] {
		        	e.getName(),e.getEmail(),e.getPhone(),e.getGender(),String.join(",", e.getInterest()),e.getId()
				});
				addressExists = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USERADDRESS WHERE USERID = ?",new Object[] {e.getId()},Integer.class);
				if(addressExists == 1) {
					jdbcTemplate.update("UPDATE USERADDRESS SET ADDRESS = ?,CITY=?,PINCODE=? WHERE USERID = ?",new Object[] {e.getAddress(),e.getCity(),e.getPincode(),e.getId()});
				}else {
					jdbcTemplate.update("INSERT INTO USERADDRESS (ADDRESS,CITY, PINCODE, USERID) VALUES(?,?,?,?)",new Object[] {e.getAddress(),e.getCity(),e.getPincode(),e.getId()});
				}
	        } catch(Exception exe) {
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
				return -1;
			} 
	        System.out.println(update);
	        return update;
		}

}
