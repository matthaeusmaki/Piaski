package de.makiart.engine;

import de.makiart.engine.EventService.EventType;

public class SimpleEvent implements Event {
	
	private EventType TYPE = EventType.SimpleEvent1;
	
	public EventType getType() {
		return TYPE;
	}
	
	public String foo() {
		return "Hello there!"; // todo: events testen
	}

}
