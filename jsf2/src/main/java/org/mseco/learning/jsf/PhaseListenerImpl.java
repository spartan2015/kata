package org.mseco.learning.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseListenerImpl implements PhaseListener{

	public void afterPhase(PhaseEvent arg0) {
		System.out.println("phase: " + arg0.getPhaseId());
		
	}

	public void beforePhase(PhaseEvent arg0) {
		
		
	}

	public PhaseId getPhaseId() {

		return PhaseId.ANY_PHASE;
	}

}
