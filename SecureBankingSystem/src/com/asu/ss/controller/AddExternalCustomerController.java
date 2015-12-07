package com.asu.ss.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.DAO.AllusersDAO;
import com.asu.ss.DAO.ExternalUserDAO;
import com.asu.ss.DAO.InternalUserDAO;
import com.asu.ss.DAO.InternalUserTransactionDAO;
import com.asu.ss.pojo.AllUsers;
import com.asu.ss.pojo.ExternalUser;
import com.asu.ss.pojo.InternalUser;
import com.asu.ss.pojo.InternalUserTransaction;
import com.asu.ss.util.modelClass;


@Controller
public class AddExternalCustomerController {
	
	public AddExternalCustomerController()
	{
		
	}

	@RequestMapping(value="/addExternalCustomer", method=RequestMethod.GET)
    public ModelAndView getProperPage(HttpSession sessionID)   
    {  
		//check for correct permissions.
		String userName = (String) sessionID.getAttribute("userName");
		InternalUserDAO internalUserDAO = new InternalUserDAO();
		InternalUser loggedInUser = internalUserDAO.findInternalUser(userName);
		if (loggedInUser.getDesignation().equalsIgnoreCase("corporate") || loggedInUser.getDesignation().equalsIgnoreCase("manager") || loggedInUser.getDesignation().equalsIgnoreCase("sysadmin"))
		{
			return new ModelAndView("AddExternalUser","message","");
			
		}else 
			return new ModelAndView("NotAuthorizedAddExt","message",null);
		
    }
	
	
	
	@RequestMapping(value="/ExternalUserAddedSuccessfully", method=RequestMethod.POST)
	public ModelAndView post(@RequestParam("TypeOfUser") String userType, @RequestParam("extfname") String firstName, @RequestParam("extlname") String lastName, @RequestParam("exttxtadd1") String textAddress1,@RequestParam("exttxtadd2") String textAddress2,@RequestParam("exttxtcity") String city,@RequestParam("exttxtstate") String state,@RequestParam("exttxtzipcode") String zipCode,@RequestParam("exttxtphone") String phoneNumber,@RequestParam("exttxtcell") String cellNumber,@RequestParam("exttxtemail") String email,@RequestParam("extsecurityQues1") String securityQues1,@RequestParam("extsecurityAns1") String securityAns1,@RequestParam("extsecurityQues2") String securityQues2,@RequestParam("extsecurityAns2") String securityAns2,@RequestParam("extsecurityQues3") String securityQues3,@RequestParam("extsecurityAns3") String securityAns3,HttpSession sessionID) throws SQLException, NoSuchAlgorithmException   
    {  
	
		int priority;
		modelClass model=new modelClass();
		String userName = firstName+"."+lastName;
		//randomly generate the password for all
		
		Random rand=new Random();
		
		if(userType.equalsIgnoreCase("Merchant"))
		
			priority=20;
			
		else
			
			priority=10;	
				
		
		//TODO : code for MAC Address
		
		//code for adding new EXternal user
		ExternalUser externalUser = new ExternalUser(firstName, lastName, textAddress1, textAddress2, city, state, zipCode, phoneNumber, cellNumber, email, userName, "0000", "12346",securityQues1, securityAns1, securityQues2, securityAns2, securityQues3, securityAns3,priority);
		ExternalUserDAO externalUserDAO = new ExternalUserDAO();
		externalUserDAO.persist(externalUser);
		
		//make Entry into the Alluser Table
		AllUsers alluser=new AllUsers();
		alluser.setUserName(userName);
		//adding something at the end of the password to not store in the normal text format.
		

		String password = userName.substring(0, 2)+sessionID.getId().toString().substring(0, 5)+rand.nextInt(1000);
		
		alluser.setPassword(password);
		
		alluser.setUserType("External");
		
		alluser.setIsBlocked(0);
		
		AllusersDAO allusersDAO=new AllusersDAO();
		
		allusersDAO.persist(alluser);
		allusersDAO.persist(model.hashPassword(alluser));
		//I think something needs to be changed here.		
		model.send("User name and Password", externalUser.getEmail(), password, userName);
		
		//add this action the Internal User transaction table
		
		InternalUserTransactionDAO internalUserTransactionDAO = new InternalUserTransactionDAO();
		InternalUserTransaction newTransaction =new InternalUserTransaction((String)sessionID.getAttribute("userName"),"Added",firstName,lastName);
		internalUserTransactionDAO.persist(newTransaction);
		
		return new ModelAndView("ExternalUserAddedSuccessfully","message",userName);
	
    }

	
	
}
