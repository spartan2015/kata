package org.mseco.learning.hibernate2.transactions;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class HandleExceptionTest {

	private final static Logger log = Logger.getLogger(HandleExceptionTest.class);
	
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();		
		try{			
			
			// you code that might throw an error
			
			tx.commit();
						
		}catch(RuntimeException ex){
			try{
				tx.rollback();
			}catch(RuntimeException e){
				log.error("failed to rollback the transaction !",e);
				System.out.println("failed to rollback the transaction !");
			}
			throw ex; // OBSERVE HERE !!! we do not swallow the transaction exception in tre try catch - the use MUST be notified also!
		}finally{
			s.close();
			HibernateUtil.shutdown();
		}
	}
}
