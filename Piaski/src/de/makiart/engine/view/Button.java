package de.makiart.engine.view;

import android.util.Log;

public abstract class Button extends Square implements IButton {
	
	private int mTop		=	0;
	private int mBottom		=	0;
	private int mLeft		=	0;
	private int mRight		=	0;
	private String mName;
	
	public Button(String name, float[] vertices) {
		super(vertices);
		
		//	Für Clickevent-listener registrieren
		mName	=	name;
		addToListener();
		
		int pointer = 0;
		for (int i = 0; i < vertices.length; i++) {
			
			if (pointer == 4) {
				pointer = 0;
			}
			
			if (pointer == 0) {		//	X-Achse
				
				if (vertices[i] < mLeft) {	
					mLeft = (int) vertices[i];
				}
				
				if (vertices[i] > mRight) {
					mRight = (int) vertices[i];					
				}
			}	
			
			if (pointer == 1) {		//	Y-Achse
				
				if (vertices[i] < mBottom) {
					mBottom = (int) vertices[i];
				}
				
				if (vertices[i] > mTop ) {
					mTop = (int) vertices[i];
				}
			}
			
			pointer++;
		}
		
		
	}

	/**
	 * Prozedur was passieren soll wenn der Button betätigt wird.
	 * 
	 */
	public void onClicked() {
		// TODO Auto-generated method stub
		

	}
	
	public String getName() {
		return mName;
	}
	
	private void setLeft	( int x ) 	{ 	mLeft 	= 	x;  }	
	private void setRight	( int x ) 	{ 	mRight 	= 	x;  }
	private void setTop		( int y ) 	{	mTop 	=	y;	}
	private void setBottom	( int y ) 	{	mBottom	=	y;	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isInRange(int x, int y) {
		if ( 
				(y < mTop) && (y > mBottom)
				&& ( x > mLeft) && ( x < mRight)
				) 
		{
			return true;
		}	else {
			return false;
		}
	}

	/**
	 * Registriert den Button im onTouchListener
	 */
	public void addToListener() {
		// TODO Auto-generated method stub

	}

	
	/**
	 * - Entfernt den Button vom Listener
	 * - Setzt sich selbst auf null
	 */
	public void remove() {
		// TODO Auto-generated method stub

	}

}
