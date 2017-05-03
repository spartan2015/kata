package org.mseco.learning.hibernate2.mappingTypes.customTypes;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Currency;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

public class MonetaryAmountUserType implements UserType{

	/*
	 * The assemble() method does the opposite of disassembly: It can transform
cached data into an instance of MonetaryAmount.


	 * (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable, java.lang.Object)
	 */
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		
		return null;
	}
	
	/*
	 * The disassemble() method is called when Hibernate puts a MonetaryAmount
into the second-level cache. As you’ll learn later, this is a cache of data that stores
information in a serialized form.

	 * (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
	 */
	public Serializable disassemble(Object value) throws HibernateException {		
		return null;
	}
		
	/*
	 * The UserType is also partially responsible for creating a snapshot of a value in the
first place.


	 * (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
	 */
	public Object deepCopy(Object value) throws HibernateException {		
		return value; // @FIXME - bad implementation - should make a deep copy
	}	

	/*
	 * The UserType is responsible for dirty checking property values. The equals()
method compares the current property value to a previous snapshot and deter-
mines whether the property is dirty and must by saved to the database. The hash-
Code() of two equal value typed instances has to be the same. We usually delegate
this method to the actual value type class—in this case, the hashCode() method of
the given MonetaryAmount object


	 * (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
	 */
	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y) return true;
		if (x == null || y == null) return false;
		return x.equals(y);
	}

	public int hashCode(Object x) throws HibernateException {		
		return 0;
	}

	/*
	 * Hibernate can make some minor performance optimizations for immutable types
like this one, for example, when comparing snapshots during dirty checking.

	 * (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#isMutable()
	 */
	public boolean isMutable() {		
		return true;
	}

	/*
	 * The nullSafeGet() method retrieves the property value from the JDBC Result-
Set. You can also access the owner of the component if you need it for the conver-
sion. 

		(non-Javadoc)
	 * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], java.lang.Object)
	 */
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		System.out.println("public Object nullSafeGet(ResultSet rs, String[] names, Object owner)");
		System.out.println("names: " + Arrays.toString(names));
		
		MonetaryAmount ma = new MonetaryAmount();
		ma.setAmount(rs.getBigDecimal(names[0]));
		// Deferred check after first read
		if (rs.wasNull()) return null;
		
		String currencyCode = rs.getString(names[1]);
		if (currencyCode != null){
			ma.setCurrency(Currency.getInstance(currencyCode));
		}
		return ma;
	}

	/*
	 * The nullSafeSet() method writes the property value to the JDBC Prepared-
Statement.

	 * (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int)
	 */
	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
				
		if (value == null){
			st.setNull(index, Hibernate.BIG_DECIMAL.sqlType());
			st.setNull(index+1, Hibernate.STRING.sqlType());
		}else{
			MonetaryAmount ma = (MonetaryAmount)value;
			st.setBigDecimal(index, ma.getAmount());
			st.setString(index+1, ma.getCurrency().getCurrencyCode());
		}
		
	}

	/*
	 * Implement replace() to handle merging of detached object state. As you’ll see
later in the book, the process of merging involves an original and a target object,
whose state must be combined. Again, for immutable value types, return the first
argument. For mutable types, at least return a deep copy of the first argument.
For mutable types that have component fields, you probably want to apply a recur-
sive merging routine.


	 * (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		System.err.println("replace(Object original, Object target, Object owner) not implemented");
		return null;
	}

	/*
	 * The returnedClass() method tells Hibernate what Java value type class is
mapped by this UserType


	 * (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#returnedClass()
	 */
	public Class returnedClass() {		
		return MonetaryAmount.class;
	}

	/*
	 * The sqlTypes() method tells Hibernate what SQL column types to use for
DDL schema generation.

	 * (non-Javadoc)
	 * @see org.hibernate.usertype.UserType#sqlTypes()
	 */
	public int[] sqlTypes() {		
		return new int[]{Hibernate.BIG_DECIMAL.sqlType(), Hibernate.STRING.sqlType()};
	}

}