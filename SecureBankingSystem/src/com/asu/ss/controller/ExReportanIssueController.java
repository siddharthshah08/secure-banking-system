package com.asu.ss.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.asu.ss.DAO.InternalUserDAO;
import com.asu.ss.DAO.ToDoDAO;
import com.asu.ss.pojo.ToDo;
//import com.sun.nio.sctp.PeerAddressChangeNotification.AddressChangeEvent;
@Controller
public class ExReportanIssueController {

	public ExReportanIssueController()
	{
		
	}
	/*
	 * This will return the details of the loggedInUser. 
	 * The details will be displayed which can be modified and updates.
	 */
	
	// Rohit - this is the controller method for report an issue functionality for customer
	
	@RequestMapping(value="/ExReportanIssue", method=RequestMethod.GET)
    public ModelAndView get(HttpSession sessionID) throws SQLException  
    {  
			return new ModelAndView("ExReportanIssue","message",true);
    }
	
	
	@RequestMapping(value="/ExIssueReportedSuccessfully", method=RequestMethod.POST)
    public ModelAndView post(@RequestParam("exissueDesc") String description, HttpSession sessionID) throws SQLException  
    {  
		
		// Fetch session attribute.
		String userName = (String)sessionID.getAttribute("userName");
		
		InternalUserDAO internalDAO=new InternalUserDAO();
		
		// fetch the first user from the IT department.
		String reportTo=internalDAO.findUser("department","IT").getUserName();
		
		
		// In user's todo items, the below false and pending value of isDone and action needs to be changed.
		ToDo todo = new ToDo(reportTo,0,userName,description,"Pending");
		ToDoDAO todoDAO = new ToDoDAO();
		todoDAO.persist(todo);
			
		return new ModelAndView("ExIssueReportedSuccessfully","message",true);
    }
	
	
}
