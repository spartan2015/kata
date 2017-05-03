package security;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import security.dao.UserDao;
import security.entities.Role;
import security.entities.User;

public class SecurityExec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("security/security.xml");
		UserDao userDao = (UserDao)ctx.getBean("userDao");
		
//		deleteUsers(userDao);
//		createDatabaseUser(userDao);
		
		List<User> users = (List<User>)userDao.getHibernateTemplate().getSessionFactory().openSession().createQuery("select u from User u join u.roles role").list();
		System.out.println("Found: " + users.size());
		for(User user : users){
			System.out.println(user.getUsername() + "{" + user.getRoles() + "}");
		}
	}
	
	static void createDatabaseUser(UserDao userDao){
//		Role role = new Role();
//		role.setRole("admin");
//		
//		userDao.getHibernateTemplate().save(role);
//
//		
//		Role urole = new Role();
//		urole.setRole("user");
		
//		userDao.getHibernateTemplate().save(urole);
		
		Session session = userDao.getHibernateTemplate().getSessionFactory().openSession();
		session.beginTransaction();
		
		User adminUser = new User();
		adminUser.setUsername("admin");
		adminUser.setPassword("admin");
		ArrayList<Role> adminRoles = new ArrayList<Role>();
		adminRoles.add(new Role("admin"));
		adminUser.setRoles(adminRoles);
		session.persist(adminUser);
		
		
		
		User user1 = new User();
		user1.setUsername("user");
		user1.setPassword("user");
		ArrayList<Role> userRoles = new ArrayList<Role>();
		userRoles.add(new Role("user"));
		user1.setRoles(userRoles);
		session.persist(user1);
		
		session.getTransaction().commit();
//		UserRole ur = new UserRole();
//		ur.setUser(user);
//		ur.setRole(role);
//		
//		userDao.getHibernateTemplate().save(ur);
//		
//		UserRole ur1 = new UserRole();
//		ur1.setUser(user1);
//		ur1.setRole(urole);
//		
//		userDao.getHibernateTemplate().save(ur1);
				
		
		
	}
	static void deleteUsers(UserDao userDao){
		Session session = userDao.getHibernateTemplate().getSessionFactory().openSession();
		session.beginTransaction();
		
		
		List<User> users = (List<User>)session.createQuery("select u from User u").list();
				
		for(User user : users){
			session.delete(user);
		}
		
		session.getTransaction().commit();
		
	}
	
}
