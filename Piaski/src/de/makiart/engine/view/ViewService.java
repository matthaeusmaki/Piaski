package de.makiart.engine.view;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import de.makiart.engine.AbstractService;

public class ViewService extends AbstractService {

	public static final String NAME = "ViewService";
	private GL10 mGl;
	private int mWidth;
	private int mHeight;
	
	private ArrayList<AbstractView> mViewList = new ArrayList<AbstractView>();
	
	public ViewService(int width, int height) {
		super(NAME);
		mWidth = width;
		mHeight = height;
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
	
	public void setGL(GL10 gl) {
		mGl = gl;
	}

	@Override
	public void update() {
		super.update();
		mGl.glViewport(0, 0, mWidth, mHeight);		
		mGl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		for(AbstractView view : mViewList) {
			view.drawAll(mGl);
		}
	}
}
