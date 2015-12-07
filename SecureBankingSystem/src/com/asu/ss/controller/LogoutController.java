package com.asu.ss.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.DAO.AllusersDAO;
import com.asu.ss.DAO.ExternalUserDAO;
import com.asu.ss.DAO.InternalUserDAO;
import com.asu.ss.pojo.AllUsers;
import com.asu.ss.pojo.ExternalUser;
import com.asu.ss.pojo.InternalUser;


@Controller
public class LogoutController {

	
	public LogoutController()
	{
		
	}
	// Sid - On click of logout, the setting the session attribute as null.
	@RequestMapping(value="/Logout", method=RequestMethod.GET)
    public ModelAndView get(HttpSession sessionID)   
    {
		
		AllusersDAO alluserDAO=new AllusersDAO();
		
		AllUsers logoutUser=alluserDAO.findUser(sessionID.getAttribute("userName").toString());
		
		if(logoutUser.getUserType().equals("Internal"))
		
		{
		
		InternalUserDAO internalUserDAO=new InternalUserDAO();
		
		InternalUser InlogginoutUser=internalUserDAO.findInternalUser(sessionID.getAttribute("userName").toString());
		
		InlogginoutUser.setActiveSessionID("0000");
		
		internalUserDAO.persist(InlogginoutUser);
		
		}
		
		else if(logoutUser.getUserType().equals("External"))
			
		{
		
		ExternalUserDAO externalUserDAO=new ExternalUserDAO();
		
		ExternalUser ExlogginoutUser=externalUserDAO.find(sessionID.getAttribute("userName").toString());
		
		ExlogginoutUser.setActiveSessionID("0000");
		
		externalUserDAO.persist(ExlogginoutUser);
		
		}
		
		sessionID.setAttribute("userName", null);
		
		return new ModelAndView("Logout","message",true);
	
    }
	
	

}
