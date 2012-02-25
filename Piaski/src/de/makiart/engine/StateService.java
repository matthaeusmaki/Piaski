package de.makiart.engine;

import java.util.HashMap;


public class StateService extends AbstractService{

	private HashMap<String, IState> mStateMap = new HashMap<String, IState>();
	private IState mCurrentState;
	
	public IState getCurrentState() {
		return mCurrentState;
	}

	public void setCurrentState(IState state) {
		mCurrentState = state;
	}

	public StateService(String name) {
		super(name);
	}
	
	public void addState( String name, IState state) {
		mStateMap.put(name, state);
	}
	
	public void removeState( String name) {
		mStateMap.remove(name);
	}
	
	
}
