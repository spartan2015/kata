package org.mseco.learning.hibernate2.associations.optionalOneToOneBetweenThreeTables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name="secondaryTable") //VARIANTA 3: ONE TO ONE WITH A SECONDARY TABLE - WHEN YOU NEED MORE THAN ONE COLUMN MAPPING IN THE SECONDARY TABLE
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	//VARIANTA 1: oneToOne where only the two extremes are Entities: with JoinTable
	@ManyToOne(optional=true)
	@JoinTable(name="assignment_jointable",joinColumns=@JoinColumn(name="desk_id"),inverseJoinColumns=@JoinColumn(name="person_id"))
	private Desk desk;

	
	//VARIANTA 2: oneToOne where all three tables are entities - it's a split: first one-to-one (1 with2); second one-to-one(2 with 3)
	@OneToOne(mappedBy="person")	
	private Assignment assignment;
	
	@OneToOne
	@JoinColumn(table="secondaryTable")
	private Desk secondDesk;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public Desk getSecondDesk() {
		return secondDesk;
	}

	public void setSecondDesk(Desk secondDesk) {
		this.secondDesk = secondDesk;
	}
	
	
}
