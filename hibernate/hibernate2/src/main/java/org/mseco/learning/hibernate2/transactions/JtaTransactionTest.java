package org.mseco.learning.hibernate2.transactions;

import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.mseco.learning.hibernate2.start.HibernateUtil;

public class JtaTransactionTest {

	private static final Logger log = Logger.getLogger(JtaTransactionTest.class);
	
	public static void main(String[] args) throws Exception{
		UserTransaction ux = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try{
			ux.begin();
						
			// your code here
			
			ux.commit();			
		}catch(RuntimeException re){
			try{
				ux.rollback();
			}catch(RuntimeException tre){
				log.error("failed to rollback transaction !",tre);
			}
			throw re; // OBSERVE HERE !!! we do not swallow the transaction exception in tre try catch - the use MUST be notified also!
		}finally{
			session.close();
			HibernateUtil.shutdown();
		}
	}

}
