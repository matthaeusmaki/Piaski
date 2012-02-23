package de.makiart.engine;

public abstract class Service {
	
	public enum Status { STOPPED, STARTED, PAUSED };		
	private Status mCurrentStatus; 
	private String mName;

	public Service(String name) {
		mName = name;
		stop();
	}
	
	public Status getStatus() {
		return mCurrentStatus;
	}
	
	public String getName() {
		return mName;		
	}
	
	public void start() {
		mCurrentStatus = Status.STARTED;
	}
	
	public void stop() {
		mCurrentStatus = Status.STOPPED;		
	}
	
	public void pause() {
		mCurrentStatus = Status.PAUSED;		
	}
	
	public void resume() {
		mCurrentStatus = Status.STARTED;		
	}
	
	public void update() {
		
	}
	
	
}
