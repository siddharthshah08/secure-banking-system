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
import com.asu.ss.DAO.InternalUserDAO;
import com.asu.ss.DAO.InternalUserTransactionDAO;
import com.asu.ss.pojo.AllUsers;
import com.asu.ss.pojo.InternalUser;
import com.asu.ss.pojo.InternalUserTransaction;
import com.asu.ss.util.modelClass;


@Controller
public class AddInternalUserController {

	
	public AddInternalUserController()
	{
		
	}
	
	@RequestMapping(value="/UserAdddedSuccessfully", method=RequestMethod.POST)
	public ModelAndView post(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName, @RequestParam("txtadd1") String textAddress1,@RequestParam("txtadd2") String textAddress2,@RequestParam("txtcity") String city,@RequestParam("txtstate") String state,@RequestParam("txtzipcode") String zipCode,@RequestParam("txtphone") String phoneNumber,@RequestParam("txtcell") String cellNumber,@RequestParam("txtemail") String email,@RequestParam("txtdepartment") String department,@RequestParam("txtdesignation") String designation,@RequestParam("txtmanager") String manager,@RequestParam("SSN") String ssn,@RequestParam("salary") String salary,@RequestParam("securityQues1") String securityQues1,@RequestParam("securityAns1") String securityAns1,@RequestParam("securityQues2") String securityQues2,@RequestParam("securityAns2") String securityAns2,@RequestParam("securityQues3") String securityQues3,@RequestParam("securityAns3") String securityAns3,HttpSession sessionID) throws SQLException, NoSuchAlgorithmException   
    {  
		
		modelClass model=new modelClass();
		String userName = firstName+"."+lastName;
		//randomly generate the password for all
		
		Random rand=new Random();
		
		
		//TODO : code for MAC Address
		
		//code for adding new internal user
		InternalUser internalUser = new InternalUser(firstName, lastName, textAddress1, textAddress2, city, state, zipCode, phoneNumber, cellNumber, department, manager, Integer.parseInt(salary), ssn,  email, userName, "0000", "123456", 0, 0, designation, securityQues1, securityAns1, securityQues2, securityAns2, securityQues3, securityAns3);
		InternalUserDAO internalUserDAO = new InternalUserDAO();
		internalUserDAO.persist(internalUser);
		
		AllUsers alluser=new AllUsers();
		
		alluser.setUserName(userName);
		
		
		
		String password = userName.substring(0, 2)+sessionID.getId().toString().substring(0, 5)+rand.nextInt(1000);
		
		System.out.println("--------------System generated password-------------------: "+password);
		
		alluser.setPassword(password);

		alluser.setUserType("Internal");
		
		alluser.setIsBlocked(0);
		
		AllusersDAO allusersDAO=new AllusersDAO();
		
		allusersDAO.persist(alluser);
		allusersDAO.persist(model.hashPassword(alluser));
				
		model.send("User name and Password", internalUser.getEmail(), password, userName);
		
		//add this action the Internal User transaction table
		
		InternalUserTransactionDAO internalUserTransactionDAO = new InternalUserTransactionDAO();
		String operation="Added";
		InternalUserTransaction newTransaction =new InternalUserTransaction((String)sessionID.getAttribute("userName"),operation,firstName,lastName);
		internalUserTransactionDAO.persist(newTransaction);
		
		return new ModelAndView("UserAdddedSuccessfully","message",userName);
	
    }

}
