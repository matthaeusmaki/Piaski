package de.makiart.engine.view;

public abstract class Button implements IButton {
	
	private int mTop;
	private int mBottom;
	private int mLeft;
	private int mRight;
	private String mName;
	
	public Button(String name) {
		//	Für Clickevent-listener registrieren
		mName	=	name;
		addToListener();
	}

	/**
	 * Prozedur was passieren soll wenn der Button betätigt wird.
	 * 
	 */
	public void onClicked() {
		// TODO Auto-generated method stub

	}
	
	
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
