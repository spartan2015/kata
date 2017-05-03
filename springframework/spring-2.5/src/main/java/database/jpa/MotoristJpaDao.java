package database.jpa;

import java.util.List;

import org.springframework.orm.jpa.JpaTemplate;

import database.beans.Motorist;

public class MotoristJpaDao {

	private JpaTemplate jpaTemplate;

	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}
	
	public void saveMotorist(Motorist motorist){
		jpaTemplate.persist(motorist);
	}

	@SuppressWarnings("unchecked")
	public List<Motorist> getMotorists(){
		return (List<Motorist>)jpaTemplate.find("from Motorist");
	}
	
}
