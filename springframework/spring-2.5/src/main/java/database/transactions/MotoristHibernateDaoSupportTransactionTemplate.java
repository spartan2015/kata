package database.transactions;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springmodules.cache.annotations.CacheFlush;
import org.springmodules.cache.annotations.Cacheable;

import database.beans.Motorist;

public class MotoristHibernateDaoSupportTransactionTemplate extends HibernateDaoSupport {

	private TransactionTemplate transactionTemplate;
		
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@CacheFlush(modelId="motoristCacheModelId")
	public void saveMotorist(final Motorist motorist){
	
		transactionTemplate.execute(new TransactionCallback(){

			public Object doInTransaction(TransactionStatus status) {
				try{
					
					getHibernateTemplate().save(motorist);
					
				}catch(Exception ex){
					status.setRollbackOnly();
				}
				return null;
			}
			
		});		
	}

	@Cacheable(modelId="motoristFlushModelId")
	@SuppressWarnings("unchecked")
	public List<Motorist> getMotorists(){
		return (List<Motorist>)getHibernateTemplate().loadAll(Motorist.class);
	}
	
	
	
}
