package com.demo.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setPass(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setGender(rs.getString("gender"));
		user.setActive(rs.getBoolean("active"));
		user.setInterest(rs.getString("interest").split(","));
		user.setRole(rs.getString("role"));
		user.setRoleId(rs.getInt("roleid"));
		Address address = new Address();
		address.setAddress(rs.getString("address"));
		address.setCity(rs.getString("city"));
		address.setPincode(rs.getInt("pincode"));
		user.setAddress(address);
		return user;
	}

}
