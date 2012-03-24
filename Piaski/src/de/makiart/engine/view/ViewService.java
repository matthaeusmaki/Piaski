package de.makiart.engine.view;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import android.util.Log;
import de.makiart.engine.AbstractService;

public class ViewService extends AbstractService {

	public static final String NAME = "ViewService";
	
	private ArrayList<AbstractView> mViewList = new ArrayList<AbstractView>();
	
	public ViewService() {
		super(NAME);
		Log.d("ViewServie", "ViewService wird erstellt!");
	}
	
	public void addView(AbstractView view) {
		mViewList.add(view);
	}
	
	public void removeAllViews() {
		for(AbstractView view : mViewList) {
			view.removeAllComponents();
		}
		mViewList.clear();
	}
	
	
	public void render(GL10 gl ) {
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		for(AbstractView view : mViewList) {
			view.drawAll(gl);
		}
	}

	
}
