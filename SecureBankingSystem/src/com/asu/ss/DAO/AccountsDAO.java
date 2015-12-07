package com.asu.ss.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.Accounts;
import com.asu.ss.util.HibernateUtil;


public class AccountsDAO {

Connection conn=null;
private static SessionFactory factory;
	
	/*public Accounts addFunds(Accounts accounts, int transAmt)
	{
		sessionFactory = HibernateUtil.configureSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			
		   tx = session.beginTransaction();
		   String accountnumber = accounts.getAccountNumber();
		   Accounts accounting = (Accounts)session.get(Accounts.class, accountnumber);
		   accounting.setBalance(accounting.getBalance()+transAmt);
		   session.update(accounting); 
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
	
	
	public int subFunds(Accounts accounts, int transAmt)
	{
		String username = "abuduru";  Fetch the username from session 
		int returnvalue=0;
		sessionFactory = HibernateUtil.configureSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			   tx = session.beginTransaction();
			   Criteria cr = session.createCriteria(Accounts.class);
			   cr.add(Restrictions.eq("userName", username));
			   @SuppressWarnings("unchecked")
			   List<Accounts> validUsers = cr.list();
			   Accounts accounting = validUsers.get(0); 
			   String senderaccount=accounting.getAccountNumber();
			  
		   accounting = (Accounts)session.get(Accounts.class, senderaccount);
		   if(accounting.getBalance()>transAmt)
		   {
		   accounting.setBalance(accounting.getBalance()-transAmt);
		   session.update(accounting);
		   tx.commit();
		   returnvalue = 1;
		   }

		   
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return returnvalue;
	}
	
	public String getEmail(String username)
	{
		String email = null;
		sessionFactory = HibernateUtil.configureSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			
		   tx = session.beginTransaction();
		   //Pass the user name to get the email id of the user
		   ExternalUser externaluser = (ExternalUser)session.get(ExternalUser.class, username);
		   email = externaluser.getEmail();
		   tx.commit();
		   
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return email;
	}*/

	public Accounts find(String criteria, String value)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(Accounts.class);
		   cr.add(Restrictions.eq(criteria, value));
		   @SuppressWarnings("unchecked")
		   List<Accounts> validUsers = cr.list();
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
	
	
	public void persist(Accounts account)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.saveOrUpdate(account);		  
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
	}
	
	
	public void delete(Accounts account)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.delete(account);		  
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
	

