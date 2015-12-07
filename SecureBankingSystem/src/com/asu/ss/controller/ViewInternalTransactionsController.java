package com.asu.ss.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.DAO.InternalUserDAO;
import com.asu.ss.DAO.InternalUserTransactionDAO;
import com.asu.ss.pojo.InternalUser;
import com.asu.ss.pojo.InternalUserTransaction;

@Controller
public class ViewInternalTransactionsController {

	@RequestMapping(value="/ViewAllTransaction", method=RequestMethod.GET)
    public ModelAndView getMyTransactions(HttpSession sessionID) throws Exception   
    {  
		
		
		
		String loggedInUserName = (String)sessionID.getAttribute("userName");
		//Find the Designation of the LoggedInUser to show the correct Transactions.
		InternalUserDAO internalUserDAO = new InternalUserDAO();
		InternalUser loggedInUser = internalUserDAO.findInternalUser(loggedInUserName);
		InternalUserTransactionDAO internalUserTransactionDAO =  new InternalUserTransactionDAO();
		List<InternalUserTransaction> myAuthorizedTransactions=new ArrayList<InternalUserTransaction>();
		if (loggedInUser.getDesignation().equalsIgnoreCase("corporate"))
		{
			myAuthorizedTransactions = internalUserTransactionDAO.findALLTransactions();
		}
		else if (loggedInUser.getDesignation().equalsIgnoreCase("manager"))
		{
			List<InternalUser> mySubordinates = internalUserDAO.findSubordinates(loggedInUser.getDepartment(), loggedInUser.getUserName());
			Set<String> meAndMySubordinates = new HashSet<String>();
			for (InternalUser myEachSubordinates : mySubordinates)
			{
				//add the usernames of my subordinates
				meAndMySubordinates.add(myEachSubordinates.getUserName());
			}
			//add my name
			meAndMySubordinates.add(loggedInUser.getUserName());
			//list of all transactions.
			
			List<InternalUserTransaction> myDummyAuthorizedTransactions = internalUserTransactionDAO.findALLTransactions();
			for (InternalUserTransaction eachTransaction : myDummyAuthorizedTransactions)
			{
				if (meAndMySubordinates.contains(eachTransaction.getUserName()))
						{
					myAuthorizedTransactions.add(eachTransaction);
					
						}
			}
			
			
		}
		else{
			myAuthorizedTransactions = internalUserTransactionDAO.findMyTransactions(loggedInUserName);
			
		}
		int c=1;
		List<String> transactions = new ArrayList<String>();
		if (myAuthorizedTransactions==null)
		{
			
			myAuthorizedTransactions=new ArrayList<InternalUserTransaction>();
		}
		for (InternalUserTransaction eachInternalUserTransaction : myAuthorizedTransactions)
		{
			
			String eachTransaction = String.valueOf(c)+ "------> "+ eachInternalUserTransaction.getUserName()  + "  "+ eachInternalUserTransaction.getActionPerformed() +"   " + eachInternalUserTransaction.getFirstName() +  "  " + eachInternalUserTransaction.getLastName();
			transactions.add(eachTransaction);
			c++;
		}
		
		return new ModelAndView("ViewAllTransactions","message",transactions);
	
    }
}
