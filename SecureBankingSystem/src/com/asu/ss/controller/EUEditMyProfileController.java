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

import com.asu.ss.DAO.ExternalUserDAO;
import com.asu.ss.pojo.ExternalUser;


@Controller
public class EUEditMyProfileController {

	@RequestMapping(value="EUEditMyProfileSuccessful", method=RequestMethod.POST)
	public ModelAndView post(@RequestParam("eutxtadd1") String textAddress1, @RequestParam("eutxtadd2") String textAddress2, @RequestParam("eutxtcity") String city,@RequestParam("eutxtstate") String state,@RequestParam("eutxtzipcode") String zipCode,@RequestParam("eutxtphone") String phoneNumber,@RequestParam("eutxtcell") String cellNumber,@RequestParam("eutxtemail") String email,HttpSession sessionID) throws SQLException  
    {
		
		//System.out.println("Coming heeeeerrrrrrrrrrrreeeee");
		
		String userName = (String)sessionID.getAttribute("userName");
		if(userName == null)
		{
			return new ModelAndView("index");
		}
		//System.out.println("Sesssiionnnnn settttttt");
		
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
			
			//EUEditMyProfileSuccessful.jsp
			//EUEditMyProfileSuccessful
		
		return new ModelAndView("/EUEditMyProfileSuccessful","message",userName);	
    }
	
	
	@RequestMapping(value="EUEditMyProfile", method=RequestMethod.GET)
	public ModelAndView get(HttpSession sessionID) throws SQLException  
    {  
		String userName = sessionID.getAttribute("userName").toString();	
		if(userName == null)
		{
			return new ModelAndView("index");
		}
		ExternalUserDAO externalUserDAO = new ExternalUserDAO();
		ExternalUser loggedInUser = externalUserDAO.find(userName);
		
		String city = loggedInUser.getCity();
		//System.out.println("checking for city retrival " + city);
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
	
		return new ModelAndView("EUEditMyProfile", editmodel);
		
		
    }
}
