package com.demo.ValidatorImpl;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
//import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.demo.ValidatorInf.EmailConstraint;

public class EmailConstraintValidator implements ConstraintValidator<EmailConstraint, String>{
	
	static Logger log = Logger.getLogger(EmailConstraintValidator.class.getName());
	
	@Override
	public void initialize(EmailConstraint arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		System.out.println("inside email validator "+arg0);
		System.out.println(arg1);
		try {
			if(arg0 != null) {
				 final String uri = "http://apilayer.net/api/check?access_key=c18dbab6264ab4586b5082380a3d454a&email="+arg0+"&smtp=1&format=1";
			     RestTemplate restTemplate = new RestTemplate();
			     String result2 = restTemplate.getForObject(uri, String.class);		    
			     System.out.println("Inside EMail constraint api call:" + result2);
			     JSONObject jsonObj = new JSONObject(result2);
			     if(jsonObj.get("smtp_check").toString().equals("true")) {
			    	return true;
			     }
			}}catch(Exception exe){
				log.info(exe.getMessage()+ new Date()+ ExceptionUtils.getStackTrace(exe));
				return true;
		}
		return false;
	}
	
}
