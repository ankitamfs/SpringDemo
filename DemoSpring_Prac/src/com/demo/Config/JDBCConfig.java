package com.demo.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.demo.DAOImpl.UserDAOImpl;
import com.demo.DAOInf.UserDAO;

@Configuration
public class JDBCConfig {
	
	@Value("${DCName}")
	private String driverName;
	
	@Value("${URL}")
	private String Url;
	
	@Value("${UName}")
	private String userName;
	
	@Value("${Password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		
		//connecting with MySql database
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverName);
		dataSource.setUrl(Url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        
        return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        
        return jdbcTemplate;
    }
	
	/*
	 * @Bean public UserDAO userDAO(){ UserDAOImpl userDao = new UserDAOImpl();
	 * userDao.setJdbcTemplate(jdbcTemplate()); return userDao; }
	 */
}
