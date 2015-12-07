package com.asu.ss.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.DAO.AccountsDAO;
import com.asu.ss.DAO.MerchantClaimDAO;
import com.asu.ss.DAO.TransactionsDAO;
import com.asu.ss.pojo.Accounts;
import com.asu.ss.pojo.MerchantClaim;
import com.asu.ss.pojo.Transactions;


@Controller
public class DisplaytransactionController {

	
	public DisplaytransactionController()
	{
		
	}
	
	@RequestMapping(value="/Transactionlist", method=RequestMethod.GET)
    public ModelAndView post(HttpSession sessionID) throws SQLException   
    {  
		
		//TODO : code for MAC Address
		
		//code for adding new internal user
		
		System.out.println(sessionID.getAttribute("priority"));
		
		if(sessionID.getAttribute("priority").toString()=="10")
		{
		
		TransactionsDAO transactionsDAO = new TransactionsDAO();
		Accounts accounts = transactionsDAO.fetchaccountnumber(sessionID.getAttribute("userName").toString());
		String accountnumber=accounts.getAccountNumber();
		List<Transactions> transaction = transactionsDAO.fetchtransactions(accountnumber);
		
		
		return new ModelAndView("Transactionlist","message",transaction);
		
		}
		
		else
			
		{
		
			MerchantClaimDAO merchantClaimDAO = new MerchantClaimDAO();
			
			AccountsDAO accountsDAO=new AccountsDAO();
			
			Accounts accounts = accountsDAO.find("userName",sessionID.getAttribute("userName").toString());
			
			String accountnumber=accounts.getAccountNumber();
			
			System.out.println("--------"+accountnumber+"------------");
			
			List<MerchantClaim> transactions = merchantClaimDAO.fetchtransactions(accountnumber);			
			
			return new ModelAndView("MerchantTransaction","message",transactions);			
			
		}
	
    }

}
