package com.asu.ss.DAO;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.asu.ss.pojo.InternalUserTransaction;
import com.asu.ss.util.HibernateUtil;




public class InternalUserTransactionDAO {
	Connection conn=null;
	private static SessionFactory factory;
	/**
	 * @param args
	 */
	
	public InternalUserTransactionDAO(){
		
	}
	
	
	public void persist(InternalUserTransaction internalUserTransaction)
		{
			Session session = null;
			Transaction tx = null;
			try {
			   factory = HibernateUtil.configureSessionFactory();
			   session = factory.openSession();
			   tx = session.beginTransaction();
			   session.saveOrUpdate(internalUserTransaction);
			   tx.commit();
			}
			catch (Exception e) {
			   if (tx!=null) tx.rollback();
			   e.printStackTrace(); 
			}finally {
			   session.close();
			}
		}
	


	public List<InternalUserTransaction> findMyTransactions(String userName) throws Exception
		{	

	Session session = null;
	Transaction tx = null;
	try {
	   factory = HibernateUtil.configureSessionFactory();
	   session = factory.openSession();
	   tx = session.beginTransaction();
	   Criteria cr = session.createCriteria(InternalUserTransaction.class);
	   cr.add(Restrictions.eq("userName", userName));
	   @SuppressWarnings("unchecked")
	   List<InternalUserTransaction> myTransactions = cr.list();
	   if (myTransactions.size()!= 0 )
	   {
		   return myTransactions;
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
	
	public List<InternalUserTransaction> findALLTransactions() throws Exception
	{	

		Session session = null;
		Transaction tx = null;
		try {
   factory = HibernateUtil.configureSessionFactory();
   session = factory.openSession();
   tx = session.beginTransaction();
   Criteria cr = session.createCriteria(InternalUserTransaction.class);
   @SuppressWarnings("unchecked")
   List<InternalUserTransaction> myTransactions = cr.list();
   if (myTransactions.size()!= 0 )
   {
	   return myTransactions;
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


