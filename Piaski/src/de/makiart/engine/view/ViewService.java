package de.makiart.engine.view;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;

import de.makiart.engine.AbstractService;

public class ViewService extends AbstractService implements Renderer {

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
		
	}

	public void onDrawFrame(GL10 gl) {
		gl.glViewport(0, 0, mWidth, mHeight);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		for(AbstractView view : mViewList) {
			view.drawAll(gl);
		}
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		mWidth = width;
		mHeight = height;
		gl.glViewport(0, 0, width, height);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//		gl.glOrthof(mWidth/2, mWidth/2, mHeight/2, mHeight/2, 10, -100);
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glViewport(0, 0, mWidth, mHeight);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//		gl.glOrthof(mWidth/2, mWidth/2, mHeight/2, mHeight/2, 10, -100);
	}
}
