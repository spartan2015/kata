package org.mseco.learning.hibernate2.transactions;

public class TransactionIsolationIssues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		
		1. Lost Update - no locking system is used - two different transaction modify the same row but the last rollsback wich causes both transaction values to be lost
		2. Dirty Read - if one transaction can read the uncommitted values of another
		3. Unrepeatable read - if the same transaction ready a row two times and each time is different
			- causes - Second Lost Updates - well Unrepeatable is real a problem here. It may allow working with a stale value - BAD - you can overwrite another transaction - BAD
		4. Phantom read - execute a query twice - rows appear or disappear - no particular danger here, but if you use count or sum on many rows - you can have stale values
		
		ANSI ISOLATION LEVELS:
		
		I. READ UNCOMMITED - solves Lost Updates only - by exclusive write locks - wich is good
		II. READ COMMITED - solves Lost Update and Dirty reads - un uncommited writing transaction block everyone else from reading that row
		III. Repeatable Read - solves Lost Updates, Dirty Reads and Unrepeatable read 
		IV. Serializable
		
		 Serializable is the word from Scalability point of view - UNACCEPTABLE - ONLY IN VERY SPECIAL CIRCUMSTANCES - (finance?)!!! 
		 //you could REPLACE this mode with LOCKING, forcing a serialization only a particular code
		 
		 BEST is Repeatable Read - you MUST AVOID Second Lost updateas !!!! - This is no problem with Hibernate With Optmistic Locking with Versioning
		 
		 		
		Setting an isolation level
		
		Every JDBC connection to a database is in the default isolation level of the DBMS. Usually read committed or repeatable read.
		hibernate.connection.isolation = 4
		
		  1—Read uncommitted isolation
  		  2—Read committed isolation
    	  4—Repeatable read isolation
  		  8—Serializable isolation

	
		Note that Hibernate never changes the isolation level of connections obtained
from an application server-provided database connection in a managed environ-
ment! You can change the default isolation using the configuration of your appli-
cation server. (The same is true if you use a stand-alone JTA implementation.)

	- p 458


		 */

	}

}
