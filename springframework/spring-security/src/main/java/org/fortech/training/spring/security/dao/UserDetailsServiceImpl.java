package org.fortech.training.spring.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@PersistenceContext
	EntityManager entityManager;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Query query = entityManager.createQuery("select u from User u where u.username = ?");
		query.setParameter(1, username);
		List<User> users = query.getResultList();
		return users.size() == 1 ? users.get(0) : null;
	}
	
	@Secured("ADMIN")
	public void getPassword(){
		
	}

}
