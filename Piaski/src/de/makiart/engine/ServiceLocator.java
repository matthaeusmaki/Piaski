package de.makiart.engine;

import java.util.HashMap;


import android.util.Log;

public class ServiceLocator {

	private HashMap<String, AbstractService> mServiceMap = new HashMap<String, AbstractService>();
		
	public void update(long deltatime) {
		for ( String key : mServiceMap.keySet()) {
			mServiceMap.get(key).update();
		}
	}
	
	public void addService( AbstractService service) {
		Log.d("ServiceLocator.addService", "Füge Service hinzu '" + service.getName()  + "'");
		mServiceMap.put(service.getName(), service);
	}
	
	public AbstractService getService( String name ) {
		Log.d("ServiceLocator.getService", "Lese Service '" + name  + "'");
		return mServiceMap.get(name);
	}
	
	public void removeService( String name) {
		Log.d("ServiceLocator.removeService", "Entferne Service '" + name  + "'");
		mServiceMap.remove(name);
	}
	
	public void removeAllServices() {
		Log.d("ServiceLocator.removeAllServices", "Entferne alle Services");
		mServiceMap.clear();
	}
	
}
