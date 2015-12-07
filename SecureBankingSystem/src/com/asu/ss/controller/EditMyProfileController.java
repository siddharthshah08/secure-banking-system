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
import com.asu.ss.DAO.InternalUserTransactionDAO;
import com.asu.ss.pojo.InternalUser;
import com.asu.ss.pojo.InternalUserTransaction;



@Controller
public class EditMyProfileController {

	public EditMyProfileController()
	{
		
	}
	/*
	 * This will return the details of the loggedInUser. 
	 * The details will be displayed which can be modified and updates.
	 */
	
	@RequestMapping(value="/EditProfSuccessfull", method=RequestMethod.POST)
	public ModelAndView updateProfile(@RequestParam("iutxtadd1") String textAddress1, @RequestParam("iutxtadd2") String textAddress2, @RequestParam("iutxtcity") String city,@RequestParam("iutxtstate") String state,@RequestParam("iutxtzipcode") String zipCode,@RequestParam("iutxtphone") String phoneNumber,@RequestParam("iutxtcell") String cellNumber,@RequestParam("iutxtemail") String email,HttpSession sessionID) 
    { 
		
		//persist the updated value in the database.
		String modUser = (String)sessionID.getAttribute("modUser");
			
		InternalUserDAO internalUserDAO1=new InternalUserDAO();		
		InternalUser internalUser= internalUserDAO1.findInternalUser(modUser);		
			
			internalUser.setAddress1(textAddress1);		
			internalUser.setAddress2(textAddress2);		
			internalUser.setCity(city);		
			internalUser.setState(state);		
			internalUser.setZipcode(zipCode);		
			internalUser.setPhoneNumber(phoneNumber);		
			internalUser.setCellNumber(cellNumber);		
			internalUser.setEmail(email);
			internalUser.setUserName(modUser);
			
			
			internalUserDAO1.persist(internalUser);
			String modifiedUserName = internalUser.getFirstName() + internalUser.getLastName();
			
			InternalUserTransactionDAO internalUserTransactionDAO = new InternalUserTransactionDAO();
			String operation="Edited";
			InternalUserTransaction newTransaction =new InternalUserTransaction((String)sessionID.getAttribute("userName"),operation,internalUser.getFirstName(),internalUser.getLastName());
			internalUserTransactionDAO.persist(newTransaction);
		
			return new ModelAndView("UserModifiedSuccessfully","message",modifiedUserName);
			
    }
	
	
	
	@RequestMapping(value="/EditMyProfile", method=RequestMethod.GET)
    public ModelAndView get(HttpSession sessionID) throws SQLException  
    {  
		//TODO :Need the username of the session to retrieve its priority and his department
		// could set the session ID to have the username of the loggedInUser.
		//For now i am assuming that this is giving me the userName.This has to be changed Later on.
		
		String userName = sessionID.getAttribute("userName").toString();	
		InternalUserDAO internalUserDAO = new InternalUserDAO();
		InternalUser loggedInUser = internalUserDAO.findInternalUser(userName);
		
		sessionID.setAttribute("modUser",userName);
		//Sid - Fetch column values which can be updated by the user 
		
		
		
		
		
		
		String city = loggedInUser.getCity();
		String state = loggedInUser.getState();
		String zipcode = loggedInUser.getZipcode();
		String phoneNo = loggedInUser.getPhoneNumber();
		String email = loggedInUser.getEmail();
		String cellNo = loggedInUser.getCellNumber();
		String department = loggedInUser.getDepartment(); 
		String designation  = loggedInUser.getDesignation();
		
		String address = loggedInUser.getAddress1();
		String address2 = loggedInUser.getAddress2();
		ModelMap editmodel = new ModelMap();
		
		editmodel.addAttribute("city",city);
		editmodel.addAttribute("state",state);
		editmodel.addAttribute("zipcode",zipcode);
		editmodel.addAttribute("phoneNo",phoneNo);
		editmodel.addAttribute("email",email);
		editmodel.addAttribute("cell",cellNo);
		editmodel.addAttribute("addr1",address);
		editmodel.addAttribute("addr2",address2);
		
		
		return new ModelAndView("EditMyProfile", editmodel);
    }
	
	
}
