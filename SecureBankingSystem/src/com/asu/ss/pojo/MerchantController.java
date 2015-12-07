package com.asu.ss.pojo;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.asu.ss.DAO.ExternalUserDAO;
import com.asu.ss.DAO.TransactionsDAO;
import com.asu.ss.util.modelClass;

@Controller
public class MerchantController {

	/**
	 * @param args
	 */
	
	@RequestMapping(value="/MerchantWelcomePage", method=RequestMethod.GET)
	public ModelAndView getWelcomePage() throws SQLException  
    { 
		
		return new ModelAndView("MerchantWelcomePage","message","");
		
    }
	
	@RequestMapping(value="/MerChngPaswd", method=RequestMethod.GET)
	public ModelAndView getPasswordChange() throws SQLException  
    { 
		
		return new ModelAndView("MerChngPaswd","message","");
		
    }
	
	@RequestMapping(value="/MerEditMyProfileSuccesful", method=RequestMethod.POST)
	public ModelAndView postEditSuccessful(@RequestParam("mertxtadd1") String textAddress1, @RequestParam("mertxtadd2") String textAddress2, @RequestParam("mertxtcity") String city, @RequestParam("mertxtstate") String state, @RequestParam("mertxtzipcode") String zipCode, @RequestParam("mertxtphone") String phoneNumber, @RequestParam("mertxtcell") String cellNumber, @RequestParam("mertxtemail") String email, HttpSession sessionID) throws SQLException  
    { 
		
				String userName = (String)sessionID.getAttribute("userName");
				if(userName == null)
				{
					return new ModelAndView("index");
				}
				
				ExternalUserDAO externalUserDAO1=new ExternalUserDAO();		
				ExternalUser externalUser= externalUserDAO1.find(userName);
				System.out.println("Here is the username of the external user---" + userName);
					
				 
					externalUser.setAddress1(textAddress1);		
					externalUser.setAddress2(textAddress2);		
					externalUser.setCity(city);		
					externalUser.setState(state);		
					externalUser.setZipcode(zipCode);		
					externalUser.setPhoneNumber(phoneNumber);		
					externalUser.setCellNumber(cellNumber);		
					externalUser.setEmail(email);		
					externalUser.setUserName(userName);		
					externalUserDAO1.persist(externalUser);
				
		
		return new ModelAndView("MerEditMyProfileSuccesful","message",userName);
		
    }
	
	@RequestMapping(value="/MerchantClaimAmount", method=RequestMethod.GET)
	public ModelAndView getClaimAmount() throws SQLException  
    { 
		
		return new ModelAndView("MerchantClaimAmt","message","");
		
    }
	
	@RequestMapping(value="/MerchantTransaction", method=RequestMethod.GET)
	public ModelAndView getTransaction(HttpSession sessionID) throws SQLException  
    { 
		TransactionsDAO transactionsDAO = new TransactionsDAO();
		
		Accounts accounts = transactionsDAO.fetchaccountnumber(sessionID.getAttribute("userName").toString());
		String accountnumber=accounts.getAccountNumber();
		List<Transactions> transaction = transactionsDAO.fetchtransactions(accountnumber);
		
		if(transaction!=null)
		
			return new ModelAndView("MerchantTransaction","message",transaction);
		
		else
			
			return new ModelAndView("MerchantTransaction","message","No transactions made!");
		
    }

	@RequestMapping(value="/MerEditMyProfile", method=RequestMethod.GET)
	public ModelAndView getEditProfile(HttpSession sessionID) throws SQLException  
    { 
		
		String userName = sessionID.getAttribute("userName").toString();	
		if(userName == null)
		{
			return new ModelAndView("index");
		}
		ExternalUserDAO externalUserDAO = new ExternalUserDAO();
		ExternalUser loggedInUser = externalUserDAO.find(userName);
		
		String city = loggedInUser.getCity();
		String state = loggedInUser.getState();
		String zipcode = loggedInUser.getZipcode();
		String phoneNo = loggedInUser.getPhoneNumber();
		String email = loggedInUser.getEmail();
		String cellNo = loggedInUser.getCellNumber();
		
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
	
		return new ModelAndView("MerEditMyProfile", editmodel);
	
		
    }	
	
	
	@RequestMapping(value="/MerPswdUpdSuc", method=RequestMethod.POST)
	public ModelAndView postPasswordChangeSuccessful(HttpSession sessionID, @RequestParam("mercrntpaswd") String currentPassword,@RequestParam("mernewpaswd1") String newPassword) throws SQLException, NoSuchAlgorithmException    
    { 
		
		modelClass model=new modelClass();
		
		String userName=sessionID.getAttribute("userName").toString();
		
		Boolean passChangeSuccessful=model.changePassword(userName, currentPassword, newPassword);
		
		if(passChangeSuccessful==true)
			
			return new ModelAndView("MerPswdUpdSuc","message","");
		
		else
			
			return new ModelAndView("MerChngPaswd","message","Password Change Failed!");	
		
		
    }
	
	
	@RequestMapping(value="/MerAmtClaSuc", method=RequestMethod.POST)
	public ModelAndView post(HttpSession sessionID,@RequestParam("crdNum") String cardNumber, @RequestParam("custName") String customerName, @RequestParam("txtCCV") String cvv, @RequestParam("txtexpireDate") String expiry, @RequestParam("claimAmt") String claimAmount) throws SQLException, NumberFormatException, ParseException  
    { 
		
		modelClass model=new modelClass();
		
		boolean transferSuccessful=model.verifyMerchantClaim(sessionID.getAttribute("userName").toString(), cardNumber, customerName, cvv, expiry, Integer.parseInt(claimAmount));
		
		if(transferSuccessful==true)
		
			return new ModelAndView("MerAmtClaSuc","message","");
		
		else
			
			return new ModelAndView("MerchantClaimAmt","message","Transfer Failed");		
		
    }	
	
}
