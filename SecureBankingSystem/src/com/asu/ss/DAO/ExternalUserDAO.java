package com.asu.ss.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.ExternalUser;
import com.asu.ss.util.HibernateUtil;


public class ExternalUserDAO {

	private static SessionFactory factory;
	
	public void persist(ExternalUser externaluser)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.saveOrUpdate(externaluser);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
	}
	
	public ExternalUser find(String userName)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   Criteria cr = session.createCriteria(ExternalUser.class);
		   cr.add(Restrictions.eq("userName", userName));
		   @SuppressWarnings("unchecked")
		   List<ExternalUser> validUsers = cr.list();
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
	
	public void delete(ExternalUser exteraluser)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.delete(exteraluser);		  
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
