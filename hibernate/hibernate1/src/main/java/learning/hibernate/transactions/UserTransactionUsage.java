package learning.hibernate.transactions;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.UserTransaction;

import org.hibernate.Session;

import learning.hibernate.app.HibernateUtil;

public class UserTransactionUsage {
	
	public static void main(String args[]) throws Exception{
		/*
		 you must configure hibernate.transaction.factory_class and hibernate.transaction.
manager_lookup_class for JTA and your environment, so that Hibernate can
interact with the transaction system internally.
		 */
		UserTransaction tx = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
		
		Session s1 = null;
		Session s2 = null;
		
		try{
			s1 = HibernateUtil.getSessionFactory().openSession();
			s2 = HibernateUtil.getSessionFactory().openSession();
			
			
			// with UserTransaction use MUST flush manually
			/*
			 *      With default settings, it’s also your responsibility to flush() each Session
manually to synchronize it with the database (to execute all SQL DML). The
Hibernate Transaction API did this automatically for you. You also have to close
all Sessions manually. On the other hand, you can enable the hibernate.trans-
action.flush_before_completion and/or the hibernate.transaction.auto_
close_session configuration options and let Hibernate take care of this for you
again—flushing and closing is then part of the internal synchronization proce-
dure of the transaction manager and occurs before (and after, respectively) the
JTA transaction ends. With these two settings enabled the code can be simplified
to the following:
Hibernate in Action p 446
			 */
			s1.flush();
			s2.flush();
			
			tx.commit();
		}catch(Exception ex){
			try{
				tx.rollback();
			}catch(Exception rbEx){
				//log the unability to rollback
			}
			throw ex;
		}finally{
			s1.close();
			s2.close();
		}
	}
}
