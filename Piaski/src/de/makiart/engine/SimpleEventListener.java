package de.makiart.engine;

import java.util.ArrayList;

import de.makiart.engine.EventService.EventType;

public class SimpleEventListener implements IEventListener{

	private ArrayList<EventType> mHandableEvents	=	new ArrayList<EventType>();
	private String NAME = "SimpleEventListener";
	
	public SimpleEventListener( ) {
		mHandableEvents.add( EventService.EventType.SimpleEvent1);
	}
	
	public void onHandle(IEvent e) {
		if (e.getType() == EventType.SimpleEvent1) {
			System.out.println(((SimpleEvent) e).foo());			
		}		
	}
	
	public ArrayList<EventType> getHandableEvents() {
		return mHandableEvents;
	}

	public String getName() {
		return NAME;
	}
	
	
}
