package org.mseco.learning.hibernate2.inheritance.tablePerConcreteClassWithUnions;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

@MappedSuperclass
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@TableGenerator(name="billingDetailsGenerator",pkColumnName="generatorName",valueColumnName="lastValue",table="generatorTable")
public abstract class BillingDetails {
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
