package de.makiart.states;

import java.util.ArrayList;

import android.util.Log;
import de.makiart.engine.ChangeStateEvent;
import de.makiart.engine.EventService;
import de.makiart.engine.EventService.EventType;
import de.makiart.engine.IEvent;
import de.makiart.engine.IEventListener;
import de.makiart.engine.IState;
import de.makiart.engine.ServiceLocator;
import de.makiart.engine.StateService;

public class GameState implements IState, IEventListener {

	private static final String NAME = "GameState";
	private ServiceLocator mCore;
	private ArrayList<EventType> mHandableEvents	=	new ArrayList<EventType>();

	public GameState(ServiceLocator core) {
		mHandableEvents.add(EventService.EventType.SimpleEvent1);
		mHandableEvents.add(EventService.EventType.ChangeStateEvent);
		mCore = core;
	}
	
	public String getName() {
		return NAME;
	}

	public void onEnter() {
		Log.d("GameState.onEnter", "Game state starts");
		((EventService) mCore.getService("EventService")).addListener(this);
	}

	public void onExit() {
		Log.d("GameState.onExit", "Game state ends");
		((EventService) mCore.getService("EventService")).removeListener(NAME);
	}

	public void onHandle(IEvent e) {
		if (e.getType() == EventType.SimpleEvent1) {
			((StateService) mCore.getService("StateService")).changeState("MenuState");		
		}
		
		if (e.getType() == EventType.ChangeStateEvent) {
			Log.d("MenuState.onHanlde", "Type: ChangeStateEvent");
			ChangeStateEvent se = (ChangeStateEvent) e;
			((StateService) mCore.getService("StateService")).changeState( se.getTarget() );		
		}
	}

	public ArrayList<EventType> getHandableEvents() {
		return mHandableEvents;
	}

}
