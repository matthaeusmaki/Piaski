package de.makiart.engine;

import java.util.HashMap;


public class StateService extends Service{

	private HashMap<String, State> mStateMap = new HashMap<String, State>();
	private State mCurrentState;
	
	public State getCurrentState() {
		return mCurrentState;
	}

	public void setCurrentState(State state) {
		mCurrentState = state;
	}

	public StateService(String name) {
		super(name);
	}
	
	public void addState( String name, State state) {
		mStateMap.put(name, state);
	}
	
	public void removeState( String name) {
		mStateMap.remove(name);
	}
	
	
}
