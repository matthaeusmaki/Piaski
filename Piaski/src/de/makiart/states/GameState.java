package de.makiart.states;

import java.util.ArrayList;

import android.util.Log;
import de.makiart.engine.EventService;
import de.makiart.engine.IEvent;
import de.makiart.engine.IState;
import de.makiart.engine.ServiceLocator;
import de.makiart.engine.StateService;
import de.makiart.engine.EventService.EventType;

public class GameState implements IState {

	private static final String NAME = "GameState";
	private ServiceLocator mCore;
	private ArrayList<EventType> mHandableEvents	=	new ArrayList<EventType>();

	public GameState(ServiceLocator core) {
		mHandableEvents.add(EventService.EventType.SimpleEvent1);
		mCore = core;
	}
	
	public String getName() {
		return NAME;
	}

	public void onEnter() {
		Log.d("GameState.onEnter", "Game state starts");
	}

	public void onExit() {
		Log.d("GameState.onExit", "Game state ends");
	}

	public void onHandle(IEvent e) {
		if (e.getType() == EventType.SimpleEvent1) {
			((StateService) mCore.getService("StateService")).changeState("MenuState");		
		}
	}

	public ArrayList<EventType> getHandableEvents() {
		return mHandableEvents;
	}

}
