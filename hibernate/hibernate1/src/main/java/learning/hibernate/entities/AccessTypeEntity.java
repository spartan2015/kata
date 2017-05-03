package learning.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.AccessType;

@Entity

/**
 * by default access type is determined by the position of the @id annotation: field | property (hibernate supports and noop and .class)
 * noop specifies a property that does NOT exist in the Java Class and can be used only in HQL queries
 */
@org.hibernate.annotations.AccessType("field") // custom hibernate annotation to specify access type: field, property, noop, Custom.class
public class AccessTypeEntity {
	@Id
	Long id;
}
