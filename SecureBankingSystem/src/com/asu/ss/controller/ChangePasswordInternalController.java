package com.asu.ss.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.util.modelClass;


@Controller
public class ChangePasswordInternalController {
	
	
	@RequestMapping(value="/ChangePasswordInternal", method=RequestMethod.GET)
    public ModelAndView get()   
    { 
    
		return new ModelAndView("ChangePasswordInternal","message","");
		
    }
	
	
	@RequestMapping(value="/ChangePassword", method=RequestMethod.POST)
    public ModelAndView post(HttpSession sessionID, @RequestParam("currentpw") String currentPassword,@RequestParam("newpw1") String newPassword) throws SQLException, NoSuchAlgorithmException   
    {  
		
		modelClass model=new modelClass();
		
		String userName=sessionID.getAttribute("userName").toString();
		
		Boolean passChangeSuccessful=model.changePassword(userName, currentPassword, newPassword);
		
		if(passChangeSuccessful==true)
			
			return new ModelAndView("ChangePasswordSuccessIn","message","");
		
		else
			
			return new ModelAndView("ChangePasswordInternal","message","Password Change Failed!");

		
    }

}
