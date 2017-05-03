package security.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {

	@ManyToOne
	private User user;
	@ManyToOne
	private Role role;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}	
}
