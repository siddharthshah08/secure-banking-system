package com.asu.ss.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.Accounts;
import com.asu.ss.pojo.MerchantClaim;
import com.asu.ss.util.HibernateUtil;


public class MerchantClaimDAO {

	private SessionFactory sessionFactory;

	private static SessionFactory factory;


		
		public Accounts fetchaccountnumber(String userName)
		{
			sessionFactory = HibernateUtil.configureSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			//String userName = SessionID.getAttribute("userName").toString();
			try {
				
			   tx = session.beginTransaction();	   
			   Criteria cr = session.createCriteria(Accounts.class);
			   cr.add(Restrictions.eq("userName", userName));
			   List<Accounts> transactionlist = cr.list();
			   if(!transactionlist.isEmpty())
			   {
			   return transactionlist.get(0);
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
		
		public List<MerchantClaim> fetchtransactions(String accountnumber)
		{
			
			sessionFactory = HibernateUtil.configureSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				
			   tx = session.beginTransaction();	   
			   Criteria cr = session.createCriteria(MerchantClaim.class);
			   cr.add(Restrictions.eq("fromAccountNumber", accountnumber));
			   List<MerchantClaim> transactionlist = cr.list();
			   if(!transactionlist.isEmpty())
			   {
				   
				  return transactionlist;
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
		
		public void persist(MerchantClaim merchantClaim)
		{
			Session session = null;
			Transaction tx = null;
			try {
			   factory = HibernateUtil.configureSessionFactory();
			   session = factory.openSession();
			   tx = session.beginTransaction();
			   session.save(merchantClaim);
			   tx.commit();
			}
			catch (Exception e) {
			   if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			}finally {
			   session.close();
			}
		}
		
		public void delete(MerchantClaim merchantClaim)
		{
			
			Session session = null;
			Transaction tx = null;
			try {
			   factory = HibernateUtil.configureSessionFactory();
			   session = factory.openSession();
			   tx = session.beginTransaction();
			   session.delete(merchantClaim);		  
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
