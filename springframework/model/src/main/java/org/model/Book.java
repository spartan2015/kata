/*
 * Copyright 2007 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */

package org.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Book implements Serializable {
	private Long bookId;
	private String description;
	private String firstName;
	private String surname;
	private String title;
	private boolean onSale;
	private float price;
	private int calendar_year;
	private int inventory;

	public Book() {
	}

	public Book(Long bookId, String surname, String firstName, String title, float price, boolean onSale,
			int calendar_year, String description, int inventory) {
		this.bookId = bookId;
		this.title = title;
		this.firstName = firstName;
		this.surname = surname;
		this.price = price;
		this.onSale = onSale;
		this.calendar_year = calendar_year;
		this.description = description;
		this.inventory = inventory;
	}

	@Id
	public Long getBookId() {
		return this.bookId;
	}

	public String getTitle() {
		return this.title;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getSurname() {
		return this.surname;
	}

	public float getPrice() {
		return this.price;
	}

	public boolean getOnSale() {
		return this.onSale;
	}

	public int getCalendar_year() {
		return this.calendar_year;
	}

	public String getDescription() {
		return this.description;
	}

	public int getInventory() {
		return this.inventory;
	}

	public void setBookId(Long id) {
		this.bookId = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	public void setCalendar_year(int calendar_year) {
		this.calendar_year = calendar_year;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
}
