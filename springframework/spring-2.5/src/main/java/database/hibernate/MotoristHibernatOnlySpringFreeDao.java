package database.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;

import database.beans.Motorist;

public class MotoristHibernatOnlySpringFreeDao {

	private SessionFactory sessionFactory;
		
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveMotorist(Motorist motorist){
		sessionFactory.getCurrentSession().save(motorist);
	}

	@SuppressWarnings("unchecked")
	public List<Motorist> getMotorists(){
		return (List<Motorist>)sessionFactory.getCurrentSession().find("from Motorist");
	}
}
