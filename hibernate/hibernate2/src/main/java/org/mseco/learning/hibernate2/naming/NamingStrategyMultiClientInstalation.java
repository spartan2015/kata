package org.mseco.learning.hibernate2.naming;

import org.hibernate.cfg.ImprovedNamingStrategy;


@SuppressWarnings("serial")
public class NamingStrategyMultiClientInstalation extends ImprovedNamingStrategy{

	private String tablePrefix; 
	public NamingStrategyMultiClientInstalation(String tablePrefix){
		this.tablePrefix = tablePrefix;
	}
	// if you don't specify the table name
	@Override
	public String classToTableName(String className) {
		// TODO Auto-generated method stub
		return tablePrefix + super.classToTableName(className);
	}

	// if you don't specify the column name
	@Override
	public String propertyToColumnName(String propertyName) {
		// TODO Auto-generated method stub
		return super.propertyToColumnName(propertyName);
	}
	
	// if you specify the table name
	@Override
	public String tableName(String tableName) {
		// TODO Auto-generated method stub
		return tablePrefix + super.tableName(tableName);
	}
	
	// if you specify the column name
	@Override
	public String columnName(String columnName) {
		// TODO Auto-generated method stub
		return super.columnName(columnName);
	}

}
