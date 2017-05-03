package learning.hibernate.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 *                               By default, Hibernate interprets a java.util.Date as
a timestamp mapping. You need to explicitly specify type="time" or type="date"
if you don’t wish to persist both date and time information.
     With JPA annotations, the mapping type of a property is automatically
detected, just like in Hibernate. For a java.util.Date or java.util.Calendar
property, the Java Persistence standard requires that you select the precision with
a @Temporal annotation:

 */
@Entity
public class DateTimeValueExample {
	@Id
	Long id;
	
	@Temporal(TemporalType.DATE /*TIME|TIMESTAMP*/)
	Date date;
}
