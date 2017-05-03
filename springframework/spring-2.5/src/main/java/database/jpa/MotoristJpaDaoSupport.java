package database.jpa;

import java.util.List;

import org.springframework.orm.jpa.support.JpaDaoSupport;

import database.beans.Motorist;

public class MotoristJpaDaoSupport extends JpaDaoSupport {
	public void saveMotorist(Motorist motorist) {
		getJpaTemplate().persist(motorist);
	}

	@SuppressWarnings("unchecked")
	public List<Motorist> getMotorists() {
		return (List<Motorist>) getJpaTemplate().find("from Motorist");
	}
}
