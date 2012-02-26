package de.makiart.engine.events;

import de.makiart.engine.events.EventService.EventType;

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
