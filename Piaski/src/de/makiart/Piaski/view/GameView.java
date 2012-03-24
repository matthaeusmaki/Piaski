package de.makiart.Piaski.view;

import de.makiart.engine.view.AbstractView;
import de.makiart.engine.view.Square;
import de.makiart.engine.view.ViewComponent;

public class GameView extends AbstractView {
	
	private ViewComponent mSquare;
	
	public GameView() {
		mSquare = new Square();
		addComponent(mSquare);	
	}	
}