package de.makiart.engine.view;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public abstract class AbstractView {

	private ArrayList<ViewComponent> mComponentList = new ArrayList<ViewComponent>();
	
	public void addComponent(ViewComponent component) {
		mComponentList.add(component);
	}
	
	public void removeAllComponents() {
		mComponentList.clear();
	}
	
	public void drawAll(GL10 gl) {
		for(ViewComponent c : mComponentList) {
			c.draw(gl);
		}
	}
}
