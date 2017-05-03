package learning.hibernate.entities.associations.advanced.oneToManyWithIntermediateTable;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Buyer {
	@Id
	Long id;
	
	@OneToMany(mappedBy="buyer")
	Set<Item> boughtItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
}
