package learning.hibernate.entities.associations.advanced.oneToOneWitIntermediateTable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name="item_shipment")
public class ShipementVariant2 {
	@Id
	Long id;
	
	@OneToOne
	@JoinColumn(table="item_shipment",name="item_id")
	Item item;
}
