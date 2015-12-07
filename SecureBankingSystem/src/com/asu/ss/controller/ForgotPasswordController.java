package com.asu.ss.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.DAO.AllusersDAO;
import com.asu.ss.DAO.ExternalUserDAO;
import com.asu.ss.DAO.InternalUserDAO;
import com.asu.ss.pojo.AllUsers;
import com.asu.ss.pojo.ExternalUser;
import com.asu.ss.pojo.InternalUser;
import com.asu.ss.util.modelClass;



@Controller
public class ForgotPasswordController {
	
	
	
	public ForgotPasswordController() throws SQLException
	{
		
	}
	
	@RequestMapping(value="/forgotPassword", method=RequestMethod.GET)
    public ModelAndView get()   
    {  
		return new ModelAndView("ForgetPasswordAskUsername","message",true);
	
    }
	
	@RequestMapping(value="/ForgotPasswordAskSecQues", method=RequestMethod.POST)
    public ModelAndView post(@RequestParam("forgotpasswordusername") String userName, HttpSession sessionID)   
    {  
		AllusersDAO alluserDAO=new AllusersDAO();
		
		AllUsers alluser=alluserDAO.findUser(userName);
		
		System.out.println("------"+alluser.getUserType());
		
		ModelMap secQues = new ModelMap();
		
		if(alluser.getUserType().equals("Internal"))
		{			
			
		InternalUserDAO internalUserDAO = new InternalUserDAO();		
		InternalUser loggedInUser = internalUserDAO.findInternalUser(userName);
		sessionID.setAttribute("userName", userName);
		
		sessionID.setAttribute("userType","Internal");
		String secQues1 = loggedInUser.getSecurityQues1();// Sid - Fetch the Security Question texts to prepolulate on the Security Questions screen.
		String secQues2 = loggedInUser.getSecurityQues2();
		String secQues3 = loggedInUser.getSecurityQues3();
		
		 // INstantiating new object. This object will contain all the views we need to pass to the view.
		
		secQues.addAttribute("secQues1",secQues1);
		secQues.addAttribute("secQues2",secQues2);
		secQues.addAttribute("secQues3",secQues3);
		secQues.addAttribute("uname",userName);
		
		return new ModelAndView("ForgotPasswordAskSecQues",secQues);
		
		}
		
		else if(alluser.getUserType().equals("External"))
		{
			
			ExternalUserDAO externalDAO=new ExternalUserDAO();
			
			ExternalUser externaluser=externalDAO.find(userName);
			
			sessionID.setAttribute("userName", userName);
			
			sessionID.setAttribute("userType","External");
			
			String secQues1 = externaluser.getSecurityQues1();// Sid - Fetch the Security Question texts to prepolulate on the Security Questions screen.
			String secQues2 = externaluser.getSecurityQues2();
			String secQues3 = externaluser.getSecurityQues3();
			
			 // INstantiating new object. This object will contain all the views we need to pass to the view.
			
			secQues.addAttribute("secQues1",secQues1);
			secQues.addAttribute("secQues2",secQues2);
			secQues.addAttribute("secQues3",secQues3);
			
			secQues.addAttribute("uname",userName);		
			
			return new ModelAndView("ForgotPasswordAskSecQues",secQues);
			
		}
		
		else
		{
				
			return new ModelAndView("ForgetPasswordAskUsername","message","Wrong credentials");
			
		}	
	
    }
	
	@RequestMapping(value="/PasswordRecovery", method=RequestMethod.POST)
    public ModelAndView post(HttpSession sessionID, @RequestParam("username") String userName, @RequestParam("forgotpasswordsa1") String securityAnswer1,@RequestParam("forgotpasswordsa2") String securityAnswer2,@RequestParam("forgotpasswordsa3") String securityAnswer3) throws SQLException, NoSuchAlgorithmException   
    { 
		ModelMap secQues = new ModelMap();
		
		modelClass model=new modelClass();
		
		if(sessionID.getAttribute("userType").equals("Internal"))
		{
		
		InternalUserDAO internalUserDAO = new InternalUserDAO();		
		InternalUser loggedInUser = internalUserDAO.findInternalUser(userName);
		
		if((securityAnswer1.equalsIgnoreCase(loggedInUser.getSecurityAns1()))&&(securityAnswer2.equalsIgnoreCase(loggedInUser.getSecurityAns2()))&&(securityAnswer3.equalsIgnoreCase(loggedInUser.getSecurityAns3())))
		{
							
			String chars = "abcdefghijklmnopqrstuvwxyz"
		            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
		            + "0123456789!@%$%&^?|~'\"#+="
		            + "\\*/.,:;[]()-_<>";
		   final int PW_LENGTH = 10;
		   
		   Random rnd = new SecureRandom();
		   
		   StringBuilder generatedPassword = new StringBuilder();
		   
		   for (int i = 0; i < PW_LENGTH; i++)
		   {
			   
			   generatedPassword.append(chars.charAt(rnd.nextInt(chars.length())));
			   
		   }
		   
		   Boolean passChange=model.ForgotPassword(userName, generatedPassword.toString());
		   
		   if(passChange==true)
		   {
			
			return new ModelAndView("PasswordEmailSent","message","Password Change successful! An email has been sent to you with your new password");
		   
		   }
		   
		   else
		   {
			   
			   return new ModelAndView("ForgotPasswordAskSecQues","message","Password Change unsuccessful!");
			  
		   }	
		}
		
		else
		{
			
			String secQues1 = loggedInUser.getSecurityQues1();// Sid - Fetch the Security Question texts to prepolulate on the Security Questions screen.
			String secQues2 = loggedInUser.getSecurityQues2();
			String secQues3 = loggedInUser.getSecurityQues3();
			
			 // INstantiating new object. This object will contain all the views we need to pass to the view.
			
			secQues.addAttribute("secQues1",secQues1);
			secQues.addAttribute("secQues2",secQues2);
			secQues.addAttribute("secQues3",secQues3);
			secQues.addAttribute("uname",userName);
			
			return new ModelAndView("ForgotPasswordAskSecQues",secQues);
		}
			   
		}
		
		else if(sessionID.getAttribute("userType").equals("External"))
		{
			
			ExternalUserDAO externalUserDAO = new ExternalUserDAO();		
			ExternalUser loggedInUserex = externalUserDAO.find(userName);
			
			if((securityAnswer1.equalsIgnoreCase(loggedInUserex.getSecurityAns1()))&&(securityAnswer2.equalsIgnoreCase(loggedInUserex.getSecurityAns2()))&&(securityAnswer3.equalsIgnoreCase(loggedInUserex.getSecurityAns3())))
			{
								
				String chars = "abcdefghijklmnopqrstuvwxyz"
			            + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			            + "0123456789!@%$%&^?|~'\"#+="
			            + "\\*/.,:;[]()-_<>";
			   final int PW_LENGTH = 10;
			   
			   Random rnd = new SecureRandom();
			   
			   StringBuilder generatedPassword = new StringBuilder();
			   
			   for (int i = 0; i < PW_LENGTH; i++)
			   {
				   
				   generatedPassword.append(chars.charAt(rnd.nextInt(chars.length())));
				   
			   }
			   
			   Boolean passChange=model.ForgotPassword(userName, generatedPassword.toString());
			   
			   if(passChange==true)
			   {
				
				return new ModelAndView("PasswordEmailSent","message","Password Change successful! An email has been sent to you with your new password");
			   
			   }
			
			   else
			   {
				   
				   return new ModelAndView("ForgotPasswordAskSecQues","message","Password Change unsuccessful!");
				  
			   }			   
				   
		}
			
			else
			{
				
				String secQues1 = loggedInUserex.getSecurityQues1();// Sid - Fetch the Security Question texts to prepolulate on the Security Questions screen.
				String secQues2 = loggedInUserex.getSecurityQues2();
				String secQues3 = loggedInUserex.getSecurityQues3();
				
				 // INstantiating new object. This object will contain all the views we need to pass to the view.
				
				secQues.addAttribute("secQues1",secQues1);
				secQues.addAttribute("secQues2",secQues2);
				secQues.addAttribute("secQues3",secQues3);
				secQues.addAttribute("uname",userName);
				
				return new ModelAndView("ForgotPasswordAskSecQues",secQues);
			}
		
		
	
    }
		else
		
			
		
			
			return new ModelAndView("ForgotPasswordAskSecQues","message","Password Change unsuccessful!");
		
		}
    }


