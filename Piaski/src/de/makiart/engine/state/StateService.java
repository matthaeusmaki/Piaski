package de.makiart.engine.state;

import java.util.HashMap;

import de.makiart.engine.AbstractService;

import android.util.Log;


public class StateService extends AbstractService{

	private static final String NAME = "StateService";
	private HashMap<String, IState> mStateMap = new HashMap<String, IState>();
	private IState mCurrentState;
	
	public StateService() {
		super(NAME);
	}
	
	public void changeState(String name) {
		if(mCurrentState != null) {
			Log.d("StateService.changeState", "change state " + mCurrentState.getName());
			mCurrentState.onExit();
		}
		mCurrentState = mStateMap.get(name);
		mCurrentState.onEnter();
		Log.d("StateService.changeState", "onEnter current state " + name);
	}
	
	public IState getCurrentState() {
		return mCurrentState;
	}

	public StateService(String name) {
		super(name);
	}
	
	public void addState(IState state) {
		mStateMap.put(state.getName(), state);
	}
	
	public void removeState( String name) {
		mStateMap.remove(name);
	}	
}
