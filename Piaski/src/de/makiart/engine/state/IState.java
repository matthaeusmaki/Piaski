package de.makiart.engine.state;

public interface IState {
	
	public String getName();
	public void onEnter();
	public void onExit();
	
}
