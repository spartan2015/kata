package security.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import security.entities.User;

public class UserDao extends HibernateDaoSupport{
	
	public User getUserByUsername(final String username){
		return (User)getHibernateTemplate().execute(new HibernateCallback(){
			@SuppressWarnings("unchecked")
			public Object doInHibernate(Session session){
				Query query = session.createQuery("select * from User where username = ?");
				query.setString(1, username);
				List<User> users = (List<User>)query.list();
				
				return users.size() > 0 ? users.get(0) :null;
			}
		});
	} 

}
