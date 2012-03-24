package de.makiart.Piaski.states;

import java.util.ArrayList;

import android.util.Log;
import de.makiart.Piaski.view.GameView;
import de.makiart.engine.ServiceLocator;
import de.makiart.engine.events.ChangeStateEvent;
import de.makiart.engine.events.EventService;
import de.makiart.engine.events.EventService.EventType;
import de.makiart.engine.events.IEvent;
import de.makiart.engine.events.IEventListener;
import de.makiart.engine.state.IState;
import de.makiart.engine.state.StateService;
import de.makiart.engine.view.ViewService;

public class GameState implements IState, IEventListener {

	public static final String NAME = "GameState";
	private ServiceLocator mCore;
	private ArrayList<EventType> mHandableEvents	=	new ArrayList<EventType>();
	private GameView mView;

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
		((ViewService) mCore.getService(ViewService.NAME)).addView(new GameView());
	}

	public void onExit() {
		Log.d("GameState.onExit", "Game state ends");
		((EventService) mCore.getService("EventService")).removeListener(NAME);
		((ViewService) mCore.getService(ViewService.NAME)).removeAllViews();
	}

	public void onHandle(IEvent e) {
		if (e.getType() == EventType.SimpleEvent1) {
			((StateService) mCore.getService("StateService")).changeState("GameState");		
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
