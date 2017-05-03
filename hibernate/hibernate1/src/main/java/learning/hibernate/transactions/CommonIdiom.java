package learning.hibernate.transactions;

import learning.hibernate.app.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommonIdiom {
	public static void main(String args[]){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		try{
		// to the work here
			
		// at the end
			tx.commit();
		}catch(RuntimeException re){
			try{
				tx.rollback();
			}catch(RuntimeException re1){
				// log the inability to rollback the transaction
			}
			throw re;
		}finally{
			session.close();
		}
		
	}
}
