package database.ibatis;

import java.io.Reader;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import database.beans.Motorist;

public class PlainIBatis {
	private static SqlMapClient sqlMapClient;
	static{
		try{
			String resource = "database/ibatis/sql-map-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
		
	public static SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public static void main(String[] args) throws Exception{
		Motorist motorist = new Motorist();
		motorist.setEmail("bunica@gmail.com");
		motorist.setPassword("bunica@gmail.com");
		motorist.setFirstName("bunica@gmail.com");
		motorist.setLastName("bunica@gmail.com");
		
		sqlMapClient.insert("insertMotorist", motorist);
		
		List<Motorist> motorists = (List<Motorist>) sqlMapClient.queryForList("getMotorists", null);
				
		for(Motorist m : motorists){
			System.out.println(m.getEmail());
		}
		
		System.out.println("Query for just one:");
		
		Motorist moto = (Motorist)sqlMapClient.queryForObject("getMotorist", 1);
		System.out.println(moto.getEmail());
		
	}

}
