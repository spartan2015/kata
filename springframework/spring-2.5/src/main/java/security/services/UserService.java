package security.services;

import org.springframework.security.userdetails.UserDetailsService;

import security.dao.UserDao;
import security.entities.User;

public class UserService implements UserDetailsService{
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User loadUserByUsername(String username){
		return userDao.getUserByUsername(username);
	}
}
