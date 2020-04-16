package com.demo.Entity;

import java.io.Serializable;

public class MailObject implements Serializable{
	
	private static final long serialVersionUID = -5216988678012918280L;
	private String email;
	private String header;
	private String body;
	
	public MailObject() {
	}

	public MailObject(String email,String header, String body) {
		this.email = email;
		this.header = header;
		this.body = body;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "User [ email=" + email + ", header=" + header + ", body=" + body + "]";
	}
	
}
