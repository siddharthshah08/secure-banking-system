package com.asu.ss.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.AllUsers;
import com.asu.ss.util.HibernateUtil;


public class AllusersDAO {

	private SessionFactory sessionFactory;
	
	private static SessionFactory factory;
	
	public AllUsers findUser(String userName)
	{
		sessionFactory = HibernateUtil.configureSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();		   
		   Criteria cr = session.createCriteria(AllUsers.class);
		   cr.add(Restrictions.eq("userName", userName));
		   //cr.add(Restrictions.eq("password", password));
		   List<AllUsers> validUsers = cr.list();
		   
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
	
	
	public void persist(AllUsers allusers)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.saveOrUpdate(allusers);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
	}
	
	
	public void delete(AllUsers alluser)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.delete(alluser);		  
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
