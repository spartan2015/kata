package database.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import database.beans.Motorist;

public class MotoristHibernateDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void saveMotorist(Motorist motorist){
		hibernateTemplate.save(motorist);
	}

	@SuppressWarnings("unchecked")
	public List<Motorist> getMotorists(){
		return (List<Motorist>)hibernateTemplate.loadAll(Motorist.class);
	}
}
