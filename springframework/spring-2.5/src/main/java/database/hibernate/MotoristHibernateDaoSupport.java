package database.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springmodules.cache.annotations.CacheFlush;
import org.springmodules.cache.annotations.Cacheable;

import database.beans.Motorist;

public class MotoristHibernateDaoSupport extends HibernateDaoSupport {

	@CacheFlush(modelId="motoristCacheModelId")
	public void saveMotorist(Motorist motorist){
		getHibernateTemplate().save(motorist);
	}

	@Cacheable(modelId="motoristFlushModelId")
	@SuppressWarnings("unchecked")
	public List<Motorist> getMotorists(){
		return (List<Motorist>)getHibernateTemplate().loadAll(Motorist.class);
	}
	
}
