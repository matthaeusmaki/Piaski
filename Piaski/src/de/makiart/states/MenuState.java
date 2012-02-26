package de.makiart.states;

import java.util.ArrayList;

import android.util.Log;
import de.makiart.engine.EventService;
import de.makiart.engine.EventService.EventType;
import de.makiart.engine.IEvent;
import de.makiart.engine.IEventListener;
import de.makiart.engine.IState;
import de.makiart.engine.ServiceLocator;
import de.makiart.engine.StateService;

public class MenuState implements IState, IEventListener {

	private static final String NAME = "MenuState";
	private ArrayList<EventType> mHandableEvents	=	new ArrayList<EventType>();
	private ServiceLocator mCore;
	
	public MenuState(ServiceLocator core) {
		mHandableEvents.add(EventService.EventType.SimpleEvent1);
		mCore = core;
	}
	
	public String getName() {
		return NAME;
	}

	public void onEnter() {
		Log.d("MenuState.onEnter", "Menu state starts");
		((EventService) mCore.getService("EventService")).addListener(this);
	}

	public void onExit() {
		Log.d("MenuState.onExit", "Menu state ends");
		((EventService) mCore.getService("EventService")).removeListener(NAME);
	}

	public void onHandle(IEvent e) {
		if (e.getType() == EventType.SimpleEvent1) {
			((StateService) mCore.getService("StateService")).changeState("GameState");		
		}
	}

	public ArrayList<EventType> getHandableEvents() {
		return mHandableEvents;
	}

}
