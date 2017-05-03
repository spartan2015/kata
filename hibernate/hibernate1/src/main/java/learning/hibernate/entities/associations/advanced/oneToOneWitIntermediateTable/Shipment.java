package learning.hibernate.entities.associations.advanced.oneToOneWitIntermediateTable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Shipment {
	
	@Id
	@Column(name="shipment_id")
	Long id;
	
	
	@OneToOne
	@JoinTable(name="item_shipment",joinColumns=@JoinColumn(name="shipment_id"),inverseJoinColumns=@JoinColumn(name="item_id"))
	Item item;
	/*
	 *     Alternatively, you can map properties of a JPA entity to more than one table,
as demonstrated in “Moving properties into a secondary table” in chapter 8,
section 8.1.3. First, you need to declare the secondary table for the entity:
   @Entity
   @Table(name = "SHIPMENT")
   @SecondaryTable(name = "ITEM_SHIPMENT")
   public class Shipment {
Note that the @SecondaryTable annotation also supports attributes to declare the
foreign-key column name—the equivalent of the <key column="..."/> you saw
earlier in XML and the joinColumn(s) in a @JoinTable. If you don’t specify it, the
primary-key column name of the entity is used—in this case, again SHIPMENT_ID.
    The auction property mapping is a @OneToOne; and as before, the foreign key
column referencing the ITEM table is moved to the intermediate secondary table:
   ...
   public class Shipment {
        ...
        @OneToOne
        @JoinColumn(table = "ITEM_SHIPMENT", name = "ITEM_ID")
        private Item auction;
   }

	 */
}
