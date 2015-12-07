package com.asu.ss.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.Accounts;
import com.asu.ss.pojo.Transactions;
import com.asu.ss.util.HibernateUtil;


import javax.servlet.http.HttpSession;

public class TransactionsDAO {
private SessionFactory sessionFactory;

private static SessionFactory factory;

HttpSession SessionID;
	
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
	
	public List<Transactions> fetchtransactions(String accountnumber)
	{
		sessionFactory = HibernateUtil.configureSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			
		   tx = session.beginTransaction();	   
		   Criteria cr = session.createCriteria(Transactions.class);
		   cr.add(Restrictions.eq("fromAccountNumber", accountnumber));
		   List<Transactions> transactionlist = cr.list();
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
	
	public void persist(Transactions transaction)
	{
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.save(transaction);
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
	}
	
	public void delete(Transactions transaction)
	{
		
		Session session = null;
		Transaction tx = null;
		try {
		   factory = HibernateUtil.configureSessionFactory();
		   session = factory.openSession();
		   tx = session.beginTransaction();
		   session.delete(transaction);		  
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
	