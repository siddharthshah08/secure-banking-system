package com.asu.ss.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.ToDo;
import com.asu.ss.util.HibernateUtil;


public class ToDoDAO {

	private SessionFactory factory;
	public ToDoDAO(){
		
	}
	
	public List<ToDo> findMyToDoList(String userName)
	{
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(ToDo.class);
		   cr.add(Restrictions.eq("actioneer", userName));
		   cr.add(Restrictions.eq("isDone", 0));
		   List<ToDo> validUsers = cr.list();
		   if (validUsers.size()!= 0 )
		   {
			   return validUsers;
		   }
		   
		   
		   tx.commit();
		   
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return null;
	}
	
	public ToDo findAParticularToDo(String actioneer,String associatedObject,String action)
	{
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(ToDo.class);
		   cr.add(Restrictions.eq("actioneer", actioneer));
		   cr.add(Restrictions.eq("associatedUser", associatedObject));
		   cr.add(Restrictions.eq("action", action));
		   ToDo validUsers = (ToDo) cr.uniqueResult();
		   if (validUsers!=null )
		   {
			   return validUsers;
		   }
		   
		   
		   tx.commit();
		   
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return null;
	}
	
	
	public void persist(ToDo toDo)
		{
			factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx = null;
			try {
			   tx = session.beginTransaction();
			   session.save(toDo);
			   tx.commit();
			}
			catch (Exception e) {
			   if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			}finally {
			   session.close();
			}
		}

	
	
	public void delete(ToDo todo)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.delete(todo);		  
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
	}
	
		}



