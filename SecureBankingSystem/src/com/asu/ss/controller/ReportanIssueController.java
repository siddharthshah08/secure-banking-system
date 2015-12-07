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
import com.asu.ss.pojo.InternalUser;
import com.asu.ss.pojo.ToDo;
//import com.sun.nio.sctp.PeerAddressChangeNotification.AddressChangeEvent;




//THIS CLASS WAS COPIED FROM ANOTHER VERSION. NEEDS TO BE WORKED ON


@Controller
public class ReportanIssueController {

	public ReportanIssueController()
	{
		
	}
	/*
	 * This will return the details of the loggedInUser. 
	 * The details will be displayed which can be modified and updates.
	 */
	
	// Sid 
	
	@RequestMapping(value="/ReportanIssue", method=RequestMethod.GET)
    public ModelAndView get(HttpSession sessionID) throws SQLException  
    {  
			
			return new ModelAndView("ReportanIssue","message",true);
		
		
    }
	
	@RequestMapping(value="/IssueReportedSuccessfully", method=RequestMethod.POST)
    public ModelAndView post(@RequestParam("issueDesc") String description, HttpSession sessionID) throws SQLException  
    {  
		
		String userName = (String)sessionID.getAttribute("userName");
		
		
		
		InternalUserDAO internalDAO=new InternalUserDAO();
		String department ="IT";
		InternalUser itDepartmentGuy = internalDAO.findInternalUserByDepartment(department);
		String actioneer ="";
		if (itDepartmentGuy!=null)
		{
			actioneer = itDepartmentGuy.getUserName();
		}
		//Dnt Know what needs to be done in case there is no IT Employee in the system.
		
		
		ToDo todo = new ToDo(actioneer, userName, 0, description, "Pending");
		ToDoDAO todoDAO = new ToDoDAO();
		todoDAO.persist(todo);
			
		return new ModelAndView("IssueReportedSuccessfully","message",true);	
    }
	
	
	
	
}
