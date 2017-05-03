package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminator")
@TableGenerator(name="billingDetailsGenerator",pkColumnName="generatorName",valueColumnName="lastValue",table="generatorTable")
public class BillingDetails {
	@Id
	@org.hibernate.annotations.GenericGenerator(name="billingDetailsGenerator", strategy="hilo",
	         parameters = {
	            @org.hibernate.annotations.Parameter(name="table", value = "ENTITY_HI_VALUES"),
	            @org.hibernate.annotations.Parameter(name="column", value = "HI"),
	            @org.hibernate.annotations.Parameter(name="max_lo", value = "5")
	         }
	   )
	@GeneratedValue(generator="billingDetailsGenerator")	
	private Long id;
	
	@Column
	private Date date;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}	
}
