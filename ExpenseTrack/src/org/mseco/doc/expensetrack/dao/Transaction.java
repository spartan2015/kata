package org.mseco.doc.expensetrack.dao;

public class Transaction {
	long id;
	long value;
	long typeId;
	String typeAsString;
	String date;
	String location;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getTypeAsString() {
		return typeAsString;
	}

	public void setTypeAsString(String typeAsString) {
		this.typeAsString = typeAsString;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
