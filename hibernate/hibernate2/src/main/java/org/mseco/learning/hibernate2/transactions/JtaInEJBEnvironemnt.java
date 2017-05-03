package org.mseco.learning.hibernate2.transactions;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.InitialContext;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;

@Stateless
@Local
@TransactionManagement(TransactionManagementType.BEAN)
public class JtaInEJBEnvironemnt {
	
	private static final Logger log = Logger.getLogger(JtaTransactionTest.class);
	
	public void doATransaction() throws Exception{		
		UserTransaction ux = null;
		try{
			 ux = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
			
			ux.begin();
			
			ux.commit();
		}catch(Exception ex){
			try{
				ux.rollback();
			}catch(Exception ex2){
				log.error("rollback failure", ex);
			}
			throw ex;
		}
	}
}
