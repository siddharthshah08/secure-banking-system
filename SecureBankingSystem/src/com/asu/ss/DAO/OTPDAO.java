package com.asu.ss.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.OTP;
import com.asu.ss.util.HibernateUtil;


public class OTPDAO {
	
	Connection conn=null;
	
	private static SessionFactory factory;
	
	public void persist(OTP otp)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.save(otp);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
	}
	
	public OTP find(String userName)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(OTP.class);
		   cr.add(Restrictions.eq("userName", userName));
		   @SuppressWarnings("unchecked")
		   List<OTP> validUsers = cr.list();
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
	
	
	public OTP find(String criteria, String value)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(OTP.class);
		   cr.add(Restrictions.eq(criteria, value));
		   @SuppressWarnings("unchecked")
		   List<OTP> validUsers = cr.list();
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
	
	
	public void delete(OTP otp)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.delete(otp);		  
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
