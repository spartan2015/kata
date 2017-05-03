package learning.hibernate.entities;


import javax.persistence.Id;

@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
public class DynamicInsertAndUpdate {
	@Id
	Long id;
}
