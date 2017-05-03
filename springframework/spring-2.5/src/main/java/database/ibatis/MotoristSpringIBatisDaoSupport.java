package database.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import database.beans.Motorist;

public class MotoristSpringIBatisDaoSupport extends SqlMapClientDaoSupport {
	
	@SuppressWarnings("unchecked")
	public List<Motorist> getMotorists() {
		return (List<Motorist>) getSqlMapClientTemplate()
				.queryForList("getMotorists");
	}

	public Motorist getMotoristById(Integer id) {
		return (Motorist) getSqlMapClientTemplate()
				.queryForObject("getMotorist", id);
	}

	public void saveMotorist(Motorist motorist) {
		getSqlMapClientTemplate().insert("insertMotorist", motorist);
	}

	public void deleteMotorist(Motorist motorist) {
		getSqlMapClientTemplate().delete("deleteMotorist", motorist);
	}
}
