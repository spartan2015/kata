package org.mseco.learning.hibernate2.start;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;

public class AppHibernate {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // one Session per thread
		Transaction tx = session.beginTransaction();
		
		Message m = new Message();
		m.setText("first message");
		
		Long id = (Long) session.save(m);
		
		tx.commit();
		session.close();
		
		// second session
		
		Session secondSession = HibernateUtil.getSessionFactory().openSession();
		Transaction secondTx = secondSession.beginTransaction();
		
		List<Message> messages = (List<Message>) secondSession.createCriteria(Message.class).list();
		
		for(Message message : messages){
			System.out.println("message: " + message.getText());
		}
		
		secondTx.commit();
		secondSession.close();
		
		
		Session session3 = HibernateUtil.getSessionFactory().openSession();
		Transaction tx3 = session3.beginTransaction();
		
		Message m3 = (Message)session3.get(Message.class, Long.valueOf(1));
		m3.setText("Greetings Earthling");
		Message nm = new Message();
		nm.setText("Take me to your leader");
		m3.setNextMessage(nm);
		
		tx3.commit(); //automatic dirty checking & cascade save 
		session3.close();
		
			
		
		
		Session session4 = HibernateUtil.getSessionFactory().openSession();
		session4.beginTransaction();
		Message mes = (Message)session4.load(Message.class, Long.valueOf(1));
		mes.setText("new text 111");
		
		/*
		 * simulate an optmistic locking failure
		 * */
		Session session5 = HibernateUtil.getSessionFactory().openSession();
		session5.beginTransaction();
		
		Message mes2 = (Message)session5.load(Message.class, Long.valueOf(1));
		mes2.setText("new text 222");
		session5.getTransaction().commit();
		session5.close();
		/* sym end*/
		
		try{
		session4.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		session4.close();
		
		
		Statistics stats = HibernateUtil.getSessionFactory().getStatistics();
		stats.logSummary();
		
		EntityStatistics es = stats.getEntityStatistics("org.mseco.learning.hibernate2.start.Message");
		System.out.println("es.getFetchCount()" + es.getFetchCount());
		System.out.println("es.getInsertCount()" + es.getInsertCount());
		System.out.println("es.getDeleteCount()" + es.getDeleteCount());
		System.out.println("es.getUpdateCount()" + es.getUpdateCount());
		System.out.println("es.getOptimisticFailureCount()" +  es.getOptimisticFailureCount());
		
		
		HibernateUtil.shutdown();
	}
}
