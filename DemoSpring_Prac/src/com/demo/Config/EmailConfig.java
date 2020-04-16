/*
 * package com.demo.Config;
 * 
 * import java.util.Properties;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.mail.SimpleMailMessage; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.mail.javamail.JavaMailSenderImpl;
 * 
 * @Configuration public class EmailConfig {
 * 
 * @Value("${Host}") private String host;
 * 
 * @Value("${Port}") private int port;
 * 
 * @Value("${Username}") private String username;
 * 
 * @Value("${MPassword}") private String password;
 * 
 * @Value("${MailTo}") private String mailTo;
 * 
 * @Value("${MailFrom}") private String mailFrom;
 * 
 * @Value("${MsgBody}") private String msgBody;
 * 
 * @Bean public JavaMailSender getJavaMailSender() { JavaMailSenderImpl
 * mailSender = new JavaMailSenderImpl(); mailSender.setHost(host);
 * mailSender.setPort(port);
 * 
 * mailSender.setUsername(username); mailSender.setPassword(password);
 * 
 * Properties props = mailSender.getJavaMailProperties();
 * props.put("mail.transport.protocol", "smtp"); props.put("mail.smtp.auth",
 * "true"); props.put("mail.smtp.starttls.enable", "true");
 * props.put("mail.debug", "true");
 * 
 * return mailSender; }
 * 
 * @Bean public SimpleMailMessage emailTemplate() { SimpleMailMessage message =
 * new SimpleMailMessage(); message.setTo(mailTo); message.setFrom(mailFrom);
 * message.setText(msgBody); return message; }
 * 
 * }
 */