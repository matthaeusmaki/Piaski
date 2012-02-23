package de.makiart.engine;

import java.util.ArrayList;

import android.util.Log;


/**
 * 
 * @author uNreaL
 *
 */
public class EventService extends Service {
	// private HashMap<String, EventListener> mListenerMap = new HashMap<String, EventListener>();
	private ArrayList<EventListener> mListenerList = new ArrayList<EventListener>();
	public enum EventType { SimpleEvent1, SimpleEvent2 };
	private ArrayList<Event> mEventList	=	new ArrayList<Event>();
	

	public EventService() {		
		super("EventService");
		Log.d("EventService", "EventService wurde aufgerufen");
	}
	
	public void addListener( EventListener listener) {
		Log.d("EventService", "Add EventListener: " + listener.getName() );
		mListenerList.add( listener);
	}
	
	public void removeListener( String name) {
		int index = findListener(name);
		if ( index >= 0) {
			mListenerList.remove(index);
			return;
		}	
		Log.e("EventService.removeListener", "Eventlistener (" + name + ") nicht gefunden! " ); 
		throw new RuntimeException();
	}
	
	public EventListener getListener( String name ) {
		int index = findListener(name);
		if ( index >= 0) {
			return mListenerList.get(index);
		}	
		Log.e("EventService.getListener", "Eventlistener (" + name + ") nicht gefunden! " ); 
		throw new RuntimeException();		
	}
	
	public void dispatchEvent(Event e) {
		Log.d("EventService.dispatch", "dispatch: " + e.getType() );
		mEventList.add(e);
	}
	
	@Override
	public void update() {
		for (int j = 0; j < mEventList.size(); j++)
		{
			Event e = mEventList.get(j);
			for ( int i = 0; i < mListenerList.size(); i++)
			{
				if (mListenerList.get(i).getHandableEvents().contains(e.getType()) )
				{
					mListenerList.get(i).onHandle(e);			
				}
			}	
		}
		mEventList.clear();
	}
	
	/**
	 * Durchsucht die internen ListenerList nach dem übergebenen Namen und gibt den Index zurück.
	 * Wenn nicht gefunden wird "-1" zurückgegeben
	 * @param name Name des Listeners
	 * @return Index in der internen ListenerList 
	 */
	private int findListener(String name) {
		for ( int i = 0; i < mListenerList.size(); i++)
		{
			if ( mListenerList.get(i).getName().equals(name) ) {				
				return i;
			}
		}
		return -1;
	}
	
	
}
