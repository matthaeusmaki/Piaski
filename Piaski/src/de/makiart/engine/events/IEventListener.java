package de.makiart.engine.events;

import java.util.ArrayList;

import de.makiart.engine.events.EventService.EventType;

public interface IEventListener {

	public void onHandle( IEvent e );
	public String getName();
	public ArrayList<EventType> getHandableEvents();
}
