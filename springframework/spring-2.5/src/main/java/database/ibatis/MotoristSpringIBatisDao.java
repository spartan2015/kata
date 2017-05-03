package database.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import database.beans.Motorist;

public class MotoristSpringIBatisDao {

	private SqlMapClientTemplate sqlMapClientTemplate;

	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Motorist> getMotorists(){
		return (List<Motorist>)sqlMapClientTemplate.queryForList("getMotorists");
	}
	
	public Motorist getMotoristById(Integer id){
		return (Motorist)sqlMapClientTemplate.queryForObject("getMotorist",id);
	}
	
	public void saveMotorist(Motorist motorist){
		sqlMapClientTemplate.insert("insertMotorist",motorist);
	}
	
	public void deleteMotorist(Motorist motorist){
		sqlMapClientTemplate.delete("deleteMotorist",motorist);
	}
}
