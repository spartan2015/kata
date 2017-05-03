package security.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.userdetails.UserDetails;

@Entity
@Table(name="users")
public class User implements UserDetails{
	
	@Id
	@Column
	private String username;
	@Column
	private String password;
	/*@OneToMany(cascade=CascadeType.ALL,mappedBy="UserRole")
	private List<UserRole> userRoles;*/
	
	@ManyToMany(cascade=CascadeType.ALL)	
	private List<Role> roles;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public List<UserRole> getUserRoles() {
//		return userRoles;
//	}
//	public void setUserRoles(List<UserRole> userRoles) {
//		this.userRoles = userRoles;
//	}
	
	// UserDetails
	public GrantedAuthority[] getAuthorities() {
		List<GrantedAuthority> gr = new ArrayList<GrantedAuthority>();
//		for(UserRole ur : userRoles){
//			gr.add(ur.getRole());
//		}
		for(Role role : roles){
			gr.add(role);
		}
		return (GrantedAuthority[])gr.toArray();
	}
	public boolean isAccountNonExpired() {		
		return true;
	}
	public boolean isAccountNonLocked() {
		return true;
	}
	public boolean isCredentialsNonExpired() {	
		return true;
	}
	public boolean isEnabled() {
		return true;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
