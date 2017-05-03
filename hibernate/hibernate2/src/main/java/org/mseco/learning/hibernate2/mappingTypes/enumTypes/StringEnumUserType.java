package org.mseco.learning.hibernate2.mappingTypes.enumTypes;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;

public class StringEnumUserType implements EnhancedUserType, ParameterizedType {

	/*
	 * The following three methods are part of the EnhancedUserType and are used for
XML marshalling.
	- p 236
	
	 * (non-Javadoc)
	 * @see org.hibernate.usertype.EnhancedUserType#fromXMLString(java.lang.String)
	 */
	public Object fromXMLString(String xmlValue) {
		
		return Enum.valueOf(clazz, xmlValue);
	}

	public String objectToSQLString(Object value) {

		return "'" + ((Enum)value).name() + "'";
	}

	public String toXMLString(Object value) {
		
		return ((Enum)value).name();
	}

	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		
		return null;
	}

	public Object deepCopy(Object value) throws HibernateException {
		
		return value;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		
		return null;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		
		return x == y;
	}

	public int hashCode(Object x) throws HibernateException {
		
		return 0;
	}

	public boolean isMutable() {
		
		return false;
	}

	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		String name = rs.getString(names[0]);
		if (rs.wasNull()) return null;
		return Enum.valueOf(clazz, name);
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
		if (value == null){
			st.setNull(index, Hibernate.STRING.sqlType());
		}else{
			Enum en = (Enum)value;
			st.setString(index, en.name());			
		}		
	}

	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		
		return null;
	}

	public Class returnedClass() {
		
		return clazz;
	}

	public int[] sqlTypes() {
		
		return new int[]{Hibernate.STRING.sqlType()};
	}

	private Class clazz;
	public void setParameterValues(Properties parameters) {
		try {
			clazz = Class.forName(parameters.getProperty("class"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
