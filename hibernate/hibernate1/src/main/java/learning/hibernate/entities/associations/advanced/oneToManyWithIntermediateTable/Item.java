package learning.hibernate.entities.associations.advanced.oneToManyWithIntermediateTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	Long id;

	/*
At the time of writing, this mapping has the limitation that you can’t set it to
optional="true"; hence, the USER_ID column is nullable. If you try to add a nul-
lable="false" attribute on the @JoinColumn, Hibernate Annotations thinks that
you want the whole buyer property to never be null. Furthermore, the primary
key of the join table is now the ITEM_ID column only. This is fine, because you
don’t want duplicate items in this table—they can be bought only once.

	 */
	@ManyToOne
	@JoinTable(name = "bough_items", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "buyer_id"))
	Buyer buyer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

}
