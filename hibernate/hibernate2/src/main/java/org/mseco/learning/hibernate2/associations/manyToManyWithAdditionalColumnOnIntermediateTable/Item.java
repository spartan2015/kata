package org.mseco.learning.hibernate2.associations.manyToManyWithAdditionalColumnOnIntermediateTable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {
	@Id
	private Long id;
	
	@OneToMany
	private Set<CategorizedItem> categorizedItems = new HashSet<CategorizedItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<CategorizedItem> getCategorizedItems() {
		return categorizedItems;
	}

	public void setCategorizedItems(Set<CategorizedItem> categorizedItems) {
		this.categorizedItems = categorizedItems;
	}	
		
}
