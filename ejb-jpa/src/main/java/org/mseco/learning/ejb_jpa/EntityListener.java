package org.mseco.learning.ejb_jpa;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
/*
 * you bind it to an entity with annotations:
 * 
 * @EntityListeners(EntityListener.class)
 * 
 you can exclude superclass listeners or default listeners for a particular entity with the
@ExcludeSuperclassListeners and @ExcludeDefaultListeners annotations.

                          Triggered after an entity instance has been loaded with
@PostLoad
                          find() or getReference(), or when a Java Persistence
                          query is executed. Also called after the refresh() method is
                          invoked.
@PrePersist, @PostPersist Occurs immediately when persist() is called on an entity,
                          and after the database insert.
                          Executed before and after the persistence context is synchro-
@PreUpdate, @PostUpdate
                          nized with the database—that is, before and after flushing. Trig-
                          gered only when the state of the entity requires synchronization
                          (for example, because it’s considered dirty).
@PreRemove, @PostRemove   Triggered when remove() is called or the entity instance is
                          removed by cascading, and after the database delete.

 */
public class EntityListener {
	@PostLoad
	@PostPersist
	void notifyMeOnSave(Object entity){
		System.out.println("saved !");
	}
}
