package de.makiart.engine.events;

import de.makiart.engine.events.EventService.EventType;

public class SimpleEvent implements IEvent {
	
	private EventType TYPE = EventType.SimpleEvent1;
	
	public EventType getType() {
		return TYPE;
	}
	
	public String foo() {
		return "Hello there!"; // todo: events testen
	}

}
