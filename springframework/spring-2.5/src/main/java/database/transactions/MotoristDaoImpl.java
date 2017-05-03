package database.transactions;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import database.beans.Motorist;

@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class MotoristDaoImpl extends HibernateDaoSupport implements MotoristDao {
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveMotorist(final Motorist motorist) {
		getHibernateTemplate().save(motorist);
	}

	@SuppressWarnings("unchecked")
	public List<Motorist> getMotorists() {
		return (List<Motorist>) getHibernateTemplate().loadAll(Motorist.class);
	}

}
