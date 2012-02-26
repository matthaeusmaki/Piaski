package de.makiart.engine;

public interface IState {
	
	public String getName();
	public void onEnter();
	public void onExit();
	
}
