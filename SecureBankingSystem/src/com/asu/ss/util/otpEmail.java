package com.asu.ss.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class otpEmail {

	public void Emailing(String emailID)
	{
		final String username = "gdnmaximus@gmail.com";
		final String password = "Maximus11";
 
		Properties props = new Properties();
		
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailID));
			String key = this.nextSessionId();
			message.setSubject("OTP from SSbank");
			message.setText("Your OTP Pin is : " +key);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}


	  public String nextSessionId()
	  {
	    SecureRandom random = new SecureRandom();
	    return new BigInteger(130, random).toString(32);
	  }
	
}
