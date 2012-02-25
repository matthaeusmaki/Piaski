package de.makiart.engine;

import java.util.ArrayList;

import de.makiart.engine.EventService.EventType;

public interface IEventListener {

	public void onHandle( IEvent e );
	public String getName();
	public ArrayList<EventType> getHandableEvents();
}
