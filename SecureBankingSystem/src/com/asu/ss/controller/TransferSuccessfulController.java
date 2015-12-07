package com.asu.ss.controller;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.util.modelClass;



@Controller
public class TransferSuccessfulController {
	
	
	public TransferSuccessfulController() throws SQLException
	{		
		
		
	}

	@RequestMapping(value="/FundTransferSuccessful", method=RequestMethod.POST)
    public ModelAndView post(@RequestParam("txtOtherbank")String otp, HttpSession sessionID) throws SQLException, NumberFormatException, ParseException   
    {  
				
		modelClass model=new modelClass();
		
		Boolean isSuccessful=model.transferFunds(sessionID.getAttribute("TransID").toString(),sessionID.getAttribute("TransDate").toString(),sessionID.getAttribute("from").toString(),sessionID.getAttribute("to").toString(), Integer.parseInt(sessionID.getAttribute("TransferAmt").toString()),otp);
		
		if(isSuccessful==true)
		
			return new ModelAndView("FundTransferSuccessful","message","Transaction successful!");
		
		else
			
			return new ModelAndView("FundTransferSuccessful","message","Sorry transaction failed!");
	
    }
	
	
}
