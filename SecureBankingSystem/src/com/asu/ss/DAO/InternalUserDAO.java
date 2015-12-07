package com.asu.ss.DAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.InternalUser;
import com.asu.ss.util.HibernateUtil;



public class InternalUserDAO {
	
	Connection conn=null;
	private static SessionFactory factory;
		
	public InternalUserDAO()
	{
		
	}
	
		public ArrayList<InternalUser> findAll()
	{
	
		return new ArrayList<InternalUser> ();
		
	}
		
		public InternalUser findInternalUserByDepartment(String department)
		{	
			Session session = null;
			Transaction tx = null;
			try {
			   factory = HibernateUtil.configureSessionFactory();
			   session = factory.openSession();
			   tx = session.beginTransaction();
			   Criteria cr = session.createCriteria(InternalUser.class);
			   cr.add(Restrictions.eq("department", department));
			   @SuppressWarnings("unchecked")
			   List<InternalUser> validUsers = cr.list();
			   if (validUsers.size()!= 0 )
			   {
				   return validUsers.get(0);
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
		
		public InternalUser findInternalUserByName(String firstName/*,String lastName*/)
		{	
			Session session = null;
			Transaction tx = null;
			try {
			   factory = HibernateUtil.configureSessionFactory();
			   session = factory.openSession();
			   tx = session.beginTransaction();
			   Criteria cr = session.createCriteria(InternalUser.class);
			   cr.add(Restrictions.eq("firstName", firstName));
			   //cr.add(Restrictions.eq("firstName", lastName));		   
			   @SuppressWarnings("unchecked")
			   List<InternalUser> validUsers = cr.list();
			   if (validUsers.size()!= 0 )
			   {
				   return validUsers.get(0);
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
		
	public void persist(InternalUser internalUser)
	{
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.saveOrUpdate(internalUser);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
	}
	
	public List<InternalUser> findSubordinates(String department,String loggedInUser) throws Exception
	{

		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(InternalUser.class);
		   if (!department.equalsIgnoreCase("Corporate"))
		   {
		   cr.add(Restrictions.eq("department", department));
		   }
		   cr.add(Restrictions.ne("userName", loggedInUser));
		   @SuppressWarnings("unchecked")
		   List<InternalUser> validUsers = cr.list();
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
	
	public InternalUser findInternalUser(String userName)
	{	
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(InternalUser.class);
		   cr.add(Restrictions.eq("userName", userName));
		   @SuppressWarnings("unchecked")
		   List<InternalUser> validUsers = cr.list();
		   if (validUsers.size()!= 0 )
		   {
			   return validUsers.get(0);
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
	
	
	public List<InternalUser> findSubordinates(String department) throws Exception
	{

		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(InternalUser.class);
		   cr.add(Restrictions.eq("department", department));
		   cr.add(Restrictions.ne("firstDelete", 1));
		   @SuppressWarnings("unchecked")
		   List<InternalUser> validUsers = cr.list();
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
	
	
	public void delete(InternalUser internaluser)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
			if(internaluser.getFirstDelete()==1 && internaluser.getSecondDelete()==1)
			{
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.delete(internaluser);		  
		   tx.commit();
		}
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}		
	}
	
	public InternalUser findUser(String criteria, String value)
	{	
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(InternalUser.class);
		   cr.add(Restrictions.eq(criteria,value));
		   @SuppressWarnings("unchecked")
		   List<InternalUser> validUsers = cr.list();
		   if (validUsers.size()!= 0 )
		   {
			   return validUsers.get(0);
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
	

	}
	
	
	

