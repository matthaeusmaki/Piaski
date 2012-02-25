package de.makiart.engine;

import de.makiart.engine.EventService.EventType;

public class SimpleEvent implements IEvent {
	
	private EventType TYPE = EventType.SimpleEvent1;
	
	public EventType getType() {
		return TYPE;
	}
	
	public String foo() {
		return "Hello there!"; // todo: events testen
	}

}
