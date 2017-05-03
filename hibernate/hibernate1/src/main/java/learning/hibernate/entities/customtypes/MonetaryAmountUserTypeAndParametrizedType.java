package learning.hibernate.entities.customtypes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Currency;
import java.util.Locale;
import java.util.Properties;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

/**
 * you can specify in mapping in what currency you store the MonetaryAmount
 *
 */
public class MonetaryAmountUserTypeAndParametrizedType implements UserType, ParameterizedType {

	/**
	 * 1.
	 * 
	 * The sqlTypes() method tells Hibernate what SQL column types to use for
DDL schema generation. Notice that this method returns an array of type
codes. A UserType may map a single property to multiple columns, but this
legacy data model has only a single numeric column. By using the Hiber-
nate.BIG_DECIMAL.sqlType() method, you let Hibernate decide the exact SQL
datatype for the given database dialect. Alternatively, return a constant from
java.sql.Types.

	 * 
	 * @see org.hibernate.usertype.UserType#sqlTypes()
	 */
	public int[] sqlTypes() {
		return new int[] { Hibernate.BIG_DECIMAL.sqlType() };
	}

	/**
	 * 2.
	 * 
	 * The returnedClass() method tells Hibernate what Java value type class is
mapped by this UserType.

	 */
	public Class returnedClass() {
		return MonetaryAmount.class;
	}

	/**
	 * 3.
	 * 
	 * Hibernate can make some minor performance optimizations for immutable types
like this one, for example, when comparing snapshots during dirty checking. The
isMutable() method tells Hibernate that this type is immutable.

	 */
	public boolean isMutable() {
		return false;
	}

	/**
	 * 4. make a deep copy or just return it - by default we return it
	 * 
	 * The UserType is also partially responsible for creating a snapshot of a value in the
first place. Because MonetaryAmount is an immutable class, the deepCopy()
method returns its argument. In the case of a mutable type, it would need to
return a copy of the argument to be used as the snapshot value.

	 */
	public Object deepCopy(Object value) throws HibernateException {
		// if the class were mutable - we could serialize it in a ByteArrayOutputStream 
		// and then deserialize it
		// to get the deepCopy		
		return value;
	}

	/**
	 * 5.
	 * 
	 * The disassemble() method is called when Hibernate puts a MonetaryAmount
into the second-level cache. As you’ll learn later, this is a cache of data that stores
information in a serialized form.

	 */
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	/**
	 * 6.
	 * 
	 * The assemble() method does the opposite of disassembly: It can transform
cached data into an instance of MonetaryAmount. As you can see, implementation
of both routines is easy for immutable types.

	 */
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	/**
	 * 7.
	 * 
	 * Implement replace() to handle merging of detached object state. As you’ll see
later in the book, the process of merging involves an original and a target object,
whose state must be combined. Again, for immutable value types, return the first
argument. For mutable types, at least return a deep copy of the first argument.
For mutable types that have component fields, you probably want to apply a recur-
sive merging routine.

	 */
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {		
		return original;
	}

	/**
	 * 8.
	 * 
	 *   The UserType is responsible for dirty checking property values. The equals()
method compares the current property value to a previous snapshot and deter-
mines whether the property is dirty and must by saved to the database. The hash-
Code() of two equal value typed instances has to be the same. We usually delegate
this method to the actual value type class—in this case, the hashCode() method of
the given MonetaryAmount object.

	 */
	public boolean equals(Object a, Object b) throws HibernateException {
		if (a == b) return false;
		if (a==null || b==null) return false;
		
		return a.equals(b);
	}
	
	public int hashCode(Object x) throws HibernateException {		
		return x.hashCode();
	}

	/**
	 * this assumes that we store monetary amount as one colon of BigDecimal - the amount is in USD 
	 * 
	 * this convert type just does the conversion automaticly for the user
	 * 
	 * 
	 * The nullSafeGet() method retrieves the property value from the JDBC Result-
Set. You can also access the owner of the component if you need it for the conver-
sion. All database values are in USD, so you convert it to the currency the user has
currently set in his preferences. (Note that it’s up to you to implement this con-
version and preference handling.)

	 * 9. 
	 */
	public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner)
			throws HibernateException, SQLException {
		System.out.println("nullSafeGet");
		System.out.println("names" +  Arrays.toString(names));
		
		BigDecimal amount = resultSet.getBigDecimal(names[0]); // from first <column name="" /> 
		System.out.println("valueInUSD=" + amount);
		// Deffered check after first read
		if (resultSet.wasNull()) return null;
				
		MonetaryAmount ma= new MonetaryAmount(amount, tableSpecificConfigurableCurrency);
		
		Currency convertToCurrency = Currency.getInstance(Locale.JAPAN);
		
		return ma.convertTo(convertToCurrency);
		
	}

	/**
	 * 10. this just convert to USD and sets the amount on the PreparedStatement for Update or Insert
	 * 
	 * The nullSafeSet() method writes the property value to the JDBC Prepared-
Statement. This method takes whatever currency is set and converts it to a simple
BigDecimal USD amount before saving.

<property name="initialPrice"
          column="INITIAL_PRICE"
          type="persistence.MonetaryAmountUserType"/>

@org.hibernate.annotations.Type(
    type = " persistence.MonetaryAmountUserType"
)
@Column(name = "INITIAL_PRICE")
private MonetaryAmount initialPrice;

	 */
	public void nullSafeSet(PreparedStatement statement, Object value, int index)
			throws HibernateException, SQLException {
		if (value == null){
			statement.setNull(index, Hibernate.BIG_DECIMAL.sqlType());			
		}else{
			MonetaryAmount anyCurrency = (MonetaryAmount)value;
			
			MonetaryAmount inOurTableSpecificCurrency = anyCurrency.convertTo(tableSpecificConfigurableCurrency);
			
			statement.setBigDecimal(index, inOurTableSpecificCurrency.getAmount());
		} 
	}

	private Currency tableSpecificConfigurableCurrency;
	
	/**
	 * <property name="initialPrice">
    
    <type name="persistence.MonetaryAmountConversionType">
        <param name="convertTo">USD</param>
    </type>
</property>


What we show here is a binding of a custom mapping type with some arguments
to the names monetary_amount_usd and monetary_amount_eur. This definition
can be placed anywhere in your mapping files; it’s a child element of <hibernate-
mapping> (as mentioned earlier in the book, larger applications have often one or
several MyCustomTypes.hbm.xml files with no class mappings).

<typedef class="persistence.MonetaryAmountConversionType"
           name="monetary_amount_usd">
    <param name="convertTo">USD</param>
</typedef>
<typedef class="persistence.MonetaryAmountConversionType"
           name="monetary_amount_eur">
    <param name="convertTo">EUR</param>
</typedef>


   @org.hibernate.annotations.TypeDefs({
       @org.hibernate.annotations.TypeDef(
            name="monetary_amount_usd",
            typeClass = persistence.MonetaryAmountConversionType.class,
            parameters = { @Parameter(name="convertTo", value="USD") }
       ),
       @org.hibernate.annotations.TypeDef(
            name="monetary_amount_eur",
            typeClass = persistence.MonetaryAmountConversionType.class,
            parameters = { @Parameter(name="convertTo", value="EUR") }
       )
   })
This annotation metadata is global as well, so it can be placed outside any Java
class declaration (right after the import statements) or in a separate file, pack-
age-info.java, as discussed in chapter 2, section 2.2.1, “Using Hibernate Anno-
tations.” A good location in this system is in a package-info.java file in the
persistence package.

    In XML mapping files and annotation mappings, you now refer to the defined
type name instead of the fully qualified class name of your custom type:
   <property name="initialPrice"
              type="monetary_amount_usd">
        <column name="INITIAL_PRICE"/>
        <column name="INITIAL_PRICE_CUR"/>
   </property>
   @org.hibernate.annotations.Type(type = "monetary_amount_eur")
   @org.hibernate.annotations.Columns({
      @Column(name = "BID_AMOUNT"),
      @Column(name = "BID_AMOUNT_CUR")
   })
   private MonetaryAmount bidAmount;


	 */
	public void setParameterValues(Properties props) {
		tableSpecificConfigurableCurrency = Currency.getInstance(props.getProperty("convertTo"));		
	}
}
