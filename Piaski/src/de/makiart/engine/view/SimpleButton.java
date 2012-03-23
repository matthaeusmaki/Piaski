package de.makiart.engine.view;

import android.util.Log;

public class SimpleButton extends Button {
	
	public SimpleButton(String name, float[] vertices) {
		super(name, vertices);
	}
	
	public void onClicked() {
		Log.i("[Button.onClicked]", getName() + " wurde gedrückt!");
	}

	public void removeToListener() {
		// TODO Auto-generated method stub
		
	}

}
