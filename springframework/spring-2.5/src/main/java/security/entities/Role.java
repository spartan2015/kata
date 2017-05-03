package security.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.GrantedAuthority;

@SuppressWarnings("serial")
@Entity
public class Role implements GrantedAuthority{
	@Id
	@Column
	private String role;

	public Role(){}
	
	public Role(String role){
		this.role = role; 
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAuthority() {		
		return role;
	}

	public int compareTo(Object other) {		
		return role != null ? role.compareTo(other.toString()) : -1;
	}
	
	public String toString(){
		return role;
	}
}
