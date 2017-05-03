package org.mseco.learning.jsf.events;

import javax.faces.FactoryFinder;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;

public class PhaseApi implements PhaseListener{
	
	public PhaseApi(){
		LifecycleFactory lf = (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		Lifecycle lifecycle = lf.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
		
		lifecycle.addPhaseListener(this);
	}

	public void afterPhase(PhaseEvent e) {
		System.out.println("afterPhase: " + e.getPhaseId());
		
	}

	public void beforePhase(PhaseEvent e) {
		System.out.println("beforePhase: " + e.getPhaseId());
		
	}

	public PhaseId getPhaseId() {
		
		return PhaseId.ANY_PHASE;
	}

	
}
