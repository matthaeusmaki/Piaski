package de.makiart.engine;

import java.util.ArrayList;

import de.makiart.engine.EventService.EventType;

public interface EventListener {

	public void onHandle( Event e );
	public String getName();
	public ArrayList<EventType> getHandableEvents();
}
