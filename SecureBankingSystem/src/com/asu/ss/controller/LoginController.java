package com.asu.ss.controller;



import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.DAO.AllusersDAO;
import com.asu.ss.DAO.ExternalUserDAO;
import com.asu.ss.DAO.InternalUserDAO;
import com.asu.ss.DAO.SaltClassDAO;
import com.asu.ss.pojo.AllUsers;
import com.asu.ss.pojo.ExternalUser;
import com.asu.ss.pojo.InternalUser;
import com.asu.ss.pojo.SaltClass;
import com.asu.ss.pojo.UserPriorityDepartment;
import com.asu.ss.util.modelClass;


@Controller
public class LoginController {	
	
	public LoginController() throws SQLException
	{
		
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
    public ModelAndView post()   
    {  
		return new ModelAndView("index","message","");
	
    }

	@RequestMapping(value="/ExternalWelcomePage", method=RequestMethod.GET)
    public ModelAndView getExternalWelcome()   
    {  
		return new ModelAndView("ExternalWelcomePage","message","");
	
    }

	
	@RequestMapping(value="/transferfunds", method=RequestMethod.GET)
    public ModelAndView getTransferfunds()   
    {  
		return new ModelAndView("TransferFund","message",true);
	
    }
	
	@RequestMapping(value="/addInternalUser", method=RequestMethod.GET)
    public ModelAndView get()   
    {  
		return new ModelAndView("AddInternalUser","message",true);
	
    }
	
	
		
	@RequestMapping(value="/WelcomePage", method=RequestMethod.POST)
    public ModelAndView post(@RequestParam("username") String userName, @RequestParam("password") String password, HttpSession sessionID) throws SQLException, NoSuchAlgorithmException  
    {  
	
		AllusersDAO allusersDAO = new AllusersDAO();
		
		AllUsers loggedInUser = allusersDAO.findUser(userName);
		
		if(loggedInUser==null)
			
			return new ModelAndView("index","message","Login failed : Incorrect Username/Password");
		
		if(loggedInUser.getIsBlocked()==3)
			
			return new ModelAndView("index","message","Your account has been blocked please contact the bank to gain access to your account");
		
		SaltClassDAO saltDAO=new SaltClassDAO();
		
		SaltClass salt=saltDAO.find("userName",userName);
		
		System.out.println("password in line 57 in login controller is " + password);
		System.out.println("this is the salt obtanied" + salt.getSaltHash());
		String pass=password+salt.getSaltHash();
		 
		System.out.println("this is pass"  + pass);
		modelClass model=new modelClass();
			
		if (loggedInUser != null && loggedInUser.getIsBlocked()<3 && (loggedInUser.getPassword().equals(model.passwordSalt(pass))))
		{			
			
			loggedInUser.setIsBlocked(0);
			
			allusersDAO.persist(loggedInUser);
			
			sessionID.setAttribute("userName",userName);			
			String customerType = loggedInUser.getUserType();
			if (customerType.equals("Internal"))
			{
				InternalUserDAO internalUserDao = new InternalUserDAO();
				InternalUser loggedUser = internalUserDao.findInternalUser(userName);
				
				if(loggedUser.getActiveSessionID().equals("0000"))
					
				{
				
				loggedUser.setActiveSessionID(sessionID.getId());
				String department = loggedUser.getDepartment();
				//int priority = loggedUser.getPriority();
				internalUserDao.persist(loggedUser);
				return new ModelAndView("WelcomePage","message",new UserPriorityDepartment(department,0));
				
				}
				
				else
					
					return new ModelAndView("index","message","Close any other active session to log in!");
					
					
				
			}
			else if (customerType.equals("External"))
			{
				
				sessionID.setAttribute("userName",userName);
								
				ExternalUserDAO externaluserdao=new ExternalUserDAO();
				
				ExternalUser loggedExternal=externaluserdao.find(userName);
				
				sessionID.setAttribute("priority", loggedExternal.getPriority());
				
				if(loggedExternal.getActiveSessionID().equals("0000"))
				{
				
				loggedExternal.setActiveSessionID(sessionID.getId());
				
				externaluserdao.persist(loggedExternal);
				
				if(loggedExternal.getPriority()==10)
					
				{				
				
				return new ModelAndView("ExternalWelcomePage","message",true);
				
				}
				
				else if(loggedExternal.getPriority()==20)
				{
					
					
					
					return new ModelAndView("MerchantWelcomePage","message",true);
					
				}
				
				else 
					
					return new ModelAndView("index","message","Close any other active session to log in!");
					
				}
				
				else
					
					return new ModelAndView("index","message","Close any other active session to log in!");
					
			}
			
			else
				
				return new ModelAndView("index","message","Sorry not recognised user!");
			
		}
		else
		{			
			
			int numBlocked=loggedInUser.getIsBlocked();
			
			numBlocked++;
			
			loggedInUser.setIsBlocked(numBlocked);
			
			allusersDAO.persist(loggedInUser);
			
			return new ModelAndView("index","message","Login failed : Incorrect Username/Password");	
		}
		        
    }
}

