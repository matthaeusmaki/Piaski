package de.makiart.engine;

import de.makiart.engine.EventService.EventType;

public class ChangeStateEvent implements IEvent {
	
	private EventType TYPE = EventType.ChangeStateEvent;
	private String mTarget;

	public EventType getType() {
		return TYPE;
	}
	
	public void setTarget(String Target) {
		mTarget 	=	Target;
	}
	
	public String getTarget() {
		return mTarget;
	}
	

}
