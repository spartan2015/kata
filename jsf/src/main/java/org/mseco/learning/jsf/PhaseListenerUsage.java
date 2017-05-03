package org.mseco.learning.jsf;

import javax.faces.FactoryFinder;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;

public class PhaseListenerUsage {

	PhaseListenerUsage(){
		
		LifecycleFactory factory = (LifecycleFactory)
		   FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		Lifecycle l = factory.getLifecycle(
		                      LifecycleFactory.DEFAULT_LIFECYCLE);
	
		
		l.addPhaseListener(new PhaseListener(){

			public void afterPhase(PhaseEvent arg0) {
								
			}

			public void beforePhase(PhaseEvent arg0) {				
				
			}

			public PhaseId getPhaseId() {
				
				return PhaseId.ANY_PHASE;
			}
			
		});
	}
	
}
