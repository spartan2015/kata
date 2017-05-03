package org.mseco.learning.jsf;

import java.util.Date;

public class Bean {
	String name = "neo";
	Date date = new Date();
	Double doubleNumber = 1001.123456;
	
	
	
	public Double getDoubleNumber() {
		return doubleNumber;
	}

	public void setDoubleNumber(Double doubleNumber) {
		this.doubleNumber = doubleNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
