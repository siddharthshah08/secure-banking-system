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
import com.asu.ss.DAO.ToDoDAO;
import com.asu.ss.pojo.InternalUser;
import com.asu.ss.pojo.InternalUserTransaction;
import com.asu.ss.pojo.ToDo;




@Controller
public class ModifyDeleteController {
	
	public ModifyDeleteController()
	{
		
	}
	
	/*
	 * To display the list of subordinates to delete and modify under a manager.
	 */
	@RequestMapping(value="/modifyDeleteInternalUser", method=RequestMethod.GET)
    public ModelAndView get(HttpSession sessionID) throws Exception  
    {  
		
		
				//check for correct permissions.
				String userName = (String) sessionID.getAttribute("userName");
				InternalUserDAO internalUserDAO = new InternalUserDAO();
				InternalUser loggedInUser = internalUserDAO.findInternalUser(userName);
				if (loggedInUser.getDesignation().equalsIgnoreCase("employee") || loggedInUser.getDesignation().equalsIgnoreCase("sysadmin"))
				{
					return new ModelAndView("NotAuthorizedModDel","message",null);
				}
				
				String departmentOfLoggedInUser = loggedInUser.getDepartment();
				List<InternalUser> allSubordinates = internalUserDAO.findSubordinates(departmentOfLoggedInUser,userName);
				return new ModelAndView("ModifyDeleteSubordinates", "message", allSubordinates);
		
    }
	
	@RequestMapping(value="/ModifySubordinate", method=RequestMethod.POST)
    public ModelAndView post(@RequestParam("modUserame") String user,HttpSession sessionID) throws SQLException  
    {
	
		String userName = user;
		InternalUserDAO internalUserDAO = new InternalUserDAO();
		InternalUser selectedUser = internalUserDAO.findInternalUser(userName);
		sessionID.setAttribute("modUser",user);
		//Sid - Fetch column values which can be updated by the user 
		
		String city = selectedUser.getCity();
		String state = selectedUser.getState();
		String zipcode = selectedUser.getZipcode();
		String phoneNo = selectedUser.getPhoneNumber();
		String email = selectedUser.getEmail();
		String cellNo = selectedUser.getCellNumber();
		String department = selectedUser.getDepartment(); 
		String designation  = selectedUser.getDesignation();
		
		String address = selectedUser.getAddress1();
		String address2 = selectedUser.getAddress2();
		ModelMap editmodel = new ModelMap();
		
		editmodel.addAttribute("city",city);
		editmodel.addAttribute("state",state);
		editmodel.addAttribute("zipcode",zipcode);
		editmodel.addAttribute("phoneNo",phoneNo);
		editmodel.addAttribute("email",email);
		editmodel.addAttribute("cell",cellNo);
		editmodel.addAttribute("addr1",address);
		editmodel.addAttribute("addr2",address2);
		editmodel.addAttribute("dept",department);
		editmodel.addAttribute("designation", designation);
		
		
		return new ModelAndView("ModifySubordinate", editmodel);

		
    }
	@RequestMapping(value="/UserModifiedSuccessfully", method=RequestMethod.POST)
    public ModelAndView post(@RequestParam("modUseradd1") String textAddress1, @RequestParam("modUseradd2") String textAddress2, @RequestParam("modUsercity") String city,@RequestParam("modUserstate") String state,@RequestParam("modUserzipcode") String zipCode,@RequestParam("modUserphone") String phoneNumber,@RequestParam("modUsercell") String cellNumber,@RequestParam("modUseremail") String email,@RequestParam("modUserdept") String dept,@RequestParam("designation") String designation,HttpSession sessionID) throws SQLException  
    {  
		
		
		String modUser = (String)sessionID.getAttribute("modUser");
		
		
		/*if(userName == null)
		{
			return new ModelAndView("index");
		}*/
		
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
			internalUser.setDepartment(dept);
			internalUser.setUserName(modUser);
			internalUser.setDesignation(designation);
			
			internalUserDAO1.persist(internalUser);
			String modifiedUserName = internalUser.getFirstName() + internalUser.getLastName();
			
			InternalUserTransactionDAO internalUserTransactionDAO = new InternalUserTransactionDAO();
			String operation="Modified";
			InternalUserTransaction newTransaction =new InternalUserTransaction((String)sessionID.getAttribute("userName"),operation,internalUser.getFirstName(),internalUser.getLastName());
			internalUserTransactionDAO.persist(newTransaction);
		
		return new ModelAndView("UserModifiedSuccessfully","message",modifiedUserName);	
    }
	
	
	@RequestMapping(value="/DeleteSubordinate", method=RequestMethod.POST)
    public ModelAndView deleteSubordinates(@RequestParam("delUserame") String userToBeDeletedUserName,HttpSession sessionID) throws SQLException  
    {
	
		
		
		InternalUserDAO internalUserDAO = new InternalUserDAO();
		InternalUser userToBeDeleted = internalUserDAO.findInternalUser(userToBeDeletedUserName);
		if (userToBeDeleted.getFirstDelete()==1)
		{
			internalUserDAO.delete(userToBeDeleted);
			InternalUserTransactionDAO internalUserTransactionDAO = new InternalUserTransactionDAO();
			//Added a transaction to the Internal User Transaction Table.
			String operation="Deleted";
			InternalUserTransaction newTransaction =new InternalUserTransaction((String)sessionID.getAttribute("userName"),operation,userToBeDeleted.getFirstName(),userToBeDeleted.getLastName());
			internalUserTransactionDAO.persist(newTransaction);
			
			//delete from ToDo Table also.
			ToDoDAO toDoDAO=new ToDoDAO();
			toDoDAO.delete(toDoDAO.findAParticularToDo((String)sessionID.getAttribute("userName"), userToBeDeleted.getUserName(),"Delete"));
			return new ModelAndView("DeleteSubordinate","message","The Employee has been deleted from the Records");
		
		}
		else{
			userToBeDeleted.setFirstDelete(1);
			internalUserDAO.persist(userToBeDeleted);
			//String manager = userToBeDeleted.getManager();
			InternalUser loggedInUser=internalUserDAO.findInternalUser((String) sessionID.getAttribute("userName"));
			String manager = loggedInUser.getManager();
			if (loggedInUser.getDesignation().equalsIgnoreCase("corporate"))
			{
				//corporrate people have authority to directly delete a employee
				internalUserDAO.delete(userToBeDeleted);
				//Added a transaction to the Internal User Transaction Table.
				InternalUserTransactionDAO internalUserTransactionDAO = new InternalUserTransactionDAO();
				String operation="Deleted";
				InternalUserTransaction newTransaction =new InternalUserTransaction((String)sessionID.getAttribute("userName"),operation,userToBeDeleted.getFirstName(),userToBeDeleted.getLastName());
				internalUserTransactionDAO.persist(newTransaction);
				
				return new ModelAndView("DeleteSubordinate","message","The Employee has been deleted from the Records");
			}
			else
			{
				//Have to Finalize based on what Manager Name is given.Right Now its on First Name basis
				/*String firstName = manager.substring(0, manager.indexOf(" "));
				String lastName = manager.substring(manager.indexOf(" "));*/
				InternalUser userNameManager = internalUserDAO.findInternalUserByName(manager/*, lastName*/);
				String actioneer = userNameManager.getUserName();
				ToDo newEntry = new ToDo(actioneer, userToBeDeletedUserName, 0, "Delete", "Requesting second Authorization for Deletion");
				ToDoDAO toDoDAO=new ToDoDAO();
				toDoDAO.persist(newEntry);
				return new ModelAndView("DeleteSubordinate","message","Notification has been send to Manager for approval for deletion");
			}
		
		}
		
		
		
    }
	
	
}
