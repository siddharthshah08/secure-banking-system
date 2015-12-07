package com.asu.ss.DAO;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.SaltClass;
import com.asu.ss.util.HibernateUtil;


public class SaltClassDAO {

	Connection conn=null;
	private static SessionFactory factory;
		

		public SaltClass find(String criteria, String value)
		{
			
			Session session = null;
			Transaction tx = null;
			try {
			   factory = HibernateUtil.configureSessionFactory();
			   session = factory.openSession();
			   tx = session.beginTransaction();
			   Criteria cr = session.createCriteria(SaltClass.class);
			   cr.add(Restrictions.eq(criteria, value));
			   @SuppressWarnings("unchecked")
			   List<SaltClass> validUsers = cr.list();
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
		
		
		public void persist(SaltClass salt)
		{
			
			Session session = null;
			Transaction tx = null;
			try {
			   factory = HibernateUtil.configureSessionFactory();
			   session = factory.openSession();
			   tx = session.beginTransaction();
			   session.saveOrUpdate(salt);		  
			   tx.commit();
			}
			catch (Exception e) {
			   if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			}finally {
			   session.close();
			}
			
		}
		
		
		public void delete(SaltClass salt)
		{
			
			Session session = null;
			Transaction tx = null;
			try {
			   factory = HibernateUtil.configureSessionFactory();
			   session = factory.openSession();
			   tx = session.beginTransaction();
			   session.delete(salt);		  
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
