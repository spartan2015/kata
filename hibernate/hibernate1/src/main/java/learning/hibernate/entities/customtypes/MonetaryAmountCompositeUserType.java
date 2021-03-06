package learning.hibernate.entities.customtypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Currency;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.type.Type;
import org.hibernate.usertype.CompositeUserType;

/**
 * <property name="initialPrice"
          type="persistence.MonetaryAmountCompositeUserType">
	    <column name="INITIAL_PRICE"/>
	    <column name="INITIAL_PRICE_CURRENCY"/>
   </property>
   
   @org.hibernate.annotations.Type(
    type = "persistence.MonetaryAmountUserType"
)
@org.hibernate.annotations.Columns(columns = {
    @Column(name="INITIAL_PRICE"),
    @Column(name="INITIAL_PRICE_CURRENCY", length = 2)
})

 */
public class MonetaryAmountCompositeUserType implements CompositeUserType {
	/**
	 * 1.
	 * 
	 * The sqlTypes() method tells Hibernate what SQL column types to use for
	 * DDL schema generation. Notice that this method returns an array of type
	 * codes. A UserType may map a single property to multiple columns, but this
	 * legacy data model has only a single numeric column. By using the Hiber-
	 * nate.BIG_DECIMAL.sqlType() method, you let Hibernate decide the exact SQL
	 * datatype for the given database dialect. Alternatively, return a constant
	 * from java.sql.Types.
	 * 
	 * 
	 * @see org.hibernate.usertype.UserType#sqlTypes()
	 */
	public int[] sqlTypes() {
		return new int[] { Hibernate.BIG_DECIMAL.sqlType(), Hibernate.STRING.sqlType() };
	}

	/**
	 * 2.
	 * 
	 * The returnedClass() method tells Hibernate what Java value type class is
	 * mapped by this UserType.
	 */
	public Class returnedClass() {
		return MonetaryAmount.class;
	}

	/**
	 * 3.
	 * 
	 * Hibernate can make some minor performance optimizations for immutable
	 * types like this one, for example, when comparing snapshots during dirty
	 * checking. The isMutable() method tells Hibernate that this type is
	 * immutable.
	 */
	public boolean isMutable() {
		return false;
	}

	/**
	 * 4. make a deep copy or just return it - by default we return it
	 * 
	 * The UserType is also partially responsible for creating a snapshot of a
	 * value in the first place. Because MonetaryAmount is an immutable class,
	 * the deepCopy() method returns its argument. In the case of a mutable
	 * type, it would need to return a copy of the argument to be used as the
	 * snapshot value.
	 */
	public Object deepCopy(Object value) throws HibernateException {
		// if the class were mutable - we could serialize it in a
		// ByteArrayOutputStream
		// and then deserialize it
		// to get the deepCopy
		return value;
	}

	/**
	 * 5.
	 * 
	 * The disassemble() method is called when Hibernate puts a MonetaryAmount
	 * into the second-level cache. As you’ll learn later, this is a cache of
	 * data that stores information in a serialized form.
	 */
	public Serializable disassemble(Object value,  SessionImplementor arg1) throws HibernateException {
		return (Serializable) value;
	}

	/**
	 * 6.
	 * 
	 * The assemble() method does the opposite of disassembly: It can transform
	 * cached data into an instance of MonetaryAmount. As you can see,
	 * implementation of both routines is easy for immutable types.
	 */
	public Object assemble(Serializable cached, SessionImplementor arg1, Object owner)
			throws HibernateException {
		return cached;
	}

	/**
	 * 7.
	 * 
	 * Implement replace() to handle merging of detached object state. As you’ll
	 * see later in the book, the process of merging involves an original and a
	 * target object, whose state must be combined. Again, for immutable value
	 * types, return the first argument. For mutable types, at least return a
	 * deep copy of the first argument. For mutable types that have component
	 * fields, you probably want to apply a recur- sive merging routine.
	 */
	public Object replace(Object original, Object target, SessionImplementor arg1, Object owner)
			throws HibernateException {
		return original;
	}

	/**
	 * 8.
	 * 
	 * The UserType is responsible for dirty checking property values. The
	 * equals() method compares the current property value to a previous
	 * snapshot and deter- mines whether the property is dirty and must by saved
	 * to the database. The hash- Code() of two equal value typed instances has
	 * to be the same. We usually delegate this method to the actual value type
	 * class—in this case, the hashCode() method of the given MonetaryAmount
	 * object.
	 */
	public boolean equals(Object a, Object b) throws HibernateException {
		if (a == b)
			return false;
		if (a == null || b == null)
			return false;

		return a.equals(b);
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	/**	 
	 * 
	 * The nullSafeGet() method retrieves the property value from the JDBC
	 * Result- Set. You can also access the owner of the component if you need
	 * it for the conver- sion. All database values are in USD, so you convert
	 * it to the currency the user has currently set in his preferences. (Note
	 * that it’s up to you to implement this con- version and preference
	 * handling.)
	 * 
	 * 9.
	 */
	public Object nullSafeGet(ResultSet resultSet, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		System.out.println("nullSafeGet");
		System.out.println("names" + Arrays.toString(names));

		BigDecimal amount = resultSet.getBigDecimal(names[0]); // from first
																	// <column
																	// name=""
																	// />
		Currency currency = Currency.getInstance(resultSet.getString(names[1]));
		
		System.out.println("amount=" + amount + " in " + currency);
		
		// Deffered check after first read
		if (resultSet.wasNull())
			return null;

		MonetaryAmount ma = new MonetaryAmount(amount, currency);

		
		return ma;

	}

	/**
	 * 10. this just convert to USD and sets the amount on the PreparedStatement
	 * for Update or Insert
	 * 
	 * The nullSafeSet() method writes the property value to the JDBC Prepared-
	 * Statement. This method takes whatever currency is set and converts it to
	 * a simple BigDecimal USD amount before saving.
	 * 
	 * <property name="initialPrice" column="INITIAL_PRICE"
	 * type="persistence.MonetaryAmountUserType"/>
	 * 
	 * @org.hibernate.annotations.Type( type =
	 *                                  " persistence.MonetaryAmountUserType" )
	 * @Column(name = "INITIAL_PRICE") private MonetaryAmount initialPrice;
	 */
	public void nullSafeSet(PreparedStatement statement, Object value, int index,SessionImplementor session)
			throws HibernateException, SQLException {
		if (value == null) {
			statement.setNull(index, Hibernate.BIG_DECIMAL.sqlType());
			statement.setNull(index+1, Hibernate.STRING.sqlType());
		} else {
			MonetaryAmount anyCurrency = (MonetaryAmount) value;						
			statement.setBigDecimal(index, anyCurrency.getAmount());
			statement.setString(index+1, anyCurrency.getCurrency().getCurrencyCode());
		}
	}

	/*
	 * 
	 * <property name="initialPrice"
          type="persistence.MonetaryAmountCompositeUserType">
    <column name="INITIAL_PRICE"/>
    <column name="INITIAL_PRICE_CURRENCY"/>
</property>

@org.hibernate.annotations.Type(
    type = "persistence.MonetaryAmountUserType"
)
@org.hibernate.annotations.Columns(columns = {
    @Column(name="INITIAL_PRICE"),
    @Column(name="INITIAL_PRICE_CURRENCY", length = 2)
})

	 */
	public String[] getPropertyNames() {
		
		return new String[]{"amount","currency"};
	}

	public Type[] getPropertyTypes() {		
		return new Type[]{Hibernate.BIG_DECIMAL,Hibernate.STRING};
	}

	public Object getPropertyValue(Object object, int index)
			throws HibernateException {
		MonetaryAmount ma = (MonetaryAmount)object;
		if (index == 0)
			return ma.getAmount();
		else
			return ma.getCurrency();
	}
	
	public void setPropertyValue(Object object, int index, Object propObject)
	throws HibernateException {
		throw new UnsupportedOperationException("Imuttable object. Can not modify it");
	}

}
