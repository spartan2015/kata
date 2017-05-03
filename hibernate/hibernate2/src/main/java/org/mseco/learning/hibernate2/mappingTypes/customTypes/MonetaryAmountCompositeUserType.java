package org.mseco.learning.hibernate2.mappingTypes.customTypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

public class MonetaryAmountCompositeUserType implements CompositeUserType {

	public Object assemble(Serializable cached, SessionImplementor session,
			Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable disassemble(Object value, SessionImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object deepCopy(Object value) throws HibernateException {
		MonetaryAmount original = (MonetaryAmount) value;
		MonetaryAmount ma = new MonetaryAmount();
		ma.setAmount(new BigDecimal(original.getAmount().doubleValue()));
		ma.setCurrency(Currency.getInstance(original.getCurrency()
				.getCurrencyCode()));
		return ma;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == null)
			return false;
		return x.equals(y);
	}

	public String[] getPropertyNames() {

		return new String[] { "amount", "currency" };
	}

	public Type[] getPropertyTypes() {

		return new Type[] { Hibernate.BIG_DECIMAL, Hibernate.STRING };
	}

	public Object getPropertyValue(Object component, int property)
			throws HibernateException {
		MonetaryAmount ma = (MonetaryAmount) component;
		switch (property) {
		case 0:
			return ma.getAmount();
		case 1:
			return ma.getCurrency().getCurrencyCode();
		}
		return null;
	}

	public void setPropertyValue(Object component, int property, Object value)
			throws HibernateException {
		MonetaryAmount ma = (MonetaryAmount)component;
		switch(property){
		case 0: ma.setAmount((BigDecimal)value);
		case 1: ma.setCurrency(Currency.getInstance((String)value));
		}
	}

	public int hashCode(Object x) throws HibernateException {
		return 0;
	}

	public boolean isMutable() {
		return true;
	}

	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {

		BigDecimal amount = rs.getBigDecimal(names[0]);
		if (rs.wasNull())
			return null;
		MonetaryAmount ma = new MonetaryAmount();
		ma.setAmount(amount);
		ma.setCurrency(Currency.getInstance(rs.getString(names[1])));

		return ma;
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		if (value == null)
			return;
		MonetaryAmount ma = (MonetaryAmount) value;
		if (ma.getAmount() != null) {
			st.setBigDecimal(index, ma.getAmount());
		} else {
			st.setNull(index, Hibernate.STRING.sqlType());
		}
		if (ma.getCurrency() != null)
			st.setString(index + 1, ma.getCurrency().getCurrencyCode());
		else {
			st.setNull(index + 1, Hibernate.BIG_DECIMAL.sqlType());
		}
	}

	public Object replace(Object original, Object target,
			SessionImplementor session, Object owner) throws HibernateException {
		throw new IllegalArgumentException("NOT IMPLEMENTED !");
	}

	public Class returnedClass() {
		return MonetaryAmount.class;
	}

}
