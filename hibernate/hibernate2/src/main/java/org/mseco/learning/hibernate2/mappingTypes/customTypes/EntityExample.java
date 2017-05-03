package org.mseco.learning.hibernate2.mappingTypes.customTypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
public class EntityExample {
	@Id
	private Long id;

	@Type(type = "org.mseco.learning.hibernate2.mappingTypes.customTypes.MonetaryAmountUserType")
	@Columns(columns = { @Column(name = "amount"), @Column(name = "currency") })
	private MonetaryAmount ma;

	@Type(type = "org.mseco.learning.hibernate2.mappingTypes.customTypes.MonetaryAmountCompositeUserType")
	@Columns(columns = { @Column(name = "amount1"), @Column(name = "currency1") })
	private MonetaryAmount maComposite;

	@Type(type = "org.mseco.learning.hibernate2.mappingTypes.customTypes.MonetaryAmountParameterizedType"
		, parameters = { 
			@Parameter(name = "convertTo", value = "USD") 
			})
	@Columns(columns = { @Column(name = "amount2"), @Column(name = "currency2") })
	private MonetaryAmount maParameterized;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MonetaryAmount getMa() {
		return ma;
	}

	public void setMa(MonetaryAmount ma) {
		this.ma = ma;
	}

	public MonetaryAmount getMaComposite() {
		return maComposite;
	}

	public void setMaComposite(MonetaryAmount maComposite) {
		this.maComposite = maComposite;
	}

	public MonetaryAmount getMaParameterized() {
		return maParameterized;
	}

	public void setMaParameterized(MonetaryAmount maParameterized) {
		this.maParameterized = maParameterized;
	}
}
