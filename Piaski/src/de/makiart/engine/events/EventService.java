package de.makiart.engine.events;

import java.util.ArrayList;

import de.makiart.engine.AbstractService;

import android.util.Log;


/**
 * 
 * @author uNreaL
 *
 */
public class EventService extends AbstractService {

	public static final String NAME = "EventService";
	
	private ArrayList<IEventListener> mListenerList = new ArrayList<IEventListener>();
	public enum EventType { SimpleEvent1, SimpleEvent2, ChangeStateEvent };
	private ArrayList<IEvent> mEventList	=	new ArrayList<IEvent>();
	

	public EventService() {		
		super(NAME);
		Log.d(NAME, NAME + " wurde aufgerufen");
	}
	
	public void addListener( IEventListener listener) {
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
	
	public IEventListener getListener( String name ) {
		int index = findListener(name);
		if ( index >= 0) {
			return mListenerList.get(index);
		}	
		Log.e("EventService.getListener", "Eventlistener (" + name + ") nicht gefunden! " ); 
		throw new RuntimeException();		
	}
	
	public void dispatchEvent(IEvent e) {
		Log.d("EventService.dispatch", "dispatch: " + e.getType() );
		mEventList.add(e);
	}
	
	@Override
	public void update() {
		for (int j = 0; j < mEventList.size(); j++)
		{
			IEvent e = mEventList.get(j);
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
