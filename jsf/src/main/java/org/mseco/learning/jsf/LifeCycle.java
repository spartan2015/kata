package org.mseco.learning.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LifeCycle {
	LifeCycle(){
		// lifecycle.addPhaseListener() - insa cum obtii referinta pt current lifeCycle ?
		new PhaseListener(){

			public void afterPhase(PhaseEvent event) {				
				System.out.println("" + event.getPhaseId());
			}

			public void beforePhase(PhaseEvent event) {			
				
			}

			public PhaseId getPhaseId() {
				
				return PhaseId.ANY_PHASE;
			}
			
		};
		
	}
}
