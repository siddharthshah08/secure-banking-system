package com.asu.ss.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.asu.ss.DAO.ToDoDAO;
import com.asu.ss.pojo.ToDo;




@Controller
public class ToDoController {

	@RequestMapping(value="/ToDo", method=RequestMethod.GET)
    public ModelAndView getMyToDoPage(HttpSession sessionID)   
    { 
    String userName= (String) sessionID.getAttribute("userName");
    ToDoDAO toDoDAO=new ToDoDAO();
    List<ToDo> myTodo=toDoDAO.findMyToDoList(userName);
    return new ModelAndView("ToDo","message",myTodo);
    }
}
