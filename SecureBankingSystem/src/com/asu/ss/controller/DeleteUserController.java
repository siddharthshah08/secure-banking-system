package com.asu.ss.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.DAO.InternalUserDAO;
import com.asu.ss.DAO.ToDoDAO;
import com.asu.ss.pojo.InternalUser;
import com.asu.ss.pojo.ToDo;


@Controller
public class DeleteUserController {

	public DeleteUserController()
	{
		
	}
	//This will be used as a controller for the delete button on the DeleteModify page.
	//basically add redirect the page to this controller
	@RequestMapping(value="/DeleteInternalUser", method=RequestMethod.POST)
    public ModelAndView post(HttpSession sessionID,String userToBeDeletedName) throws SQLException  
    {  
		//sessionID is used to get the current LoggedInUser
		//set the first delete to 1.
		String loggedInUserName = sessionID.getId();
		
		InternalUserDAO internalUserDAO = new InternalUserDAO();
		InternalUser userToBeDeleted = internalUserDAO.findInternalUser(userToBeDeletedName);
		userToBeDeleted.setFirstDelete(1);
		//update the TODO list of the manager of the loggedInEmployee to delete this user.
		if (userToBeDeleted.getSecondDelete()!=1)
		{
		InternalUser loggedInUser = internalUserDAO.findInternalUser(loggedInUserName);
		String managerName = loggedInUser.getManager();
		String managerUserName = internalUserDAO.findInternalUser(managerName).getUserName();
		//Persist in the TO DO table as primary key as the person responsible for doing the action.
		ToDo toDo = new ToDo();
		toDo.setActioneer(managerUserName);
		toDo.setAction("Delete");
		toDo.setAssociatedUserName(userToBeDeleted.getUserName());
		toDo.setIsDone(1);
		toDo.setComments("");
		
		ToDoDAO toDoDAO = new ToDoDAO();
		toDoDAO.persist(toDo);
		
		}
		//Create the JSP page to show the message has been delievered to second in Command ,i.e. his manager
		return new ModelAndView("SamplePageToShowMessageHasBeenDelivered", "message", true);
		
    }
}
