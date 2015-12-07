package com.asu.ss.controller;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.pojo.Transactions;
import com.asu.ss.util.modelClass;


@Controller
public class AddFundsController {
	
	String AccountNumber = null;
	
	int TransferAmount = 0;
		
	public AddFundsController() throws SQLException
	{
			
		
	}
	
/*	@RequestMapping(value="/transferfunds", method=RequestMethod.POST)
    public ModelAndView post(@RequestParam("txtOtherbank") String txtOtherbank, @RequestParam("acctNum") String acctNum, @RequestParam("transAmt") int transAmt) throws SQLException   
    {   
		AccountsDAO accountsDAO = new AccountsDAO();
		otpEmail email = new otpEmail();
		String emailID=accountsDAO.getEmail("abuduru"); // get the username from session
		email.Emailing(emailID); // email the user with otp
		AccountNumber = acctNum;
		
		return new ModelAndView("OTPpage");
		
			
    }*/
	
	@RequestMapping(value="/OTPpage", method=RequestMethod.POST)
    public ModelAndView post(HttpSession sessionID, @RequestParam("txtOtherbank") String txtOtherbank, @RequestParam("acctNum") String acctNum, @RequestParam("transAmt") int transAmt) throws SQLException   
    {  
		
	modelClass model=new modelClass();	
		
	Transactions fundsPresent = model.checkFunds(acctNum, sessionID.getAttribute("userName").toString(), transAmt);
		
	if (fundsPresent!=null)
	{		
		
		sessionID.setAttribute("TransID", fundsPresent.getTransactionID());
		
		sessionID.setAttribute("from", fundsPresent.getFromAccountNumber());
		
		sessionID.setAttribute("TransDate", fundsPresent.getTransactionDate());
		
		sessionID.setAttribute("to", fundsPresent.getToAccountNumber());
		
		sessionID.setAttribute("TransferAmt", ((Integer)transAmt).toString());
			
		return new ModelAndView("OTPpage","message","");
	}
	
	else
	{
		
		sessionID.setAttribute("TransID", "");
		
		sessionID.setAttribute("from", "");
		
		sessionID.setAttribute("TransDate", "");
	
		return new ModelAndView("TransferFund","message","No sufficient balance");
		
	}
	/*AccountsDAO accountsDAO = new AccountsDAO();
	Accounts accounts = new Accounts(AccountNumber);
	accountsDAO.addFunds(accounts, TransferAmount);
	int returnvalue = accountsDAO.subFunds(accounts, TransferAmount);
	if (returnvalue == 1)
	{
	return new ModelAndView("FundTransferSuccessful","message","TransferSuccessful");
	}
	else
	{
	return new ModelAndView("FundTransferSuccessful","message","Not sufficient balance");
	}*/

    }
}
